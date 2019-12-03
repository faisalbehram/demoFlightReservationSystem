package com.studentdal.app.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studentdal.app.dto.ReservationUpdateRequest;
import com.studentdal.app.entites.Reservation;
import com.studentdal.app.entites.User;
import com.studentdal.app.repos.ReservationRepositry;
import com.studentdal.app.repos.UserRepositry;

@RestController
public class ReservationRestController {
	
	// controller is used for checkIn app/.. which letter used this data to complete the check in
	@Autowired
	private ReservationRepositry reservationRepo;
	
	@Autowired
	private UserRepositry userRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long reservationId) {
		return  reservationRepo.findById(reservationId).orElseThrow(()-> new EntityNotFoundException());
		
	}
	
	
  	@RequestMapping("/reservationall")
	public List<Reservation> getAll() {
		return  reservationRepo.findAll();
		
	}
	
	@RequestMapping(value = "/reservation" ,method = RequestMethod.POST )
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).orElseThrow(()-> new EntityNotFoundException());
		reservation.setCheckedIn(false);
		//reservation.setNumberOfBags(5);
	reservation.setNumberOfBags(request.getNumberOfBags());
	reservation.setCheckedIn(request.getCheckedIn());
		
		Reservation updatedReservation = reservationRepo.save(reservation);
		return updatedReservation;
		
		 
	}
	
	@GetMapping("/api/getuser")
public List<User> geruser() {
		return userRepo.findAll();
	}
	

}
