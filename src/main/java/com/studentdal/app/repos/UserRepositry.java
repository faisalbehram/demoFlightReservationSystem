package com.studentdal.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdal.app.entites.User;

public interface UserRepositry extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByUsername(String username);

}
