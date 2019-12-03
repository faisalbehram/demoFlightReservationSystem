package com.studentdal.app.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.studentdal.app.entites.User;

@Component
public class EmailUtilImpli implements EmailUtil  {
	@Autowired
	private JavaMailSender sender;
//	
	// this is used for iternearyyy to send the pdf
	
//	@Override
//	public void sendEmail(String toAddress, String subject, String body) {
//	MimeMessage message =	sender.createMimeMessage();
//	MimeMessageHelper helper = new MimeMessageHelper(message);
//	try {
//		helper.setTo(toAddress);
//		helper.setSubject(subject);
//		helper.setText(body);
//		
//	} catch (MessagingException e) {
//		e.printStackTrace();
//	}
//	
//	sender.send(message);
//	}

	@Override
	public void sendIternary(String toAddress, String filePath) {
		MimeMessage message =	sender.createMimeMessage();
		try {
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
			helper.setTo(toAddress);
			helper.setSubject("iternaterny  for your flight");
			helper.setText("this is your flight detail. please flight your iternatry detail");
			helper.addAttachment("itinearary", new File(filePath));

			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}


	

}
