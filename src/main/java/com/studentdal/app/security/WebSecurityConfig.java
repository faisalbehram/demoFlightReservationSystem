package com.studentdal.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;


	//private AuthenticationSuccessHandlerImpli successHandler;

//	@Autowired
//	@Qualifier("oauth2authSuccessHandler")
//	private AuthenticationSuccessHandler oauth2authSuccessHandler;
	
	
	// use for authentication provided by spring boot
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();	
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;	
	}
	
	// user login and show ROLE of every one
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	//	.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").authenticated()
		.antMatchers("/admin/**","/allFlights").hasAuthority("ADMIN").anyRequest().authenticated()
		.antMatchers("/findflightpage","/findflights","/showcompletereservation/**").hasAnyAuthority("USER","ADMIN").anyRequest().authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").usernameParameter("email").permitAll()
		.and()
//		.rememberMe().authenticationSuccessHandler(new AuthenticationSuccessHandlerImpli())
		.rememberMe().rememberMeParameter("remember-me").key("uniquestring").tokenValiditySeconds(90).tokenRepository(persistentTokenRepository())
		.userDetailsService(userDetailsService)
		.and()
		.oauth2Login().loginPage("/login")
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout").deleteCookies("remember-me");
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	 return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;	
	}
	
}
