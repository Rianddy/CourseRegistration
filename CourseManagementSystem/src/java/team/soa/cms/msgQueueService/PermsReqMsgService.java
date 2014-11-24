/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgQueueService;

import team.soa.cms.msgUtil.*;
import java.util.ArrayList;
import java.util.List;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.mail.PermsReqMailService;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PermsReqMsgService")
public class PermsReqMsgService {

    public String permsProp = "PermsId";
    public String permsConnPath = "permsPool";
    public String permsQueuePath = "permsFal";

    /**
     * Set permission request info to faculty queue
     * @param PermsID
     * @param falEmail
     * @param permsInfo
     * @return sending status
     */
    @WebMethod(operationName = "setPermsReq")
    public String setPermsReq(@WebParam(name = "PermsID") String PermsID, @WebParam(name = "falEmail") String falEmail, @WebParam(name = "permsInfo") StuClassInfoMQSerialObj sobj) {
        //TODO write your implementation code here:
        MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
        List<String> propList = new ArrayList<String>();
        propList.add(permsProp + ":" + PermsID);

        // set permsInfo into MQ
        String status = producer.setObjMsg(sobj, propList);

        // call mail service
        PermsReqMailService mail = new PermsReqMailService();
        status += " " + mail.PermsRequest(PermsID, falEmail);

        return status;
    }

    /**
     * Faculty get permission info from msg queue
     *
     * @param permsID Permission ID to get msg
     *
     * @return list of permission info
     */
    @WebMethod(operationName = "getPermsInfo")
    public List<StuClassInfoMQSerialObj> getPermsInfo(@WebParam(name = "PermsID") String PermsID) {
        //TODO write your implementation code here:
        List<StuClassInfoMQSerialObj> permsObj = new ArrayList<StuClassInfoMQSerialObj>();
        MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
        List<Message> msgList = new ArrayList<Message>();
        String selector = permsProp + " = '" + PermsID + "'";
        msgList = receiver.browserMessage(selector);
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

    /**
     * 
     * @param PermsId 
     * @return 
     */
    @WebMethod(operationName = "consumeFalMsg")
    public List<StuClassInfoMQSerialObj> consumeFalMsg(@WebParam(name = "PermsId") String PermsId) {
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
