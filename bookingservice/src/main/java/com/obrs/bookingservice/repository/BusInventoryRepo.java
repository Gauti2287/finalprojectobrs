package com.obrs.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.bookingservice.model.Businventory;

@Repository
public interface BusInventoryRepo extends JpaRepository<Businventory, Integer> {

}
