package com.obrs.bookingservice.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="bookingdetails")
@Getter
@Setter
public class Booking {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingno;
	
	 @Column(name = "busno", length = 50)
	private int busno;
	 
	 @Column(name = "bookingdate")
	private LocalDate bookingdate;
	 
	 @Column(name = "source", length = 50)
	private String source;
	 
	 @Column(name = "destinations", length = 50)
	private String destinations;
	 
	 @Column(name = "noofseats", length = 50)
	private int noofseats;
	 
	 @Column(name = "status", length = 50)
	private String  status;

	public int getBookingno() {
		return bookingno;
	}

	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}

	public int getBusno() {
		return busno;
	}

	public void setBusno(int busno) {
		this.busno = busno;
	}

	public LocalDate getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(LocalDate bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinations() {
		return destinations;
	}

	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}

	public int getNoofseats() {
		return noofseats;
	}

	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
