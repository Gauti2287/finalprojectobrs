package com.obrs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
