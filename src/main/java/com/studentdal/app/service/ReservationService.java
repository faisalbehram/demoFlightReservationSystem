package com.studentdal.app.service;

import com.studentdal.app.dto.ReservationRequest;
import com.studentdal.app.entites.Reservation;

public interface ReservationService {
	
	// to book reservation
		public Reservation bookFlight(ReservationRequest request);
}
