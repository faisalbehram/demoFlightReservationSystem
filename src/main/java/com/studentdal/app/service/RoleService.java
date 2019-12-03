package com.studentdal.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentdal.app.entites.Role;
import com.studentdal.app.entites.User;
import com.studentdal.app.repos.RoleRepository;
import com.studentdal.app.repos.UserRepositry;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRepositry userRepo;
	

	
	public void AddRole(User user,String role) {
		
		
	Role role1 = roleRepo.findByName(role);	
		Set<Role> getrole = new HashSet<>();
		getrole.add(role1);
		
		user.setRoles(getrole);
		
		roleRepo.save(role1);
		userRepo.save(user);
		
	
	
	}
}
