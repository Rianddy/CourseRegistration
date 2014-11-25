/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import team.soa.cms.constant.Constant;

/**
 *
 * @author birui
 */
public class MailUtil {

    public static int status;
    
    /**
     * 
     * @param mailAddress mail destination
     * @param Content mail Content
     * @return 
     */
    public static int Sender(String mailAddress,String Subject, String Content) {
        String smtphost = "smtp.163.com";
        String user = "perms_request@163.com";
        String password = "pitt_perms";
        String from = "perms_request@163.com";
        String to = mailAddress; 
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", smtphost);
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.connectiontimeout", "2000");
            Session ssn = Session.getInstance(props, null);

            MimeMessage message = new MimeMessage(ssn);

            InternetAddress fromAddress = new InternetAddress(from);
            message.setFrom(fromAddress);
            InternetAddress toAddress = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(Subject);
            message.setContent(Content,"text/html; charset=utf-8");

            Transport transport = ssn.getTransport("smtp");
            transport.connect(smtphost, user, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            //transport.send(message);
            transport.close();
            status = Constant.MAIL_SEND_SUCCESS;
        }
        catch(Exception m)
        {
            m.printStackTrace();
            status = Constant.MAIL_SEND_FAIL;
        }
        return status;
    }
}
