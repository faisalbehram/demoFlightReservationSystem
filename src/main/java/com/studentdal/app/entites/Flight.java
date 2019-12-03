package com.studentdal.app.entites;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Flight extends AbstractEntity {

	@NotNull(message = "give flight number")
	private String flightNumber;

	@NotNull(message = "give operating airline name")
	private String operatingAirlines;

	@NotNull(message = "give Departure City in BOLD WORLD e.g UAE")
	private String departureCity;

	@NotNull(message = "give Departure City in BOLD WORLD e.g USA")
	private String arrivalCity;

	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;

	public Flight() {

	}

	public Flight(String flightNumber, String operatingAirlines, String departureCity, String arrivalCity,
			Date dateOfDeparture, Timestamp estimatedDepartureTime) {
		super();
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateOfDeparture = dateOfDeparture;
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public Flight(@NotNull(message = "give flight number") String flightNumber,
			@NotNull(message = "give operating airline name") String operatingAirlines) {
		super();
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
