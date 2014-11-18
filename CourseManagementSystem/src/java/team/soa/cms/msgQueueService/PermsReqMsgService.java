/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.msgQueueService;

import team.soa.cms.msgUtil.*;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
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
     * Web service operation
     */
    @WebMethod(operationName = "setPermsInfo")
    public String setPermsInfo(@WebParam(name = "stuclassInfo") Stuclassmessage stuclassInfo) {
        
        /*****************************************************************/
          String permissionID = "1000";
         /*****************************************************************/
         StuClassInfoMQSerialObj sobj = new StuClassInfoMQSerialObj(stuclassInfo);           
         MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
         List<String> propList = new ArrayList<String>();
         propList.add(permsProp+":"+permissionID);
         String status = producer.setObjMsg(sobj, propList);
      
        return status;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPermsInfo")
    public List<StuClassInfoMQSerialObj> getPermsInfo(@WebParam(name = "PermsID") String PermsID) {
        //TODO write your implementation code here:
        List<StuClassInfoMQSerialObj> permsObj = new VirtualFlow.ArrayLinkedList<>();
        MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
        List<Message> msgList = new ArrayList<Message>();
        String selector = permsProp+" = '"+PermsID+"'";
        msgList = receiver.browserMessage(selector);
        for(Message msg:msgList){
            ObjectMessage objMsg = (ObjectMessage)msg;
            try {
                permsObj.add((StuClassInfoMQSerialObj)objMsg.getObject());
            } catch (JMSException ex) {
                permsObj.add(null);
            }
        }    
        return permsObj;
    }   
    
}
