package com.studentdal.app.dto;

public class ReservationUpdateRequest {
	
	// it is used for update of rest controller that was used for check in 
	private Long id;
	private Boolean checkedIn;
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	private int numberOfBags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	
	
	
}
