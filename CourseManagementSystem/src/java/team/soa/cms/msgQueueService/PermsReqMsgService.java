/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.msgQueueService;

import team.soa.cms.msgUtil.*;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
    public String permsConnPath = "stuclassqcf";
    public String permsQueuePath = "stuclassqueue";

    /**
     * @param PermsID permission id
     * @param facultyMail send email to faculty
     * @param stuclassInfo permsInfo
     * 
     * @return sending status
     */
    @WebMethod(operationName = "setPermsInfo")
    public String setPermsInfo(@WebParam(name = "PermsID") String PermsID, @WebParam(name = "facultyMail") String facultyMail, @WebParam(name = "stuclassInfo") Stuclassmessage stuclassInfo) {
       
        StuClassInfoMQSerialObj sobj = new StuClassInfoMQSerialObj(stuclassInfo);
        MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
        List<String> propList = new ArrayList<String>();
        propList.add(permsProp + ":" + PermsID);
        
        // set permsInfo into MQ
        String status = producer.setObjMsg(sobj, propList);
        
        // call mail service
        PermsReqMailService mail = new PermsReqMailService();
        status+=" "+mail.PermsRequest(PermsID, facultyMail);

        return status;

    }

    /**
     * Faculty get permission info from msg queue
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
    
}
