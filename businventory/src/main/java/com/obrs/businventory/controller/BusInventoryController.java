package com.obrs.businventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.businventory.model.Businventory;
import com.obrs.businventory.repo.BusInventoryRepo;

@RestController
@RequestMapping("inventory/api")
public class BusInventoryController {

	@Autowired
	BusInventoryRepo busInventoryRepo;
	
	@GetMapping("/getavailableseats/{busno}")
	public ResponseEntity<Businventory> getAvailableSeat(@PathVariable int busno )
	{
		Businventory busOptional= busInventoryRepo.findById(busno)
				.orElseThrow(()->new RuntimeException("No record found for busno "+busno));
	
		return new ResponseEntity<>(busOptional, HttpStatus.OK);
		
		
	}
	
	@PutMapping("/updateseat")
	public ResponseEntity<Businventory> updateseat(@RequestBody Businventory businventory)
	
	{
		
		  Businventory updatebusinventory=
		  busInventoryRepo.findById(businventory.getBusno()) .orElseThrow(()->new
		  RuntimeException("Record not found"));
		  
		  updatebusinventory.setAvailableseats(businventory.getAvailableseats());
		  updatebusinventory.setLastupdateddate(businventory.getLastupdateddate());
		  busInventoryRepo.save(updatebusinventory);
		 
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@PostMapping("saveseatdetails")
	public ResponseEntity<Businventory> saveBusDetails(@RequestBody Businventory businventory)
	{
	
		busInventoryRepo.save(businventory);
		return new ResponseEntity<Businventory>(businventory,HttpStatus.OK);
	}
}
