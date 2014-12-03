/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.mail;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author birui
 * This is for all mail service collection
 */
@WebService(serviceName = "PermsReqMailService")
public class MailService {

    private String mailAddress;
    private String Subject;
    private String Content;

    /**
     * Sending email to faculty for asking permission 
     */
    @WebMethod(operationName = "PermsRequest")
    public int PermsRequest(@WebParam(name = "PermsId") String PermsId, @WebParam(name = "FacultyEmail") String FacultyEmail) {
        //TODO write your implementation code here:
        String ServletURL ="CheckPermsReqServlet?permsId="+PermsId;
        mailAddress = FacultyEmail;
        Subject = "Permission Request Reminder";
        Content="<p>You have a permission request! Please click this URL: "+ServletURL+"</p>";     
        return send();
    }
    
    /**
     * Sending email to student for informing their request status
     */
    @WebMethod(operationName = "PermsConfirm")
    public int PermsConfirm( @WebParam(name = "StudentEmail") String StudentEmail, @WebParam(name = "PermsContent") String PermsContent) {
        //TODO write your implementation code here:
        mailAddress=StudentEmail;
        Subject="Permission Request Status";
        Content = PermsContent;       
        return send();
    }
    
   /**
     * Web service operation
     */
    @WebMethod(operationName = "dropConfirm")
    public Integer dropConfirm(@WebParam(name = "StudentEmail") String StudentEmail, @WebParam(name = "DropContent") String DropContent) {
        //TODO write your implementation code here:
         mailAddress=StudentEmail;
        Subject="Class has been dropped";
        Content = DropContent;       
        return send();
    }
    
    
    
    /**
     * @see MailUtil.sender
     * @return 
     */
    private int send(){
    return MailUtil.Sender(mailAddress, Subject, Content);
    }

   
}
