package com.studentdal.app.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationSuccessHandlerImpli implements AuthenticationSuccessHandler {

	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
//		boolean hasUserRole = false;
//		boolean hasAdminRole = false;
//		
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		for (GrantedAuthority grantedAuthority : authorities) {
//			if (grantedAuthority.getAuthority().equals("USER")) {
//				hasUserRole = true;
//				break;
//			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
//				hasAdminRole = true;
//				break;
//			}
//			
//			if (hasUserRole) {
//				redirectStrategy.sendRedirect(request, response, "/");
//			} else if (hasAdminRole) {
//				redirectStrategy.sendRedirect(request, response, "/allFlights");
//			} else {
//				throw new IllegalStateException();
//			}
			
		redirectStrategy.sendRedirect(request, response, "/");
		
	}

}
