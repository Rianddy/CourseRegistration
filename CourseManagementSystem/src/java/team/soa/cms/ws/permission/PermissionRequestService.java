/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.permission;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import team.soa.cms.constant.Constant;
import team.soa.cms.msgQueueService.PermsReqMsgService;
import team.soa.cms.msgQueueService.ServicesQueueService;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;
import team.soa.cms.ws.RegCheckService;

/**
 *
 * @author birui
 * 
 * 
 */
@WebService(serviceName = "PermissionRequestService")
public class PermissionRequestService {

    /**
     * Web service operation
     * This operation is for set permission info into Faculty queue
     */
    @WebMethod(operationName = "PrereqMsgQueue")
    public int PrereqMsgQueue(@WebParam(name = "stu_ID") String stu_ID, @WebParam(name = "class_ID") String class_ID, @WebParam(name = "faculty_email") String faculty_email) {
        ServicesQueueService servicesQueueService = new ServicesQueueService();
        StuClassInfoMQSerialObj object = null;
        String perm_id = String.valueOf(stu_ID.hashCode() * class_ID.hashCode());
        try {
            object = (StuClassInfoMQSerialObj) (servicesQueueService.getObjectBetweenService(RegCheckService.class.getName(), PermissionRequestService.class.getName(), perm_id).getObject());
        } catch (JMSException ex) {
            Logger.getLogger(PermissionRequestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (object == null) {
            return Constant.FAIL;
        } else {
            PermsReqMsgService permsReqMsgService = new PermsReqMsgService();          
            return permsReqMsgService.setPermsReq(perm_id, faculty_email, object);
        }

    }

}
