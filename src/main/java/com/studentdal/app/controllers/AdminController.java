package com.studentdal.app.controllers;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentdal.app.entites.Flight;
import com.studentdal.app.entites.User;
import com.studentdal.app.repos.FlightRepositry;
import com.studentdal.app.repos.UserRepositry;
import com.studentdal.app.service.RoleService;


// this is used for admin controller

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserRepositry userRepo;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FlightRepositry flightRepo;

	@GetMapping("/welcome")
	public String loginasAdmin() {
		return "welcome.jsp";
	}

	@GetMapping("/showAllUser")
	public String addAdmin(Model theModel) {
		List<User> user =userRepo.findAll();
		theModel.addAttribute("users", user);
		return "showAllUser.jsp";
	}

	@GetMapping("/addFlights")
	public String ShowAddFlights(Model theModel) {
		theModel.addAttribute("flight", new Flight());
		return "ShowAddFligts.jsp";
	}
	
	// adding flight to database
	@RequestMapping(value = "/AddedFlights",method = RequestMethod.POST)
	public String Added(@RequestParam("flightNumber") String flightNumber,
						@RequestParam("operatingAirlines") String operatingAirlines,
						@RequestParam("arrivalCity") String arrivalCity,
						@RequestParam("departureCity") String departureCity,
						@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateOfDeparture,
						ModelMap theModelMap) {
		Flight flight = new Flight();
		flight.setFlightNumber(flightNumber);
		flight.setOperatingAirlines(operatingAirlines);
		flight.setArrivalCity(arrivalCity);
		flight.setDepartureCity(departureCity);
		flight.setDateOfDeparture(dateOfDeparture);
	//	flight.setEstimatedDepartureTime(estimatedDepartureTime);
		
		Date date= new Date();
		 
		 long time = date.getTime();
		     System.out.println("Time in Milliseconds: " + time);
		 
		 Timestamp ts = new Timestamp(time);
		 System.out.println("Current Time Stamp: " + ts);
		flight.setEstimatedDepartureTime(ts);
		
		//Timestamp timesr =new Timestamp(2018, 10, 1, 10, 10, 10, 0);
		//flight.setEstimatedDepartureTime(timesr);
		flightRepo.save(flight);
		
		theModelMap.addAttribute("addFlightMsg", "Flight Added to the database");
		
		return "/";
	}
	
	
	
	
	// updating the role  and ALso Assigning the role
	@GetMapping("/assignRolepage" )
	public String assignRolee(@RequestParam("userId") Long id,Model theModel)
	{
		LOGGER.info("inside the Assign Role");
		System.out.println("in update link");
		Optional<User> user = userRepo.findById(id);
		theModel.addAttribute("user", user);
		return "assignRole.jsp";
	}
	
	@PostMapping("/updateRole")
	public String updateRole(@ModelAttribute("user") User user,@RequestParam("role") String role) {
		LOGGER.info("inside the Assign Role");
		System.out.println("user  is " + role );
		
		roleService.AddRole(user,role);
		System.out.println();
		System.out.println("user  is " +user );
		return "/admin/showAllUser.jsp";
	}
	
	
}
