/**
 * 
 */
package com.obrs.busservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.busservice.model.BusrouteDetail;
import com.obrs.busservice.repository.BusAdminRepo;

/**
 * @author Gautam
 *
 */
@RestController
@RequestMapping("busservice/api/")
public class BusAdminController {
	
	@Autowired
	BusAdminRepo busAdminRepo;

	@PostMapping("savebusdetails")
	public ResponseEntity<BusrouteDetail> saveBusDetails(@RequestBody BusrouteDetail obrsbusdetail )
	{
	
		busAdminRepo.save(obrsbusdetail);		
		return new ResponseEntity<BusrouteDetail>(obrsbusdetail,HttpStatus.OK);
	}
	@PostMapping("updatebusdetails")
	public ResponseEntity<String> updateBusDetails(@RequestBody BusrouteDetail obrsbusdetail )
	{
	
		String busname = obrsbusdetail.getBusname();
		String bustype = obrsbusdetail.getBustype();
		String source = obrsbusdetail.getSource();
		String destination = obrsbusdetail.getDestination();
		int price = obrsbusdetail.getPrice();
		int busno = obrsbusdetail.getBusno();
		BusrouteDetail objbusr=busAdminRepo.findbybusno(busno);
		if(objbusr!=null) {
		busAdminRepo.update(busname,bustype,source,destination,price,busno);
		
		return new ResponseEntity<String>("Rec"
				+ "ord updated sucessfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No record for bus no "+busno,HttpStatus.OK);
		}
	}
	
	@GetMapping("searchBusDetails")
	public List<BusrouteDetail> getBusDetails(@RequestParam String source, @RequestParam String destination)	
	{
		List <BusrouteDetail> lstobrsbus=new ArrayList<>();
		lstobrsbus=busAdminRepo.FindBus(source,destination);
		return lstobrsbus;
	}
	
	@GetMapping("getAllBusDetails")
	public List<BusrouteDetail> getBusDetails()	
	{	
		List <BusrouteDetail> lstobrsbus=new ArrayList<>();
		lstobrsbus=busAdminRepo.findAll();
		return lstobrsbus;
	}
	
	@PostMapping("deletebusdetail")
	public ResponseEntity<String> deleteBusDetail(@RequestParam int id)
	{
		
	    busAdminRepo.deleteBus(id);
		return new ResponseEntity<String>("Bus details deleted sucessfully",HttpStatus.OK);
	}
	
}
