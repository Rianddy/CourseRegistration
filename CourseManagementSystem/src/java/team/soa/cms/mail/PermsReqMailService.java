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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PermsRequest")
    public String PermsRequest(@WebParam(name = "PermsId") String PermsId, @WebParam(name = "FacultyEmail") String FacultyEmail) {
        //TODO write your implementation code here:
        String ServletURL ="";
        String Content="You have a permission request! Please click this ";
        String status = MailUtil.Sender(FacultyEmail,Content);      
        return status;
    }
    
    
}