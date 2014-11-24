/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgQueueService;

import java.util.ArrayList;
import java.util.List;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuclassppermresultxmlschema.Permissionresult;
import team.soa.cms.msgUtil.MsgQueueProducer;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;
import team.soa.cms.serializableObj.PermissionresultSerialObj;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PermsConfmMsgService")
public class PermsConfmMsgService {

  public String permsProp = "PermsId";
    public String permsConnPath = "permsPool";
    public String permsQueuePath = "permsStu";

    /**
     * @param PermsID permission id
     * @param studentMail send confirm email to student to show status change
     * @param Permissionresult permsInfo
     *
     * @return sending status
     */
    @WebMethod(operationName = "setPermsConfirm")
    public String setPermsConfirm(@WebParam(name = "PermsID") String PermsID, @WebParam(name = "stuclassInfo") Permissionresult permsinfo) {

        PermissionresultSerialObj sobj = new PermissionresultSerialObj(permsinfo);
        MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
        List<String> propList = new ArrayList<String>();
        propList.add(permsProp + ":" + PermsID);

        // set permsInfo into MQ
        String status = producer.setObjMsg(sobj, propList);

        return status;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consumeMsg")
    public List<StuClassInfoMQSerialObj> consumeMsg(@WebParam(name = "PermsId") String PermsId) {
        //TODO write your implementation code here:
         List<StuClassInfoMQSerialObj> permsObj = new ArrayList<StuClassInfoMQSerialObj>();
         
        MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
        List<Message> msgList = new ArrayList<Message>();
        String selector = permsProp + " = '" + PermsId + "'";
        msgList = receiver.consumeMessage(selector);
        for (Message msg : msgList) {
            ObjectMessage objMsg = (ObjectMessage) msg;
            try {
                permsObj.add((StuClassInfoMQSerialObj) objMsg.getObject());
            } catch (JMSException ex) {
                permsObj.add(null);
            }
        }
        return permsObj;
    }

    
    
    
}
