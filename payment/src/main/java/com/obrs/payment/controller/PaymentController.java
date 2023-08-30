package com.obrs.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.payment.model.Payment;
import com.obrs.payment.repository.PaymentRepository;

@RestController
@RequestMapping("payment/api")
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;
	
	@PostMapping("save/payment")
	public ResponseEntity<String> makePayment(@RequestBody Payment payment)
	{
		Payment savepayment = new Payment();
        
      
       // savepayment.setOfferid(orderRepository.findById(orderstatus.getOrderid()).get().getOfferid());
        savepayment.setStatus("DUE");
		paymentRepository.save(savepayment);
		return new ResponseEntity<String>("Payment Sucessful" ,HttpStatus.OK);
	}
	
	@PostMapping("deletpayment")
	public ResponseEntity<String> deletePayment(@RequestParam int transactionid)
	{
		
		Optional<Payment> payment=paymentRepository.findById(transactionid);
		
		if(payment.isPresent())
		{
		paymentRepository.delete(payment.get());
		return new ResponseEntity<String>("Transaction record is deleted Sucessfuly" ,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No such transaction is available" ,HttpStatus.OK);
		}
	}
}
