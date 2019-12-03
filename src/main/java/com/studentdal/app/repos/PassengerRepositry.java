package com.studentdal.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdal.app.entites.Passenger;

public interface PassengerRepositry extends JpaRepository<Passenger, Long>{
	

}
