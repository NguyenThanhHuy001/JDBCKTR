package vn.huy2k2.config;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendMail {
	  public static void sendEmail(String toEmail, String subject, String messageContent) throws MessagingException {
	        final String fromEmail = "Nth17042k2@gmail.com"; // Email gửi đi
	        final String password = "pdrb xhat uqdo nenw";   // App Password (16 ký tự)

	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");

	        // Xác thực
	        Authenticator auth = new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };

	        Session session = Session.getInstance(props, auth);

	        // Tạo mail
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(fromEmail));
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
	        msg.setSubject(subject);
	        msg.setContent(messageContent, "text/html; charset=UTF-8");

	        Transport.send(msg);
	    }

}
