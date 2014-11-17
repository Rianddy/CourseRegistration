/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.message;

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
@WebService(serviceName = "MessageStudent")
public class MessageStudent {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "messageStudent")
    public String messageStudent(@WebParam(name = "studentID") int studentID, @WebParam(name = "stuService") String stuService, @WebParam(name = "stuMessage") String stuMessage) {
        String stuid = studentID + "";
        MsgQueueProductor productor = new MsgQueueProductor("studentmqFactory", "studentmq");
        List<String> propList = new ArrayList<String>();
        propList.add("studentID:" + stuid);
        propList.add("service:" + stuService);
        String status = productor.setTextMsg(stuMessage, propList);

        return status;
    }
}
