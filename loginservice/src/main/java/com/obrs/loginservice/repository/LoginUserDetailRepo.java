/**
 * 
 */
package com.obrs.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.loginservice.model.Obrsuserdetail;

/**
 * @author Gautam
 *
 */
@Repository
public interface LoginUserDetailRepo extends JpaRepository<Obrsuserdetail, String > {
	
	
	/*
	 * @Modifying
	 * 
	 * @Query("update obrsuserdetails set  fname=:fname, lname=:lname, city=:city ,state=:state ,email=:email, "
	 * + "country=:country,usertype=:usertype where username=:username") public void
	 * updateUserDetails(@Param("username") String username,@Param("fname")String
	 * fname,@Param("lname") String lname,@Param("city")String
	 * city,@Param("state")String state,@Param("email")String email,
	 * 
	 * @Param("country")String country,@Param("usertype")String usertype );
	 */
}
