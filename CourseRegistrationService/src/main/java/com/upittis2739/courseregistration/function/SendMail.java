package com.upittis2739.courseregistration.function;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail 
{
    /**
     * Send email
     * 
     * @param title
     * @param content
     * @param toMail 
     */
    public static void Send(String title,String content,String toMail) 
    {
        // SMTP host, which depends on which email you use
        String smtphost = "smtp.163.com";
        // Server email address which can send the email
        String user = "rianddy@163.com";
        // Server email password
        String password = "cairuicairuiaaaa";
        String from = "rianddy@163.com";
        // Client email address which can accept the email
        String to = toMail; 
        // Email subject
        String subject = title;
        // Email content
        String body = content;
        try
        {
            // Set the properties and build a connection
            Properties props = new Properties();
            props.put("mail.smtp.host", smtphost);
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.connectiontimeout", "2000");
            Session ssn = Session.getInstance(props, null);

            // Create a message object which concludes the content of the email
            MimeMessage message = new MimeMessage(ssn);
            InternetAddress fromAddress = new InternetAddress(from);
            message.setFrom(fromAddress);
            InternetAddress toAddress = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setText(body);

            // Create transport object and send the message object created before
            Transport transport = ssn.getTransport("smtp");
            transport.connect(smtphost, user, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            
            //transport.send(message);
            transport.close();
        }
        catch(Exception m)
        {
            m.printStackTrace();
        }
    }
}
