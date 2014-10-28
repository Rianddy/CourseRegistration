/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.service;

import com.upittis2739.courseregistration.message.MailMessage;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author riand_000
 */
@WebService(serviceName = "RegistrationService")
public class RegistrationService {

    @Resource(mappedName = "jms/maildest")
    private Queue maildest;
    @Inject
    @JMSConnectionFactory("jms/mailqueue")
    private JMSContext context;

    @WebMethod(operationName = "hello")
    public boolean hello(@WebParam(name = "toAddress") String toAddress) {
        return sendJMSMessageToMaildest("Test", "rianddy@163.com", "TestMessageQueue");
    }

    private boolean sendJMSMessageToMaildest(String mailContent, String toAddress, String title) {
        try {
            MailMessage student = new MailMessage(mailContent, toAddress, title);
            ObjectMessage msg = context.createObjectMessage(student);
            context.createProducer().send(maildest, msg);
            return true;
        } catch (Exception e) {
            System.out.println("Exception raised: " + e.toString());
            return false;
        }
    }

}
