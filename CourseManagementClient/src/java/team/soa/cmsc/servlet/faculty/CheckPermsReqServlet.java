/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.servlet.faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import team.soa.cms.msgqueueservice.PermsReqMsgService_Service;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;

/**
 *
 * @author birui
 *
 * This Servlet is for faculty clicking the URL in their email and get the info from faculty queue and show the
 * permission info in the page
 */
public class CheckPermsReqServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/PermsReqMsgService.wsdl")
    private PermsReqMsgService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param permsId permission id
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String permsId = request.getParameter("permsId");
        List<StuClassInfoMQSerialObj> permsMsgList = new ArrayList<StuClassInfoMQSerialObj>();
        permsMsgList = getPermsInfo(permsId);
        request.setAttribute("permsId", permsId);
        request.setAttribute("PermsMsgList", permsMsgList);
        
        request.getRequestDispatcher("/CheckPermsReq.jsp").forward(request, response);
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

    private java.util.List<team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj> getPermsInfo(java.lang.String permsID) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service.getPermsReqMsgServicePort();
        return port.getPermsInfo(permsID);
    }

}
