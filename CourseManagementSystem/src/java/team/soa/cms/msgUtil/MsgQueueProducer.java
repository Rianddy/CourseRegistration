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
import team.soa.cms.constant.Constant;

/**
 *
 * @author birui
 * 
 * This class is for setting message into queue
 * 
 */
public class MsgQueueProducer {

    InitialContext ctx = null;
    QueueConnectionFactory queueCF = null;
    Queue queue = null;
    Connection conn;
    Session ses;
    MessageProducer producer;
    int status = Constant.MSG_SET_FAIL;

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
     * @return queue setting status
     */
    public int setTextMsg(String text, List<String> propList) {
        try {
            conn.start();
            Message m = ses.createTextMessage(text);
            m.setJMSDestination(producer.getDestination());
            for (String prop : propList) {
                m.setStringProperty(prop.split(":")[0], prop.split(":")[1]);
            }
            producer.send(m);
            producer.close();
            status = Constant.MSG_SET_SUCCESS;
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);
        }
        return status;
    }

    /**
     * Set obbject message into queue
     * @param object object content
     * @param propList a list of properties(name:value) of queue
     * @return queue setting status
     */
    public int setObjMsg(Object object, List<String> propList) {
        try {
            conn.start();
            Message m = ses.createObjectMessage((Serializable) object);
            m.setJMSDestination(producer.getDestination());
            for (String prop : propList) {
                m.setStringProperty(prop.split(":")[0], prop.split(":")[1]);
            }
            producer.send(m);
            producer.close();
            status = Constant.MSG_SET_SUCCESS;
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);
        }
        return status;
    }

    /**
     * Please close session and connection where setting message is done!
     * @throws JMSException 
     */
    public void close() throws JMSException {
        ses.close();
        conn.close();
    }

}
