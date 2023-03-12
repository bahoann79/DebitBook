/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author bahoann79
 */
public class Email {

    private final String username = "bahoann79@gmail.com";
    // Note : sau  1 tgian ko su dung phai thay doi ma cua google
    private final String password = "royzhuwsdcubnkpp";

    public boolean sendMail(String mail, String title, String content) {
        boolean status = false;
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
//           
            MimeMessage message = new MimeMessage(session);

            // Set From: header field.
            message.setFrom(new InternetAddress("bahoann79@gmail.com"));

            // Set To: header field.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(mail));

            // Set Subject: header field
            message.setSubject(title);

            // Send the actual HTML message, as big as you like
            message.setContent(content,
                    "text/html;charset=UTF-8"); //  cho noi dung la 1 doan ma HTML 

            // Send message
            Transport.send(message);
            System.out.println("Gui message thanh cong....");
            status = true;
        } catch (MessagingException e) {
            status = false;
        }
        return status;
    }

}
