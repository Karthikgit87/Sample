package org.vertex.web;

import java.net.PasswordAuthentication;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

public class SendEmail1 {

	public static void main(String[] args) {

		@AfterTest
		void emailSend(String error){
		   
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		              "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");

		    Session session = Session.getDefaultInstance(props,
		       new javax.mail.Authenticator() {
		       protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication("XXXXXX...@gmail.com", 
		       "XXXXXXXXX");
		             } });

		    try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new 
		        InternetAddress("XXXXXX...@gmail.com"));
		        message.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse("XXXXXX...@gmail.com"));
		        message.setSubject("Testing Subject");

		        BodyPart messageBodyPart1 = new MimeBodyPart();

		        messageBodyPart1.setText(error);

		        MimeBodyPart messageBodyPart2 = new MimeBodyPart();

		        String filename = System.getProperty("user.dir") +
		        "/screenshot.jpg";

		        DataSource source = new FileDataSource(filename);

		        messageBodyPart2.setDataHandler(new DataHandler(source));
		        messageBodyPart2.setFileName(filename);

		        Multipart multipart = new MimeMultipart();
		        multipart.addBodyPart(messageBodyPart2);
		        multipart.addBodyPart(messageBodyPart1);
		        message.setContent(multipart);
		        Transport.send(message);

		        System.out.println("=====Email Sent=====");

		    } catch (MessagingException e) {

		        throw new RuntimeException(e);

		    }
		}
	}

}
