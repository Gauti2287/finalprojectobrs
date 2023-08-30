package com.obrs.businventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.businventory.model.Businventory;

@Repository
public interface BusInventoryRepo extends JpaRepository<Businventory, Integer> {

}
