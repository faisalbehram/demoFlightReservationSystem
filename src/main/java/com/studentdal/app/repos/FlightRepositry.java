package com.studentdal.app.repos;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentdal.app.entites.Flight;

public interface FlightRepositry extends JpaRepository<Flight, Long> {

	//@Query("from Flight where departureCity='NYC' and arrivalCity='AUS' and dateOfDeparture='2014-05-21'")	

	 @Query("FROM Flight WHERE departureCity=?1 and arrivalCity= ?2 and dateOfDeparture= ?3")	
	 List<Flight> findFlights(@RequestParam("departureCity") String from,@RequestParam("arrivalCity") String to,@RequestParam("dateOfDeparture") Date departureDate);

	 //	@Query( from   where DEPARTURE_CITY='NYC' and ARRIVAL_CITY='PAK' and DATE_OF_DEPARTURE ='2015-05-21')

	
 }
	