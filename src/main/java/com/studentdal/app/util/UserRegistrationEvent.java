package com.studentdal.app.util;

import org.springframework.context.ApplicationEvent;

import com.studentdal.app.entites.User;


public class UserRegistrationEvent  extends ApplicationEvent{

		/**
	 * this is registration event listner which listen the event 
	 */
	private static final long serialVersionUID = 1L;
		private final User user;
		
	public UserRegistrationEvent(User user) {
		super(user);
		this.user= user;
	}

	public User getUser() {
		return user;
	}

}
