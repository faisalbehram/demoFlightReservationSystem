package com.studentdal.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentdal.app.entites.User;
import com.studentdal.app.repos.UserRepositry;
import com.studentdal.app.service.VerificationService;



@Controller
public class VerificationController {
	
	// this controller is used for verification the email

	@Autowired
	private  VerificationService verificationService;
	@Autowired
	private UserRepositry userRepository;
	
	
	// call when click of email address
	
	@GetMapping("/verify/email")
	public String verifyEmail(@RequestParam String id) {
		String username = verificationService.getUsernameForId(id);
		if(username != null) {
			User user = userRepository.findByUsername(username);
			user.setVerified(true);
			userRepository.save(user);
			
		}
		
		return "redirect:/login";
	}
	
}
