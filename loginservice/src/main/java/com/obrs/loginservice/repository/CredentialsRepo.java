/**
 * 
 */
package com.obrs.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.obrs.loginservice.model.Obrscredential;

/**
 * @author Gautam
 *
 */
@Repository
public interface CredentialsRepo extends JpaRepository<Obrscredential, String>{

}
