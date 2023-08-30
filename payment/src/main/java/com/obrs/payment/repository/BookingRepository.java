/**
 * 
 */
package com.obrs.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.payment.model.Booking;


/**
 * @author Gautam
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer > {

}
