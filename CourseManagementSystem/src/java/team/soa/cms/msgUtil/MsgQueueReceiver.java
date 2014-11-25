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
import javax.jms.ObjectMessage;
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
 * This class is for getting message from queue
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
     * @param connSrc connection pool resource path
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
     * For browsing message in queue
     *
     * @param selector e.g. your property name + " = '" + your property value + "'"
     * @return Message list
     */
    public List<Message> browserMessage(String selector) {

        List<Message> messageList = null;
        try {
            conn.start();
            QueueBrowser browser = ses.createBrowser(queue, selector);
            Message msg = null;
            Enumeration msgs = browser.getEnumeration();
            if (!msgs.hasMoreElements()) {
                System.err.println("<p>No messages in queue</p>");
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
     * For consuming message in queue
     *
     * @param selector e.g. your property name + " = '" + your property value + "'"
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
                } else if (msg instanceof ObjectMessage) {
                    messageList.add((ObjectMessage) msg);
                }
                while ((msg = consumer.receive(10)) != null) {
                    // this is for timeout 
                    if (msg instanceof TextMessage) {
                        messageList.add((TextMessage) msg);
                    } else if (msg instanceof ObjectMessage) {
                        messageList.add((ObjectMessage) msg);
                    }
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
     * Please close session and connection where setting message is done!
     * @throws JMSException 
     */
    public void close() throws JMSException {
        ses.close();
        conn.close();
    }

}
