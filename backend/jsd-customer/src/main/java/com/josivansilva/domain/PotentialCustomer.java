package com.josivansilva.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "PotentialCustomer")
@DiscriminatorValue("Potential")
public class PotentialCustomer extends Customer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "customer_current_debts")
	private BigDecimal customerCurrentDebts;

	public BigDecimal getCustomerCurrentDebts() {
		return customerCurrentDebts;
	}

	public void setCustomerCurrentDebts(BigDecimal customerCurrentDebts) {
		this.customerCurrentDebts = customerCurrentDebts;
	}
	
}
