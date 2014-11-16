/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.message;

import java.io.Serializable;
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
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;


/**
 *
 * @author YIYI
 */
@WebService(serviceName = "MessageStuClassInfo")
public class MessageStuClassInfo {

     /**
     * Web service operation
     */
    @WebMethod(operationName = "messageStuClassInfo")
    public String messageStuClassInfo(@WebParam(name = "stuclassInfo") Stuclassmessage stuclassInfo) {
        
        /*****************************************************************/
          String permissionID = "1000";
         /*****************************************************************/
        
        
        InitialContext ctx = null;        
        QueueConnectionFactory queueCF = null;
        Queue queue = null;
        Connection conn;
        Session ses;
        MessageProducer producer;
        Message m;
        String mq = new String("MQ Failure");
       // String type = input.getType();
         
        try {
            ctx = new InitialContext();
            queueCF = (QueueConnectionFactory) ctx.lookup("jms/stuclassqcf");
            conn = queueCF.createConnection();
            ses = conn.createSession(true,Session.SESSION_TRANSACTED);
            queue = (Queue) ctx.lookup("jms/stuclassqueue");
            producer = ses.createProducer((Destination)queue);
            
            StuClassInfoMQSerialObj sobj = new StuClassInfoMQSerialObj(stuclassInfo);
            m = ses.createObjectMessage(sobj);//ses.createTextMessage(stuclassInfo.getStudentinfo().getStuid());
            //ses.createObjectMessage(scserObj);
            m.setJMSDestination(producer.getDestination());
            m.setStringProperty("PermissionID",permissionID);
            
            producer.send(m);
            
            
            mq =  queue.getQueueName()+" MQ Success:  id "+stuclassInfo.getStudentinfo().getStuid();
            producer.close();
            ses.close();
            conn.close();
        } catch (NamingException e) {
            System.out.println("JNDI API lookup failed: "
                    + e.toString());
            System.exit(1);
        } catch (JMSException jmse) {
            System.out.println("JMS Connection failed: "
                    + jmse.toString());
            System.exit(1);            
        }        
        
        
        return mq;
    }
}
