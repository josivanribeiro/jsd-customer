/* Copyright josivanSilva (Developer); 2018 */
package com.josivansilva.dto;

import java.math.BigDecimal;

import com.josivansilva.domain.CommonCustomer;
import com.josivansilva.domain.Customer;
import com.josivansilva.domain.PotentialCustomer;
import com.josivansilva.domain.SpecialCustomer;
import com.josivansilva.util.Constants;

/**
 * Customer dto class.
 * 
 * @author josivan@josivansilva.com
 *
 */
public class CustomerDTO {

	private int customerId;
	private String customerType;
	private String customerName;
	private BigDecimal customerMonthlyIncome;
	private Character customerRisk;
	private String customerAddress;
	private BigDecimal customerTotalPatrimony;
	private BigDecimal customerCurrentDebts;
	private boolean customerEmployed;

	public Customer DTOToEntity () {
		Customer customer = null;
		if (customerType.equals (Constants.CUSTOMER_TYPE_SPECIAL)) {
			SpecialCustomer specialCustomer = new SpecialCustomer ();
			specialCustomer.setCustomerId (customerId);
			specialCustomer.setCustomerName (customerName);
			specialCustomer.setCustomerMonthlyIncome (customerMonthlyIncome);
			specialCustomer.setCustomerType (customerType);
			specialCustomer.setCustomerRisk (customerRisk);
			specialCustomer.setCustomerAddress (customerAddress);
			specialCustomer.setCustomerTotalPatrimony (customerTotalPatrimony);
			customer = specialCustomer;
		} else if (customerType.equals (Constants.CUSTOMER_TYPE_POTENTIAL)) {
			PotentialCustomer potentialCustomer = new PotentialCustomer ();
			potentialCustomer.setCustomerId (customerId);
			potentialCustomer.setCustomerName (customerName);
			potentialCustomer.setCustomerMonthlyIncome (customerMonthlyIncome);
			potentialCustomer.setCustomerType (customerType);
			potentialCustomer.setCustomerRisk (customerRisk);
			potentialCustomer.setCustomerAddress (customerAddress);
			potentialCustomer.setCustomerCurrentDebts (customerCurrentDebts);
			customer = potentialCustomer;
		} else if (customerType.equals (Constants.CUSTOMER_TYPE_COMMON)) {
			CommonCustomer commonCustomer = new CommonCustomer ();
			commonCustomer.setCustomerId (customerId);
			commonCustomer.setCustomerName (customerName);
			commonCustomer.setCustomerMonthlyIncome (customerMonthlyIncome);
			commonCustomer.setCustomerType (customerType);
			commonCustomer.setCustomerRisk (customerRisk);
			commonCustomer.setCustomerAddress (customerAddress);
			commonCustomer.setCustomerEmployed (customerEmployed);
			customer = commonCustomer;
		}
		return customer;
	}
	
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

	public BigDecimal getCustomerTotalPatrimony() {
		return customerTotalPatrimony;
	}

	public void setCustomerTotalPatrimony(BigDecimal customerTotalPatrimony) {
		this.customerTotalPatrimony = customerTotalPatrimony;
	}

	public BigDecimal getCustomerCurrentDebts() {
		return customerCurrentDebts;
	}

	public void setCustomerCurrentDebts(BigDecimal customerCurrentDebts) {
		this.customerCurrentDebts = customerCurrentDebts;
	}

	public boolean isCustomerEmployed() {
		return customerEmployed;
	}

	public void setCustomerEmployed(boolean customerEmployed) {
		this.customerEmployed = customerEmployed;
	}
	
}
