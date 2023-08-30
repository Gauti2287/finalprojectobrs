/**
 * 
 */
package com.obrs.busservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.obrs.busservice.model.BusrouteDetail;

/**
 * @author Gautam
 *
 */
@Repository
public interface BusAdminRepo extends JpaRepository<BusrouteDetail, String> {

	
	@Query(value="select * from busroutedetails bd where  bd.source= :source  and  bd.destination= :destination",nativeQuery = true)
	public List <BusrouteDetail> FindBus(@Param(value = "source") String startfrom, @Param(value = "destination")  String to);

	@Modifying
	@Transactional
	@Query(value="delete from busroutedetails bd where bd.busno= :id",nativeQuery = true)
	public void deleteBus(@Param(value="id") int id);

	@Modifying
	@Transactional
	@Query(value="update busroutedetails  set busname= :busname,bustype= :bustype,source=:source,destination=:destination,price =:price where busno= :busno",nativeQuery = true)
	public void update( @Param(value = "busname") String busname, @Param(value = "bustype")  String bustype,
			@Param(value = "source") String source, @Param(value = "destination")  String destination,
			@Param(value = "price") int price, @Param(value = "busno")  int busno);
	
	@Query(value="select * from busroutedetails bd where bd.busno= :id",nativeQuery = true)	
	public BusrouteDetail findbybusno(@Param(value="id") int id);
}
