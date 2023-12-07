package org.vertex.web;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;

public class SendEmail {

public void sendEmail1() {
	
    final String username = "User name";  // like yourname@outlook.com
    final String password = "Password";   // password here
	     
    String to = "email to address ";
    String from = username;
   
    Properties properties = new Properties (); 
    properties.put("mail.smtp.auth", "true");  
    properties.put("mail.smtp.starttls.enable", "true");  
    
    // Setup mail server 
    properties.put("mail.smtp.host", "smtp-mail.outlook.com");
     
    // TLS Port 
    properties.put("mail.smtp.port", "587");   
    Session session = Session.getDefaultInstance(properties, 
            new javax.mail.Authenticator() {           
    	 protected PasswordAuthentication getPasswordAuthentication() { 
     return new PasswordAuthentication(username, 
                                     password); 
 } 
}); 
            
   try { 
 
        Message message = new MimeMessage(session);    
        message.setFrom(new InternetAddress(from)); 		
        message.setRecipients(Message.RecipientType.TO, 
                 InternetAddress.parse(to));
        message.setSubject("Test Mail"); 
        message.setText("Hi, This is test mail sending through Automation ");         
        Transport.send(message); 
        System.out.println("Message successfully sent..");
    } 
    catch (MessagingException mex) { 
        mex.printStackTrace(); 
    } 
  }
}