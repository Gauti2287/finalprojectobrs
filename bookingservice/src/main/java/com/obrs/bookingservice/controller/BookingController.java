package com.obrs.bookingservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.obrs.bookingservice.model.Booking;
import com.obrs.bookingservice.model.Businventory;
import com.obrs.bookingservice.model.Passengerbooking;
import com.obrs.bookingservice.model.Payment;
import com.obrs.bookingservice.repository.BookingRepository;
import com.obrs.bookingservice.repository.BusInventoryRepo;

@RestController
@RequestMapping("/booking/api")
public class BookingController {

	Logger logger = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BusInventoryRepo busInventoryRepo;
	
	
	@Autowired
    private WebClient.Builder webClientBuilder;
	   @Autowired
	    ProducerBooking producer;

	@GetMapping("welcome/booking")
	public ResponseEntity<String> welcome() throws JsonProcessingException
	{
		logger.info("NEW DATUM PUBLISHED");

        producer.sendAnalyticPayload("Welcome","BOOKING_DETAILS","wELCOME TO BOOKING SITE");

		return new ResponseEntity<>("Welcome to the booking site", HttpStatus.OK);
		
	}
	@GetMapping("getBookingdetail")
	public ResponseEntity<Booking> getBookingDtls(@RequestParam(name ="bookingno") int bookingno)
	{
		logger.info("Get booking details" + bookingno);
		Optional<Booking> booking=bookingRepository.findById(bookingno);
		
		return new ResponseEntity<Booking>(booking.get(),HttpStatus.OK);
		
	}
	@PostMapping("createbooking")
	public ResponseEntity<String> createBooking(@RequestBody Booking booking) throws JsonProcessingException
	{
		Booking createBooking=new Booking();
		 int noofseat=0;
		 logger.info("Booking of bus no"+booking.getBusno());
		Optional<Businventory> busOptional= busInventoryRepo.findById(booking.getBusno());
		
		if(busOptional.isPresent())
		{
			noofseat=busOptional.get().getAvailableseats();
		if(noofseat>=booking.getNoofseats())
		{
			createBooking.setBusno(booking.getBusno());
			createBooking.setNoofseats(booking.getNoofseats());
			createBooking.setSource(booking.getSource());
			createBooking.setDestinations(booking.getDestinations());
			createBooking.setStatus("PENDING");
			createBooking.setBookingdate(booking.getBookingdate());
			 logger.info("befor Booking of bus no"+booking.getBusno());
			bookingRepository.save(createBooking);
			 logger.info("After Booking of bus no"+booking.getBusno());
			Businventory updatebuBusinventory=new Businventory();
			updatebuBusinventory.setBusno(booking.getBusno());
			updatebuBusinventory.setAvailableseats((noofseat- booking.getNoofseats()));
			updatebuBusinventory.setLastupdateddate(booking.getBookingdate());
			busInventoryRepo.save(updatebuBusinventory);
			
			//Initiate publish message for payment
			Payment payment=new Payment();
			payment.setAmount(400);
			payment.setBookingno(createBooking.getBookingno());
			
			logger.info("NEW Payment DATUM PUBLISHED");

	        producer.sendAnalyticPayload("PAYMENTINITIATE","PAYMENT_DETAILS",payment);

			
			return new ResponseEntity<String>("Current booking status is pending,payment initiated for your booking number: "+createBooking.getBookingno(),HttpStatus.OK);
		}
		
		else
		{
				return new ResponseEntity<String>("No seats are available: "+booking.getBookingno(),HttpStatus.OK);
				
		}
		}
		return new ResponseEntity<String>("Bus is not available ",HttpStatus.OK);
		/*
		 * Mono<Payment> response = null; if(booking.getStatus().equals("PENDING")) { //
		 * send a request to create payment to payment service response =
		 * webClientBuilder.build().post().uri(
		 * "http://localhost:9084/payment-service/api/save/payment").
		 * body(Mono.just(booking),Booking.class).retrieve().bodyToMono(Payment.class);
		 * }
		 * 
		 * return new ResponseEntity<Booking>(HttpStatus.OK);
		 */
		}
	
	@PostMapping("passengerbooking")
	public ResponseEntity<Passengerbooking> savePassengerBooking(@RequestBody Passengerbooking passengerbooking)
	{
		return new ResponseEntity<Passengerbooking>(HttpStatus.OK);
	}
	
	@GetMapping("getavailableseats")
	public ResponseEntity<String> getBookingDetails(@RequestParam int busno)
	{
		/*
		 * Businventory busOptional= busInventoryRepo.findById(busno)
		 * .orElseThrow(()->new RuntimeException("No record found for busno "+busno));
		 * return new ResponseEntity<>(busOptional, HttpStatus.OK);
		 */
		Optional<Businventory> busOptional= busInventoryRepo.findById(busno);
		if (busOptional.isPresent())
		{
		return new ResponseEntity<>("Number of available seat:"+busOptional.get().getAvailableseats(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Seat is not available",HttpStatus.OK);	
		}
		
	}
}
