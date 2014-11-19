/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgQueueService;

import team.soa.cms.msgUtil.MsgQueueProducer;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author YIYI
 */
@WebService(serviceName = "MessageFaculty")
public class MessageFaculty {

    /**
     * Web service operation
     *
     * @param studentID
     * @param facultyService
     * @param facultyMessage
     * @return
     */
    @WebMethod(operationName = "messageFaculty")
    public String messageFaculty(@WebParam(name = "studentID") int studentID, @WebParam(name = "facultyService") String facultyService, @WebParam(name = "facultyMessage") String facultyMessage) {
        String stuid = studentID + "";
        MsgQueueProducer productor = new MsgQueueProducer("facultymqFactory", "facultymq");
        List<String> propList = new ArrayList<String>();
        propList.add("studentID:" + stuid);
        propList.add("service:" + facultyService);
        String status = productor.setTextMsg(facultyMessage, propList);

        return status;
    }
}
