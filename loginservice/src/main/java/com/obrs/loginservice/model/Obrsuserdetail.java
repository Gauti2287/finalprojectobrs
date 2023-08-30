package com.obrs.loginservice.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "obrsuserdetails")
public class Obrsuserdetail implements Serializable {

    //@OneToOne(fetch = FetchType.LAZY, optional = false)
    @Id
    @Column(name = "username", nullable = false)
	
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "fname", length = 50)
    private String fname;

    @Column(name = "lname", length = 50)
    private String lname;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "usertype", length = 20)
    private String usertype;

  
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

}