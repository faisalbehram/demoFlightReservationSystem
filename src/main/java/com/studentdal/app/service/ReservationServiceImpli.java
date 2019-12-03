package com.studentdal.app.service;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.studentdal.app.dto.ReservationRequest;
import com.studentdal.app.entites.Documents;
import com.studentdal.app.entites.Flight;
import com.studentdal.app.entites.Passenger;
import com.studentdal.app.entites.Reservation;
import com.studentdal.app.repos.FlightRepositry;
import com.studentdal.app.repos.PassengerRepositry;
import com.studentdal.app.repos.ReservationRepositry;
import com.studentdal.app.util.EmailUtil;
import com.studentdal.app.util.PDFGenerator;

@Service
public class ReservationServiceImpli implements ReservationService {

	@Autowired
	private FlightRepositry flightRepo;

	@Autowired
	private PassengerRepositry passengerRepo;

	@Autowired
	private ReservationRepositry reservationRepo;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Value("${file.path}") 
	private String filepaths;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// flight request
		long flightid = request.getFlightId();

		// used to save date in date base as timestamp
		Date date = new Date();
		@SuppressWarnings("unused")
		Timestamp ts = new Timestamp(date.getTime());

		
		// find flight by id 
		Flight flight = flightRepo.findById(flightid).orElseThrow(() -> new EntityNotFoundException());

		// System.out.println("the flight id" + flight.getId() );

		System.out.println("the find by id" + flightRepo.findById(flightid));

		// saving passenger
		//extacting the method
		Passenger passenger = new Passenger();
		Passenger savedPasenger = savingPassenger(request, passenger);
		
		Documents documents = new Documents();
		documents.setName(request.getPassengerFirstName());
		documents.setPassenger(savedPasenger);

		// saving reservation ... and extracting class
		Reservation reservation = new Reservation();
		Reservation saveReservation = savingReservation(flight, savedPasenger, reservation);

	

		// extract the value from properties file
		String filepath = filepaths + saveReservation.getId()
				+ ".pdf";

		// to generate the pdf and save it
		pdfGenerator.generateIternaryReservation(saveReservation, filepath);

		// send it viva email
		emailUtil.sendIternary(passenger.getEmail(), filepath);
		return saveReservation;
	}

	private Reservation savingReservation(Flight flight, Passenger savedPasenger, Reservation reservation) {
		reservation.setFlight(flight);
		System.out.println("the flight details" + flight);

		reservation.setPassenger(savedPasenger);
		System.out.println("the passenger details" + savedPasenger);
		reservation.setCheckedIn(false);

		System.out.println(" this is flight class " + reservation.getFlight() + "this passegner classes "
				+ reservation.getPassenger());
		System.out.println("done");

		Reservation saveReservation = reservationRepo.save(reservation);
		return saveReservation;
	}

	private Passenger savingPassenger(ReservationRequest request, Passenger passenger) {
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPasenger = passengerRepo.save(passenger);
		return savedPasenger;
	}

}


// testing in practice hardcoded
/*
 * this is just testing code {{ Flight flight= new Flight("AA2", "saudi",
 * "makha", "madina", date, ts); System.out.println("the flight id" +
 * flight.getId() + ts + date );
 * 
 * Flight flight = new Flight();
 * 
 * flight.setId(10l); }}
 */

// find flight by id comming from reservation page which id is selected in
// select option from display all flights

// file path where the pdf is to be saved


//
//String filepath = "C:\\Users\\Naveed Shahzad\\Documents\\reservations\\reservation" + saveReservation.getId()
//		+ ".pdf";
//
