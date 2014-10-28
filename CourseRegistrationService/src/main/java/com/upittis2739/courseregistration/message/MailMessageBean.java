/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import com.upittis2739.courseregistration.function.SendMail;
/**
 *
 * @author riand_000
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/maildest"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MailMessageBean implements MessageListener {

    public MailMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage msg = (ObjectMessage) message;
                MailMessage received = (MailMessage) msg.getObject();
                SendMail.Send(received.getTitle(), received.getMailContent(), received.getToAddress());
            }
        } catch (Exception e) {
            System.out.println("Exception raised: " + e.toString());
        }
    }

}
