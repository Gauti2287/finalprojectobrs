/**
 * 
 */
package com.obrs.loginservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.loginservice.model.Obrscredential;
import com.obrs.loginservice.model.Obrsuserdetail;
import com.obrs.loginservice.repository.CredentialsRepo;
import com.obrs.loginservice.repository.LoginUserDetailRepo;



/**
 * @author Gautam
 *
 */
@RestController
@RequestMapping("api/")
public class LoginController {

	@Autowired
	CredentialsRepo credentialsRepo;
	
	@Autowired
	LoginUserDetailRepo loginUserDetailRepo;
	
	@GetMapping("welcome")
	public ResponseEntity<String> welcome()
	{
		return new ResponseEntity("Welcome to Online Bus Reservation , can be called as OBRS", HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> saveCredinitials(@RequestBody Obrscredential credentials)
	{
		System.out.println("username " +credentials.getUsername());
		
		Optional<Obrscredential> cred=credentialsRepo.findById(credentials.getUsername());
		if (cred.isPresent())
		{
			return new ResponseEntity<String>("User name already exists", HttpStatus.OK);
		}
		else {
		
			credentialsRepo.save(credentials);
			return new ResponseEntity<String>("Signup Sucessful", HttpStatus.OK);
		}
		
		
	}
	
	@PostMapping("saveuserdetails")
	public ResponseEntity<String> saveUserdetails(@RequestBody Obrsuserdetail obrsuserdetail)
	{
		//Optional<Obrscredential> cred=credentialsRepo.findById(obrsuserdetail.getUsername());
		/*
		 * if (cred.isPresent()) {
		 * loginUserDetailRepo.updateUserDetails(obrsuserdetail.getUsername(),
		 * obrsuserdetail.getFname(), obrsuserdetail.getLname(),
		 * obrsuserdetail.getCity(), obrsuserdetail.getState(),
		 * obrsuserdetail.getEmail(), obrsuserdetail.getCountry(),
		 * obrsuserdetail.getUsertype());
		 * 
		 * return new ResponseEntity<Obrsuserdetail>(obrsuserdetail, HttpStatus.OK); }
		 * else
		 */	
		
			
		if(credentialsRepo.findById(obrsuserdetail.getUsername())
				.filter(i->i.getUsername().equals(obrsuserdetail.getUsername())).isPresent())
		{
		
		
			if(!loginUserDetailRepo.findById(obrsuserdetail.getUsername())
					.filter(i->i.getUsername().equalsIgnoreCase(obrsuserdetail.getUsername())).isPresent())
			{
				
			loginUserDetailRepo.save(obrsuserdetail);
			return new ResponseEntity<String>("User details added sucefully", HttpStatus.OK);
		}	
		
		}
	
			return new ResponseEntity<String>("Signup detail is not available",HttpStatus.OK);
	
		
	}
	
	@PostMapping("auth")
	public ResponseEntity<String> authenticate(@RequestBody Obrscredential obrscredential)
	{
		if(credentialsRepo.findById(obrscredential.getUsername())
				.filter(i->i.getUsername().equals(obrscredential.getUsername())
						&& i.getPassword().equals(obrscredential.getPassword())).isPresent())
		{
		
		return new ResponseEntity<>("USER-AUTHENTICATED=TRUE",HttpStatus.OK);
	}
		else {
			return new ResponseEntity<>("USER-AUTHENTICATED=FALSE",HttpStatus.OK);
		}
}
}