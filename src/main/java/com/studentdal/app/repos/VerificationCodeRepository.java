package com.studentdal.app.repos;

import org.springframework.data.repository.CrudRepository;

import com.studentdal.app.entites.Verification;

public interface VerificationCodeRepository extends CrudRepository<Verification, String>{
	
	Verification findByUsername(String username);
	boolean existsByUsername(String username);
	
	
//	@Query("SELECT count(id) as Id FROM reservation.verification")
//	int allVerification();
}
