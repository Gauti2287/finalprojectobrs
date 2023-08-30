package com.obrs.payment.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
 
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  transactionid;

    @Column(name = "bookingno", length = 30)
    private int bookingno;

    @Column(name = "paymentdate")
    private LocalDate paymentdate;
    @Column(name = "amount")
    private int  amount; 

    @Column(name = "status")
    private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
  
}