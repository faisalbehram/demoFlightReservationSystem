package com.studentdal.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdal.app.entites.Verification;
import com.studentdal.app.repos.VerificationCodeRepository;


@Service
public class VerificationService {
	
		
	@Autowired
	private VerificationCodeRepository repository;
	
	// checking if user allready presend
	public String getVerifictionIdByUsername(String username) {
		Verification verification = repository.findByUsername(username);
		System.out.println("verfication is done find by " + verification.getUsername());
		
		if(verification != null) {
			System.out.println("verfication is not null " + verification.getUsername());
			return verification.getId();
		}
		return null;
	}
	
	
	public String createVerification(String username) 
	{
		// if user not found then create a token for activation
		if (!repository.existsByUsername(username)) {
			System.out.println("is not true");
			
			// count the all user and give next primary key with VERI starting name
			long countVerification = repository.count();
			System.out.println("All count is " + countVerification);
			
			 String newid  = "veri" + new Long(countVerification+10).toString();
			
			Verification verification = new Verification(newid,username);
			verification = repository.save(verification);
		
			return verification.getId();
		}
		
		System.out.println("is true");
		return getVerifictionIdByUsername(username);
	}
	
	public String getUsernameForId(String id) {
		Optional<Verification> verification = repository.findById(id);
		if(verification.isPresent()) {
			return verification.get().getUsername();
		}
		return null;
	}
	
}
