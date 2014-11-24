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
import javax.jms.Message;
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String permsId = request.getParameter("permsId");
        List<StuClassInfoMQSerialObj> permsMsgList = new ArrayList<StuClassInfoMQSerialObj>();
        permsMsgList = getPermsInfo(permsId);
        request.setAttribute("PermsMsgList", permsMsgList);

        /**
         * ************************************************Test*********************************************
         */
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Faculty check Permission Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Permission Request from " + permsMsgList.get(0).getStuname() + "</h1>");
            out.println("<h3>Request Permission for " + permsMsgList.get(0).getRequestclasslist().get(0).getCoursename() + "</h3>");
            out.println("<h3>Accept </h3>");
            out.println("<h3>Rejuct </h3>");
            out.println("</body>");
            out.println("</html>");
        }
        /**
         * ************************************************************************************************
         */
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
