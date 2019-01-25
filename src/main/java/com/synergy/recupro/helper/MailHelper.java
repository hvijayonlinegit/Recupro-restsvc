package com.synergy.recupro.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.synergy.recupro.model.User;

@Service
public class MailHelper {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private EnvironmentHelper environmentHelper;
	    
	/** 
	 * Method to send the Sing up info to the admin for tracking app usage.
	 * @param user
	 * @param location
	 * @throws Exception
	 */
	public void sendEmail(User user, String location) throws Exception{

		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        final String  SUBJECT = "new user to recupro";
        
        StringBuilder mailBody = new StringBuilder(1000);
        
         mailBody.append("hello team").append("\n").append("A new user has been registered to recupro.").append("\n").append("Please find details below:").append("\n")
        .append("Name					:"+user.getName()).append("\n")
        .append("Email					:"+user.getEmail()).append("\n")
        .append("User Name				:"+user.getUsername()).append("\n")
        .append("Created At				:"+user.getCreatedAt()).append("\n")
        .append("record Created in 		:"+environmentHelper.getEnvironmentForLocation(location));

        helper.setTo(environmentHelper.getPropertyFromPropertiesFile("custom.mail.to-address"));
        helper.setText(mailBody.toString());
        helper.setSubject(SUBJECT);
        
        sender.send(message);
	    }
	/** 
	 * Method to send the Login info to the admin for tracking app usage.
	 * @param username
	 * @throws Exception
	 */
	public void sendLoggedInEmailInfo(String username) throws Exception{
		
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        final String  SUBJECT = "new user to recupro";
        
        StringBuilder mailBody = new StringBuilder(1000);
        Date date = new Date(System.currentTimeMillis());  
        mailBody.append("hello team").append("\n").append("below user has been logged in to recupro.").append("\n").append("Please find details below:").append("\n")
        .append("Name			:"+username).append("\n")
        .append("Logged in  At		:"+convertToEST(date)).append("\n");
        
        helper.setTo(environmentHelper.getPropertyFromPropertiesFile("custom.mail.to-address"));
        helper.setText(mailBody.toString());
        helper.setSubject(SUBJECT);
        
        sender.send(message);
    }
	/**
	 * Method to convert given date to EST .
	 * @param date
	 * @return Date
	 * @throws ParseException
	 */
	public Date convertToEST(Date date) throws ParseException {
	    DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
	    formatter.setTimeZone(TimeZone.getTimeZone("EST"));
	    return formatter.parse((formatter.format(date)));
	}

}
