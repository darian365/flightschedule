package com.faye.flightSchedule;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	
	public void send(String content) {
		final String username = "fei.darian.li@gmail.com";
		final String password = "haohaoxuexi180411!";
		//fexudqunzeeznnxe
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, "fexudqunzeeznnxe");
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("fei.darian.li@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("86235336@qq.com"));
			//294171739@qq.com,
			message.setSubject("My Schedule");
			message.setContent(content, "text/html");

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}	
	}
}
