package com.studentdal.app.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.studentdal.app.dto.ReservationRequest;
import com.studentdal.app.entites.Documents;
import com.studentdal.app.entites.Flight;
import com.studentdal.app.entites.Reservation;
import com.studentdal.app.repos.DocumentsRepo;
import com.studentdal.app.repos.FlightRepositry;
import com.studentdal.app.service.ReservationService;


// reservation controller work as used all repository such that i use to work with all repositry at same time
// like completing reservation  also send email and generating pdf file
@Controller
public class ReservationController {
	@Autowired
	private FlightRepositry flightRepo;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private DocumentsRepo documentsRepo;

	
	@GetMapping(value = "/showcompletereservation")
	public String showcompletereservation(@RequestParam("flightId") long flightid,Model theModelMap) {
	 
		Optional<Flight> theflight = flightRepo.findById(flightid);
		

		if(theflight == null)
		{
			System.out.println("not found");
			return "displayflights.jsp";
		}else {
		
		theModelMap.addAttribute("flight",theflight);
		System.out.println("found found"+ theflight.get().getArrivalCity());
		System.out.println("found found"+ theflight.get().getId());
		return "completeReservationPage.jsp";
		}
		}
	
	@RequestMapping(value = "/completeTheReservation" ,method = RequestMethod.POST)
	public String completeReservation(@RequestParam("photo") MultipartFile multipartFile, ReservationRequest request,ModelMap theModelMap) {

			
		// its confirming the reservation 
		Reservation reservation = reservationService.bookFlight(request);
		
		Documents documents = new Documents();
		documents.setName(request.getPassengerFirstName());
		documents.setPassenger(request.getPassengerId());
		try {
			documents.setData(multipartFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		documentsRepo.save(documents);
		theModelMap.addAttribute("msg", "Reservation booked successfully " + reservation.getId());
		return "reservationConfirmation.jsp";
	}
}
