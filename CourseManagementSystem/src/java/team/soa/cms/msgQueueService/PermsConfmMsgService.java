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
import team.soa.cms.msgUtil.MsgQueueProducer;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;
import team.soa.cms.serializableObj.PermissionresultSerialObj;
import team.soa.cms.serializableObj.permissionresultSerializableObj.ClassinfoSerialObj;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PermsConfmMsgService")
public class PermsConfmMsgService {

    private final String permsProp = "PermsId";
    private final String permsConnPath = "permsPool";
    private final String permsQueuePath = "permsStu";
    private DAOService DAOService = new DAOService();

    /**
     * Set permission information with faculty confirm status(accept or reject)
     *
     * @param PermsID permission id
     * @param status 
     * @param PermsInfo
     * @return message queue set succeed
     */
    @WebMethod(operationName = "setPermsConfirm")
    public int setPermsConfirm(@WebParam(name = "PermsID") String PermsID, @WebParam(name = "PermsStatus") String status, @WebParam(name = "PermsInfo") StuClassInfoMQSerialObj PermsInfo) {

        PermissionresultSerialObj sobj = null;
        sobj = DAOService.transferFromStuClassInfoToPermissionResult(PermsInfo);

        ClassinfoSerialObj classInfo = sobj.getClassinfoserial();
        classInfo.setRegresult(status);
        sobj.setClassinfoserial(classInfo);
        
        List<String> propList = new ArrayList<String>();
        propList.add(permsProp + ":" + PermsID);

        // set permsInfo into MQ
        MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
        return producer.setObjMsg(sobj, propList);
    }

    /**
     * Consume message from student queue
     * @param PermsId permission id
     * @return
     */
    @WebMethod(operationName = "consumeStuMsg")
    public List<PermissionresultSerialObj> consumeStuMsg(@WebParam(name = "PermsId") String PermsId) {
        //TODO write your implementation code here:
        List<PermissionresultSerialObj> permsObj = new ArrayList<PermissionresultSerialObj>();

        MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
        List<Message> msgList = new ArrayList<Message>();
        String selector = permsProp + " = '" + PermsId + "'";
        msgList = receiver.consumeMessage(selector);
        for (Message msg : msgList) {
            ObjectMessage objMsg = (ObjectMessage) msg;
            try {
                permsObj.add((PermissionresultSerialObj) objMsg.getObject());
            } catch (JMSException ex) {
                permsObj.add(null);
            }
        }
        return permsObj;
    }
}
