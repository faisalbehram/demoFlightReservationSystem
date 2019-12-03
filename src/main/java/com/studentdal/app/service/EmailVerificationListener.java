package com.studentdal.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.studentdal.app.util.UserRegistrationEvent;

@Service
public class EmailVerificationListener  implements ApplicationListener<UserRegistrationEvent>{
	
	
	// this service is used to send mail also to provide the link of the activation and verification
	// it will listen the UserRegistrationEvent and when ever it publish A event it will listen and send the mail
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	@Autowired
	private  VerificationService verificationService;
	
	@Value(value = "${disableEmailVerification}")
	private boolean disableEmailVerification = false;
	
	

	@Override
	public void onApplicationEvent(UserRegistrationEvent event) {
		
//		if(veriRepo.findByUsername(event.getUser().getUsername()) != null) {
//			System.out.println("username found " + event.getUser().getUsername() );
//			return;
//		}
//		
		
		if(disableEmailVerification) {
			System.out.println("disappple email verfication " + disableEmailVerification);
			return;
		}
		// sending verification mail
		String username = event.getUser().getUsername();
		String verificationId = verificationService.createVerification(username);		
		String email = event.getUser().getEmail();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Flight Reservation System Account Verification");
		message.setText("Account activation link: https://localhost:8443/verify/email?id="+verificationId);
		message.setTo(email);
		mailSender.send(message);
	}
		
	}




