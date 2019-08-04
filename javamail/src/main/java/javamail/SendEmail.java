package javamail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
	public static void main(String[] args){
		//Receipient EMail ID
		String to = "adhithya.kum25@gmail.com";
	
		//Sender EMail ID
		String from = "adhithya.k25@gmail.com";
		
		//Assuming we are sending mail from localhost
		String host = "localhost";
		
		//Get system properties
		Properties properties = System.getProperties();
		
		//Setup mail server
		properties.setProperty("mail.smtp.host", host);
		
		//Get default session of the object
		Session session = Session.getDefaultInstance(properties);
		
		try{
			//Create default MimeMessage Object
			MimeMessage message = new MimeMessage(session);
			
			//Set from : header field of the header
			message.setFrom(new InternetAddress(from));
			
			//Set to: header field of the header
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Set Subject : header field
			message.setSubject("This is Subject line!!");
			
			//Set message 
			message.setText("This is the actual message!");
			
			//Send message
			Transport.send(message);
			
			System.out.println("Message sent successfully!!");
				
		}
		catch(MessagingException mex){
			mex.printStackTrace();
		}
	
	}

}
