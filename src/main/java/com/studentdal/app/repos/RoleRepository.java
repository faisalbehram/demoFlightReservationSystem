package com.studentdal.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentdal.app.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	 @Query("FROM Role WHERE name = ?1")
	Role findByName(String role);

}
