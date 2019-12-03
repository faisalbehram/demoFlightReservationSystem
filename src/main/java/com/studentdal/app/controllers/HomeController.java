package com.studentdal.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String home(@RequestParam( value = "logout", required = false) String logout ,Model theModelMap) {
		if(logout !=null) {
		theModelMap.addAttribute("msglogout", "you have been succussfully lougout");
		}
		int d=40;
		theModelMap.addAttribute("users",d);
		System.out.println("in home");
		return "Home.jsp";
	}
	
	
	
	
	
	// just for testing thymleaf
	@GetMapping("/test")
	public ModelAndView footer() {
		System.out.println("in footer");
		ModelAndView mv = new ModelAndView();
		mv.addObject("test.html");
		return mv;
	}

//	@GetMapping ("/")
//	public ModelAndView home(@RequestParam( value = "logout", required = false) String logout ,ModelMap theModelMap) {
//		if(logout !=null) {
//			theModelMap.addAttribute("msglogout", "you have been succussfully lougout");
//			}
//		ModelAndView mv  = new ModelAndView();
//		mv.addObject("Home.jsp");
//		return mv;
//		
//	}
}
