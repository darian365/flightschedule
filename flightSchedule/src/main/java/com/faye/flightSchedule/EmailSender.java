package com.faye.flightSchedule;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	
	public static void send(String content) {
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
				InternetAddress.parse("darian.lee16@gmail.com"));
			message.setSubject("My Schedule");
//			message.setText(content);
			message.setContent(content, "text/html");
			

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}	
	}
}
