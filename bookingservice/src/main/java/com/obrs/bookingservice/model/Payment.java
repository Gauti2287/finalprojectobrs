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


public class Payment {
 

    private int  transactionid;

   
    private int bookingno;

  
    private LocalDate paymentdate;
   
    private String status;
    
    private int  amount;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	
	public LocalDate getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(LocalDate paymentdate) {
		this.paymentdate = paymentdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBookingno() {
		return bookingno;
	}
	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}
	@Override
	public String toString() {
		return "Payment{" +
		        "transactionid='" + transactionid+ '\'' +
		        ", bookingno'" + bookingno + '\'' +
		        ", paymentdate='" + paymentdate + '\'' +
		        ", amount='" + amount + '\'' +   
		        
		        ", status='" + status + '\'' +
		        '}';
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 

  
}