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

/**
 *
 * @author birui
 */
public class MailUtil {

    public static String status;
    
    /**
     * 
     * @param mailto mail destination
     * @param content mail content
     * @return 
     */
    public static String Sender(String mailto, String content) {
        String smtphost = "smtp.163.com";
        String user = "perms_request@163.com";
        String password = "pitt_perms";
        String from = "perms_request@163.com";
        String to = mailto; 
        String subject = "Permission request reminder";
        String body = content;
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
            message.setSubject(subject);
            message.setContent(body,"text/html; charset=utf-8");

            Transport transport = ssn.getTransport("smtp");
            transport.connect(smtphost, user, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            //transport.send(message);
            transport.close();
            status = "Send success!";
        }
        catch(Exception m)
        {
            m.printStackTrace();
            status = "Send failed!";
        }
        return status;
    }
}
