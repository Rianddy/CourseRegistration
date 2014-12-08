/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import team.soa.cms.ws.permission.PermissionRequestService_Service;
import team.soa.cmsc.constant.Constant;

/**
 *
 * @author riand_000
 * 
 * This Servlet is for request permission and call service to set permission info into faculty queue
 */
public class RequestPermsServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/PermissionRequestService.wsdl")
    private PermissionRequestService_Service service;

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
        String stu_id = request.getParameter("stu_id");
        String class_id = request.getParameter("class_id");
        String faculty_email = request.getParameter("faculty_email");
        int status = prereqMsgQueue(stu_id, class_id, faculty_email);
        String stas = "";
        /**  please dispatch web page here with the status codes **/
        if(status%10==Constant.SUCCESS){
            stas = "Success";
            //System.out.println("Success!");
        }else if(status%10==Constant.PARTIAL_SUCCESS){
            stas = "Partial success! Please check!";
            //System.err.println("Partial success! Please check!");
        }else if(status%10==Constant.FAIL){
            stas = "Fail!";
            //System.err.println("Fail!!");
        }
        request.setAttribute("stas", stas+" reqest permission! You will receive an email about the decision.");
        request.getRequestDispatcher("/RequestPerms.jsp").forward(request, response);
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

    private int prereqMsgQueue(java.lang.String stuID, java.lang.String classID, java.lang.String faculty_email) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        team.soa.cms.ws.permission.PermissionRequestService port = service.getPermissionRequestServicePort();
        return port.prereqMsgQueue(stuID, classID, faculty_email);
    }

}
