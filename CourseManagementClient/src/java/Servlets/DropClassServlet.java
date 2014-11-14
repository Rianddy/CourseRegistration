/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Controllers.DropClassControler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.schema.checkdropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclassinput.DropClassesInput;
import team.soa.cms.ws.StudentDropClass_Service;

/**
 *
 * @author Edison
 */
public class DropClassServlet extends HttpServlet {
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
            String queryString = "";
            for (String key : params.keySet()) {
                    String[] values = params.get(key);
                    for (int i = 0; i < values.length; i++) {
                            String value = values[i];
                            queryString += key + "=" + value + "&";
                    }
            }
            // 去掉最后一个空格
            queryString = queryString.substring(0, queryString.length() - 1);
            out.println("POST " + request.getRequestURL() + " " + queryString);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DropClassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DropClassServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            DropClassControler dropClassControler =new DropClassControler();
            DropClassesInput classes = new DropClassesInput();
            classes.setStudentid(1);
            List<Integer> classIds = classes.getClassIds();
            classIds.add(1002);
            classIds.add(1001);
            dropClassControler.isClassEnrolled(classes);
            
            //dropClassControler.isClassEnrolled(null);
            
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
