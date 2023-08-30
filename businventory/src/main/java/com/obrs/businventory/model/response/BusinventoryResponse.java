package com.obrs.businventory.model.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinventoryResponse {
	 private String busno;

	    private BigDecimal availableseats;

	
	    private LocalDate lastupdateddate;
}
