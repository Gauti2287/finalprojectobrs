package com.obrs.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.bookingservice.model.Passengerbooking;

@Repository
public interface PassengerbookingRepo extends JpaRepository<Passengerbooking, String>{

}
