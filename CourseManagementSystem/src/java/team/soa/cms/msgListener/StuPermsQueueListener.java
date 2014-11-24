/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import team.soa.cms.mail.PermsReqMailService;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.PermissionresultSerialObj;

/**
 *
 * @author birui
 */
@MessageDriven(mappedName="jms/permsStu",activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class StuPermsQueueListener implements MessageListener {

    public StuPermsQueueListener() {
    }

    @Override
    public void onMessage(Message message) {
        String permsProp = "PermsId";
        String permsConnPath = "permsPool";
        String permsQueuePath = "permsStu";
        PermsReqMailService mailService = new PermsReqMailService();
        
        if (message instanceof ObjectMessage) {
            ObjectMessage msg = (ObjectMessage) message;
            PermissionresultSerialObj obj = null;
            try {
                obj = (PermissionresultSerialObj) msg.getObject();
                
                //mail sender
                String mailContent="Your permission request of class"+obj.getClassinfoserial().getCoursename()+" is " +obj.getClassinfoserial().getRegresult();
                mailService.PermsConfirm(obj.getStuinfoserial().getStuemail(), mailContent);
                
                //consume message:
                MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
                List<Message> msgList = new ArrayList<Message>();
                String selector = permsProp + " = '" + msg.getStringProperty(permsProp) + "'";
                msgList = receiver.consumeMessage(selector);
                
                //database setter
                
                System.out.println();

            } catch (JMSException ex) {
                Logger.getLogger(StuPermsQueueListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
