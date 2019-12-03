package com.studentdal.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdal.app.entites.Documents;

public interface DocumentsRepo extends JpaRepository<Documents, Long> {

	
}
