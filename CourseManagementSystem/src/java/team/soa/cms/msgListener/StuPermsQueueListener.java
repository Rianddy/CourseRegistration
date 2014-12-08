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
import team.soa.cms.mail.MailService;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.PermissionresultSerialObj;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author birui
 *
 * This is for listening student queue
 */
@MessageDriven(mappedName = "jms/permsStu", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class StuPermsQueueListener implements MessageListener {

    private final String permsProp = "PermsId";
    private final String permsConnPath = "permsPool";
    private final String permsQueuePath = "permsStu";

    public StuPermsQueueListener() {
    }

    /**
     * When there is a message set into queue invoke this method to send email
     * to student remind their permission status and consume that message and
     * set the permission status from faculty into database
     *
     * @param message
     */
    @Override
    public void onMessage(Message message) {

        MailService mailService = new MailService();

        if (message instanceof ObjectMessage) {
            ObjectMessage msg = (ObjectMessage) message;
            PermissionresultSerialObj obj = null;
            try {
                obj = (PermissionresultSerialObj) msg.getObject();

                //database setter:
                DAOService daoService = new DAOService();
                int result = daoService.InsertPerms(obj);
                if (result == -1) {
                    System.err.println("Insert fail!");
                } else {
                    System.err.println("Insert success!");  //insert permission record successfully
                }

                String permissionPart = obj.getClassinfoserial().getRegresult().equals("reject") ? "" : "and Permission code is:" + result;

                //mail sender
                String mailContent = "Your permission request of class " + obj.getClassinfoserial().getCoursename() + " is " + obj.getClassinfoserial().getRegresult() + " " + permissionPart;
                mailService.PermsConfirm(obj.getStuinfoserial().getStuemail(), mailContent);

                //consume message:
                MsgQueueReceiver receiver = new MsgQueueReceiver(permsConnPath, permsQueuePath);
                List<Message> msgList = new ArrayList<Message>();
                String selector = permsProp + " = '" + msg.getStringProperty(permsProp) + "'";
                msgList = receiver.consumeMessage(selector);

            } catch (JMSException ex) {
                Logger.getLogger(StuPermsQueueListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
