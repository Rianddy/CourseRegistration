/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.permission;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.permissionxmlschema.Permission;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PermissionRequestService")
public class PermissionRequestService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PrereqMsgQueue")
    public String PrereqMsgQueue(@WebParam(name = "parameter") Permission parameter) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * This is a sample web service operation
     */
    
}
