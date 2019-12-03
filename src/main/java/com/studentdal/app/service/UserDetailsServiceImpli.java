package com.studentdal.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.studentdal.app.entites.User;
import com.studentdal.app.repos.UserRepositry;




@Service
public class UserDetailsServiceImpli implements UserDetailsService{
	
	@Autowired
	
	private UserRepositry userRepositry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepositry.findByEmail(username);
		
		
		if(user==null) {
			throw new UsernameNotFoundException("No user present with username: "+username);
		}
		else
			return new CustomUserDetails(user);
	}
	 



	}
	
		
//		System.out.println("email address out of if foound " + user.getEmail());
//		
//		if(user == null) {
//			 System.out.println("email address inside  if not foound" + user.getEmail());
//			 throw new UsernameNotFoundException("email not found");
//		 }
//		System.out.println("beyound  of if foound " + user.getEmail() + " " +  user.getPassword() + "  " +  user.getRoles());
//		
//		
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	