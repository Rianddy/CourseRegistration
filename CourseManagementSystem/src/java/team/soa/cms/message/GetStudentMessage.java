/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.message;

import java.util.ArrayList;
import java.util.List;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author YIYI
 */
@WebService(serviceName = "GetStudentMessage")
public class GetStudentMessage {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStudentMessage")
    public List getStudentMessage(@WebParam(name = "studentID") int studentID, @WebParam(name = "stuService") String stuService) {
        List messageList = null;
        
        InitialContext ctx = null;
        QueueConnectionFactory queueCF = null;
        Queue queue = null;
        Connection conn;
        Session ses;
        MessageConsumer consumer;
        Message m;
        
        
          try {
                ctx = new InitialContext();
                queueCF = (QueueConnectionFactory) ctx.lookup("jms/studentmqFactory");
                conn = queueCF.createConnection();
                ses = conn.createSession(true,Session.SESSION_TRANSACTED);
                queue = (Queue) ctx.lookup("jms/studentmq");
                
                consumer = ses.createConsumer(queue, "studentID = '"+studentID+"' AND service='"+stuService+"'");
                conn.start();
                m = consumer.receive(10);
              
                if (m != null){
                    messageList = new ArrayList();
                    if (m instanceof TextMessage) {
                        //only one message in the message queue
                        messageList.add( ((TextMessage) m).getText());
                       
                    }
                    
                    while ((m = consumer.receive(10)) != null) {
                        if (m instanceof TextMessage) {
                          messageList.add( ((TextMessage) m).getText());
                       
                        }
                    }
                    conn.close();
                }
            } catch (NamingException e) {
                System.out.println("JNDI API lookup failed: "
                        + e.toString());
                System.exit(1);
            } catch (JMSException jmse) {
                System.out.println("JMS Connection failed: "
                        + jmse.toString());
                System.exit(1);
            }
        
        
        
        
        return messageList;
    }
}
