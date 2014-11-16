/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.message;

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
     * @param studentID
     * @param facultyService
     * @param facultyMessage
     * @return 
     */
    @WebMethod(operationName = "messageFaculty")
    public Boolean messageFaculty(@WebParam(name = "studentID") int studentID, @WebParam(name = "facultyService") String facultyService, @WebParam(name = "facultyMessage") String facultyMessage) {
        boolean result = false;
       
          
        InitialContext ctx = null;        
        QueueConnectionFactory queueCF = null;
        Queue queue = null;
        Connection conn;
        Session ses;
        MessageProducer producer;
        Message m;
         
        try {
            ctx = new InitialContext();
            queueCF = (QueueConnectionFactory) ctx.lookup("jms/facultymqFactory");
            conn = queueCF.createConnection();
            ses = conn.createSession(true,Session.SESSION_TRANSACTED);
            queue = (Queue) ctx.lookup("jms/facultymq");
            producer = ses.createProducer((Destination)queue);
            
            m = ses.createTextMessage(facultyMessage);
            
            m.setJMSDestination(producer.getDestination());
            String stuid = studentID+"";
            m.setStringProperty("studentID",stuid);
            m.setStringProperty("service", facultyService);
            producer.send(m);
          
            producer.close();
            ses.close();
            conn.close();
            result = true;
            
        } catch (NamingException e) {
            System.out.println("JNDI API lookup failed: "
                    + e.toString());
            System.exit(1);
        } catch (JMSException jmse) {
            System.out.println("JMS Connection failed: "
                    + jmse.toString());
            System.exit(1);            
        }        
       
        return result;
    }
}
