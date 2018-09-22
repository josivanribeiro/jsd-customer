package com.josivansilva.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "SpecialCustomer")
@DiscriminatorValue("Special")
public class SpecialCustomer extends Customer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "customer_total_patrimony")
	private BigDecimal customerTotalPatrimony;

	public BigDecimal getCustomerTotalPatrimony() {
		return customerTotalPatrimony;
	}

	public void setCustomerTotalPatrimony(BigDecimal customerTotalPatrimony) {
		this.customerTotalPatrimony = customerTotalPatrimony;
	}	
	
}
