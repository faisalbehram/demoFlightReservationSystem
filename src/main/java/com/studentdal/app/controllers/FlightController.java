package com.studentdal.app.controllers;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.studentdal.app.entites.Flight;
import com.studentdal.app.repos.FlightRepositry;

// this controller work as FIND all flights and also to FIND flights by dates and from search quesry

@Controller
public class FlightController {
	
	@Autowired
	private FlightRepositry flightRepo;
	
	
	@RequestMapping(value = "findflights",method = RequestMethod.POST)
	public String findFlight(@RequestParam("from") String from,@RequestParam("to") String to,
			@RequestParam("departuredate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date departureDate,ModelMap theModelMap) {
		
		if(from.isEmpty()&&  to.isEmpty()) {
			theModelMap.addAttribute("findmsg", "please fill all the fields");
			return "findflights.jsp";
			
		}
			
		List<Flight> flights =	flightRepo.findFlights(from,to,departureDate);
		System.out.println("date is " + departureDate);
		
		theModelMap.addAttribute("flights", flights);
		return "displayflights.jsp";
	}
	
	// show All flights
	@GetMapping("/allFlights")
	public String findAllFlights(ModelMap theModelMap) {
		List<Flight> flights = flightRepo.findAll();
		theModelMap.addAttribute("flights", flights);
		return "displayflights.jsp";
	}
	
	@GetMapping("/findflightpage")
	public String findflightpage(ModelMap theModelMap) {
		return "findflights.jsp";
	}
	
	
	
	@RequestMapping("admin/showAddFligts")
	public String showAddFligts() {
		
		System.out.println("inside in admin");
		return "ShowAddFligts.jsp";
	}
}
