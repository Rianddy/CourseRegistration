/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 * @author: KevinZhou
 */
package team.soa.cmsc.servlet.student;

import Controllers.ClassController;
import Controllers.PrereqController;
import Controllers.StudentController;
import Controllers.RegCheckController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import webservice.basic.Student;
//import webservice.checkregistration.*;
import webservice.prereqmeet.StudentClass;


@WebServlet(name = "StudentRegistration", urlPatterns = {"/StudentRegistration"})
public class StudentRegistration extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/RegCheckService.wsdl")
   // private RegCheckService_Service service;

    /**
     * This servlet is to check whether this student can register the classes he chose.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String studentId = request.getParameter("stuID");
        int stuID = Integer.valueOf(studentId);
        boolean studentValid = StudentController.studentIsValid(stuID);
        if (studentValid) {
            
            // Call web service to get student information
            Student student = StudentController.getStudentInfo(stuID);
            
            // Get all classes that the students want to register from request
            List<Integer> classIDList = new ArrayList<Integer>();
            
            // Get all premission codes asscociated with classId, if none, set as 0
            List<Integer> PremissionCodeList = new ArrayList<Integer>();
            
            int i = 0;            
            
            while (request.getParameter("class" + i) != null) {
                int PremissionCode = 0;
                if (request.getParameter("PremssionCode" + i) != null && !request.getParameter("PremssionCode" + i).equals("")) {
                    PremissionCode = Integer.valueOf(request.getParameter("PremssionCode" + i));
                }

                PremissionCodeList.add(PremissionCode);
                
                // Create current class information object

                // Get classid from request
                int classID = Integer.valueOf(request.getParameter("class" + i));

                classIDList.add(classID);
                i++;
            }
            StuRegCheckInfo srci = RegCheckController.checkStudentRegistration(stuID, classIDList, PremissionCodeList);
            // Redirect to successful page with some attributes
            request.setAttribute("StuRegCheckInfo", srci);
            request.getRequestDispatcher("/RegistrationResult.jsp").forward(request, response);

        } else {
            // TODO: return to fail page
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

}
