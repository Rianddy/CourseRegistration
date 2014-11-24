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
 */
@WebService(serviceName = "PermsReqMailService")
public class PermsReqMailService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "PermsRequest")
    public String PermsRequest(@WebParam(name = "PermsId") String PermsId, @WebParam(name = "FacultyEmail") String FacultyEmail) {
        //TODO write your implementation code here:
        String ServletURL ="CheckPermsReqServlet?permsId="+PermsId;
        String Content="You have a permission request! Please click this URL: "+ServletURL;
        String status = MailUtil.Sender(FacultyEmail,Content);      
        return status;
    }
    
       /**
     * Web service operation
     */
    @WebMethod(operationName = "PermsConfirm")
    public String PermsConfirm( @WebParam(name = "StudentEmail") String StudentEmail, @WebParam(name = "PermsContent") String PermsContent) {
        //TODO write your implementation code here:
        String status = MailUtil.Sender(StudentEmail,PermsContent);      
        return status;
    }
}
