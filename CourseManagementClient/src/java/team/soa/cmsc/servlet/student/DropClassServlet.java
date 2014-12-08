/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.servlet.student;

import Controllers.DropClassControler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.schema.dropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.CheckClasses.Classes;
import org.netbeans.xml.schema.dropclasses.DropClassesInput;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses.ClassResult;
import org.netbeans.xml.schema.studentinwaitlist.Waitlist;
import org.netbeans.xml.schema.studentinwaitlist.Waitlist.Student;
import team.soa.cms.mail.MailService_Service;
import team.soa.cms.ws.StudentDropClass_Service;

/**
 *
 * @author Edison Edited by Yaping Chen
 */
public class DropClassServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/MailService.wsdl")
    private MailService_Service service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/StudentDropClass.wsdl")
    private StudentDropClass_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //PrintWriter writer = response.getWriter();

            Map<String, String[]> params = request.getParameterMap();

            DropClassControler dropClassControler = new DropClassControler();
            DropClassesInput classes = new DropClassesInput();

            HttpSession session = request.getSession();
            String studentID = (String) session.getAttribute("stuID");
            ArrayList<String> classIDs = (ArrayList<String>) session.getAttribute("clsDropID");
            classes.setStudentid(Integer.parseInt(studentID));
            for (String classId : classIDs) {
                classes.getClassIds().add(Integer.parseInt(classId));
            }

            CheckClasses checkClasses = dropClassControler.isClassEnrolled(classes);

            DropStudentClasses finalResult = dropClassControler.studentDropClass(checkClasses);
            out.println(finalResult.getStudentid());
            for (ClassResult result : finalResult.getClassResult()) {
                out.println(result.getClassid());
                out.println(result.getReason());
                out.println(result.getResult());
            }
            Waitlist waitList = dropClassControler.getWaitingList(checkClasses, finalResult);

            System.out.println("waitlist");
            List<Student> list = waitList.getStudent();
            System.out.println("waitlist==" + list.size());

            for (Student stu : list) {
                System.out.println("StuId:" + stu.getStudentID() + " StuEmail:" + stu.getEmail() + " ClassId:" + stu.getClassID());
                String content = "As you are in the waitlist, someone dropped this class, so you have been enrolled into Class ID:" + stu.getClassID() + " automatically";
                dropConfirm(stu.getEmail(), content);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private int dropConfirm(java.lang.String studentEmail, java.lang.String permsContent) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        team.soa.cms.mail.MailService port = service_2.getMailServicePort();
        return port.dropConfirm(studentEmail, permsContent);
    }

}
