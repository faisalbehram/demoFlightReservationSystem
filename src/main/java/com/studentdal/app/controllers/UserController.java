package com.studentdal.app.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.studentdal.app.entites.Role;
import com.studentdal.app.entites.User;
import com.studentdal.app.repos.RoleRepository;
import com.studentdal.app.repos.UserRepositry;
import com.studentdal.app.repos.VerificationCodeRepository;
import com.studentdal.app.util.UserRegistrationEvent;

@Controller
public class UserController {

	// from user controller user can signin or signup

	// for whitespace
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private UserRepositry userRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	private VerificationCodeRepository veriRepo;

	@Value(value = "${disableEmailVerification}")
	private boolean disableEmailVerification;

	@GetMapping("/login")
	public String loignpage() {
		return "loginpage.jsp";
	}

	@GetMapping("/showreg")
	public String showRegistrationpage(Model theModel) {
		System.out.println("in show reg");
		theModel.addAttribute("user", new User());
		return "registrationpage.jsp";
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String register(@Validated @ModelAttribute("user") User user, BindingResult theBindingResult,
			ModelMap theModelMap, @RequestParam("confirm_password") String confirm_password) {

		// checking the all required fields are not null
		if (theBindingResult.hasErrors()) {
			System.out.println("binding" + user.getEmail() + "/// ");
			return "registrationpage.jsp";
		}

		// checking if gmail already present
		User registeredmail = userRepo.findByEmail(user.getEmail());

		if (registeredmail != null) {
			System.out.println(" in side else iffound address" + user.getEmail() + "/// ");
			theModelMap.addAttribute("msgemail", "email already present");
			return "Home.jsp";
		}
		// confirming password equal
		else if (user.getPassword().equalsIgnoreCase(confirm_password))// saving the user
		{

			System.out.println("inside else address " + user.getEmail() + "/// ");

			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setVerified(disableEmailVerification);
			user.setUsername(user.getUsername());

			System.out.println(user.getEmail());
			System.out.println(user.getFirstName());
			System.out.println(user.getLastName());
			System.out.println(user.getPassword());
			System.out.println(user.getUsername());

			// setting the default role... as USER
			Role role1 = roleRepo.findByName("USER");

			Set<Role> role = new HashSet<>();
			role.add(role1);
			user.setRoles(role);

			System.out.println("user is " + role);

			System.out.println("role is " + role1);

			// if already one user is registered with same name then not save the user...
			// and return back to home to say add uniuqe name

			if (veriRepo.findByUsername(user.getUsername()) == null) {

				// saving the role id and user id in user_role table
				roleRepo.save(role1);
				// saving the user
				userRepo.save(user);

				// event publisher for send email to user .. for veriification
				applicationEventPublisher.publishEvent(new UserRegistrationEvent(user));

				theModelMap.addAttribute("msgUserRegister", "to Login please activate your account from email");
				return "loginpage.jsp";

			} else {
				System.out.println("username is foound ");
				theModelMap.addAttribute("usernamefound", "username is found");
				return "Home.jsp";	
			}
		} else {
			theModelMap.addAttribute("msgemail", "password not match");
			return "Home.jsp";
		}

	}

	// forgot password controller

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	// it will show the forgot password page
	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public ModelAndView displayResetPassword(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("forgotpassword.jsp");
		return modelAndView;
	}

	@Autowired
	private JavaMailSender sender;

	// Receive the address and send an email
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public ModelAndView forgotUserPassword(ModelAndView modelAndView, User user) {
		User existingUser = userRepo.findByEmail(user.getEmail());
		if (existingUser != null) {

			// Create the email
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(existingUser.getEmail());
			mailMessage.setSubject("Complete Password Reset!");
			mailMessage.setFrom("test-email@gmail.com");
			mailMessage.setText("To complete the password reset process, please click here: "
					+ "https://localhost:8443/confirm-reset?token=" + existingUser.getId());

			// Send the email
			sender.send(mailMessage);

			modelAndView.addObject("message",
					"Request to reset password received. Check your inbox for the reset link.");
			modelAndView.setViewName("Home.jsp");

		} else {
			modelAndView.addObject("message", "This email address does not exist!");
			modelAndView.setViewName("Home.jsp");
		}
		return modelAndView;
	}

	// showing reset page...
	// to rest the password

	@RequestMapping(value = "/confirm-reset", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView validateResetToken(ModelAndView modelAndView, @RequestParam("token") Long confirmationToken) {

		if (confirmationToken != null) {
			User user = userRepo.findById(confirmationToken).orElseThrow();
			modelAndView.addObject("user", user);
			modelAndView.addObject("emailId", user.getEmail());
			modelAndView.setViewName("resetpassword.jsp");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("Home.jsp");
		}

		return modelAndView;
	}

	/**
	 * Receive the token from the link sent via email and display form to reset
	 * password when click reset the password will be reset
	 * 
	 */
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	public ModelAndView resetUserPassword(ModelAndView modelAndView, User user) {
		// ConfirmationToken token =
		// confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (user.getEmail() != null) {
			// use email to find user
			User tokenUser = userRepo.findByEmail(user.getEmail());
			tokenUser.setPassword(passEncoder.encode(user.getPassword()));
			System.out.println(tokenUser.getPassword());

			userRepo.save(tokenUser);
			modelAndView.addObject("message",
					"Password successfully reset. You can now log in with the new credentials.");
			modelAndView.setViewName("Home.jsp");
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("Home.jsp");
		}

		return modelAndView;
	}


	@RequestMapping("/testinginline")
	public String testing() {
//	User user1 = new User("newtest", "newtest", "inline112@gmail.com", "test123");
		User user1 = new User();
		user1.setFirstName("faisal");
		user1.setLastName("behram");
		user1.setEmail("user123@gmail.com");
		user1.setPassword("test123");

		Role role1 = new Role();
		role1.setName("USER");

		Set<Role> role = new HashSet<>();

		System.out.println("user is " + user1);
		role.add(role1);

		user1.setRoles(role);

		System.out.println("user is " + role);

		System.out.println("role is " + role1);

		roleRepo.save(role1);
		userRepo.save(user1);

		return "test.jsp";

	}

}
