package com.studentdal.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentdal.app.entites.Reservation;

public interface ReservationRepositry extends JpaRepository<Reservation, Long> {

}
