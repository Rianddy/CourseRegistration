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
import team.soa.cms.msgqueueservice.PermsConfmMsgService_Service;
import team.soa.cms.msgqueueservice.PermsReqMsgService_Service;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;
import team.soa.cmsc.constant.Constant;
import webservice.basic.DAOService_Service;

/**
 *
 * @author birui
 * <p>This Servlet is for faculty who accepts or rejects the permission request and call service to set info into student queue</p>
 * 
 */
public class ConfirmPermsSerlvet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/PermsReqMsgService.wsdl")
    private PermsReqMsgService_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CourseManagementSystem/PermsConfmMsgService.wsdl")
    private PermsConfmMsgService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param status accept or reject
     * @param permsId permission id
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String status = request.getParameter("status"); // get accept or reject info from faculty
        String permsId = request.getParameter("permsId"); // get current permission id
        int queueStatus=0;
        List<StuClassInfoMQSerialObj> objList = new ArrayList<StuClassInfoMQSerialObj>();
        objList = consumeFalMsg(permsId); //consume and get object from faculty queu
        for (StuClassInfoMQSerialObj obj : objList) {
            queueStatus+=setPermsConfirm(permsId, status, obj);
        }
        
        PrintWriter out = response.getWriter();

        /**  please dispatch web page here with the status codes **/
        if(queueStatus%10==Constant.SUCCESS){
            out.println("Success!");
        }else if(queueStatus%10==Constant.PARTIAL_SUCCESS){
            out.println("Partial success! Please check!");
        }else{
            out.println("Fail!!");
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

    private int setPermsConfirm(java.lang.String permsID, java.lang.String permsStatus, team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj permsInfo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        team.soa.cms.msgqueueservice.PermsConfmMsgService port = service.getPermsConfmMsgServicePort();
        return port.setPermsConfirm(permsID, permsStatus, permsInfo);
    }

    private java.util.List<team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj> consumeFalMsg(java.lang.String permsId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service_1.getPermsReqMsgServicePort();
        return port.consumeFalMsg(permsId);
    }

}
