/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgUtil;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author birui
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/permsStu"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MsgQueueListenerBean implements MessageListener {
    
    public MsgQueueListenerBean() {
    }
    
    @Override
    public void onMessage(Message message) {
         if (message instanceof ObjectMessage) {
            ObjectMessage msg = (ObjectMessage) message;
            try {
                System.out.println("received object:"+msg.getObject().getClass().getName());
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        } else if (message instanceof TextMessage) {
            TextMessage msg = (TextMessage) message;
            try {
                System.out.println("received: " + msg.getText());
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
