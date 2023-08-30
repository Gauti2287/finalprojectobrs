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

//@Getter
//@Setter
@Entity
@Table(name = "businventory")
public class Businventory {
    @Column(name = "busno", length = 20)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int busno;

    @Column(name = "availableseats", precision = 30)
    private int availableseats;

    @Column(name = "lastupdateddate")
    private LocalDate lastupdateddate;

	public int getBusno() {
		return busno;
	}

	public void setBusno(int busno) {
		this.busno = busno;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public LocalDate getLastupdateddate() {
		return lastupdateddate;
	}

	public void setLastupdateddate(LocalDate lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

   
}