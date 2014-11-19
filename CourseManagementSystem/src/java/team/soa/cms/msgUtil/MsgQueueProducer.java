/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgUtil;

import java.io.Serializable;
import java.util.List;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author birui
 */
public class MsgQueueProducer {

    InitialContext ctx = null;
    QueueConnectionFactory queueCF = null;
    Queue queue = null;
    Connection conn;
    Session ses;
    MessageProducer producer;
    String status = new String("MQ Failure");

    /**
     * initial connection and session and queue when create a new instance
     *
     * @param connSrc connection resource path
     * @param queueSrc queue resource path
     *
     */
    public MsgQueueProducer(String connSrc, String queueSrc) {
        connSrc = "jms/" + connSrc;
        queueSrc = "jms/" + queueSrc;
        try {
            ctx = new InitialContext();
            queueCF = (QueueConnectionFactory) ctx.lookup(connSrc);
            conn = queueCF.createConnection();
            ses = conn.createSession(true, Session.SESSION_TRANSACTED);
            queue = (Queue) ctx.lookup(queueSrc);
            producer = ses.createProducer((Destination) queue);
            conn.start();
        } catch (NamingException ex) {
            System.out.println("JNDI API lookup failed: "
                    + ex.toString());
            System.exit(1);
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);
        }
    }

    /**
     * For set text message in queue
     *
     * @param text message text content
     * @param propList a list of properties(name:value) of queue
     * @return Message list
     */
    public String setTextMsg(String text, List<String> propList) {
        try {
            Message m = ses.createTextMessage(text);
            m.setJMSDestination(producer.getDestination());
            for (String prop : propList) {
                m.setStringProperty(prop.split(":")[0], prop.split(":")[1]);
            }
            producer.send(m);
            producer.close();
            ses.close();
            conn.close();
            status = " MQ Success!";
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);
        }
        return status;
    }

    public String setObjMsg(Object object, List<String> propList) {
        try {
            Message m = ses.createObjectMessage((Serializable) object);
            m.setJMSDestination(producer.getDestination());
            for (String prop : propList) {
                m.setStringProperty(prop.split(":")[0], prop.split(":")[1]);
            }
            producer.send(m);
            producer.close();
            ses.close();
            conn.close();
            status = " MQ Success!";
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);
        }
        return status;
    }

}
