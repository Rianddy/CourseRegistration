/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgUtil;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author birui
 * 
 * this class is for getting message from queue 
 */
public class MsgQueueReceiver {

    InitialContext ctx = null;
    QueueConnectionFactory queueCF = null;
    Queue queue = null;
    Connection conn;
    Session ses;

    /**
     * initial connection and session and queue when create a new instance
     *
     * @param connSrc connection resource path
     * @param queueSrc queue resource path
     *
     */
    public MsgQueueReceiver(String connSrc, String queueSrc) {
        connSrc = "jms/" + connSrc;
        queueSrc = "jms/" + queueSrc;
        try {
            ctx = new InitialContext();
            queueCF = (QueueConnectionFactory) ctx.lookup(connSrc);
            conn = queueCF.createConnection();
            ses = conn.createSession(Session.SESSION_TRANSACTED);
            queue = (Queue) ctx.lookup(queueSrc);            
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
     * For browse message in queue
     *
     * @param
     * @return Message list
     */
    public List<Message> browserMessage(String selector) {
        
        List<Message> messageList = null;
        try {
            conn.start();
            QueueBrowser browser = ses.createBrowser(queue,selector);
            Message msg = null;
            Enumeration msgs = browser.getEnumeration();
            if (!msgs.hasMoreElements()) {
                out.println("<p>No messages in queue</p>");
            } else {
                messageList = new ArrayList();
                while (msgs.hasMoreElements()) {
                    msg = (Message) msgs.nextElement();
                    messageList.add(msg);
                }
            }
        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);   
        }
        return messageList;
    }

    /**
     * For consume message in queue
     *
     * @param IDProp ID property name
     * @param queueID ID value
     * @return Message list
     */
    public List<Message> consumeMessage(String selector) {
        List<Message> messageList = null;
        try {
            conn.start();
            MessageConsumer consumer = ses.createConsumer(queue, selector);
            Message msg = consumer.receive(10);
            if (msg != null) {
                messageList = new ArrayList();
                if (msg instanceof TextMessage) {
                    //only one message in the message queue
                    messageList.add((TextMessage) msg);
                }else if (msg instanceof ObjectMessage) {
                    messageList.add((ObjectMessage) msg);
                }
                while ((msg = consumer.receive(10)) != null) {
                    if (msg instanceof TextMessage) {
                        messageList.add((TextMessage) msg);
                    } else if (msg instanceof ObjectMessage) {
                        messageList.add((ObjectMessage) msg);
                    }
                }                ses.close();
                conn.close();
            }

        } catch (JMSException ex) {
            System.out.println("JMS Connection failed: "
                    + ex.toString());
            System.exit(1);   
        }
        return messageList;
    }


}
