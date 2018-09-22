package com.josivansilva.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", unique = true)
    private int customerId;
	
	@Column(name = "customer_type")
	private String customerType;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_monthly_income")
	private BigDecimal customerMonthlyIncome;
	
	@Column(name = "customer_risk")
	private Character customerRisk;
	
	@Column(name = "customer_address")
	private String customerAddress;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getCustomerMonthlyIncome() {
		return customerMonthlyIncome;
	}

	public void setCustomerMonthlyIncome(BigDecimal customerMonthlyIncome) {
		this.customerMonthlyIncome = customerMonthlyIncome;
	}

	public Character getCustomerRisk() {
		return customerRisk;
	}

	public void setCustomerRisk(Character customerRisk) {
		this.customerRisk = customerRisk;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
