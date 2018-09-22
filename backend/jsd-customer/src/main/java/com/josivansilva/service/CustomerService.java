/* Copyright josivanSilva (Developer); 2018 */
package com.josivansilva.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.josivansilva.domain.Customer;
import com.josivansilva.repository.CustomerRepository;
import com.josivansilva.util.Constants;

/**
 * Customer service class.
 * 
 * @author josivan@josivansilva.com
 *
 */
public class CustomerService {

	/**
	 * Singleton class by Eager Initialization
	 */
	public static CustomerService SINGLETON = new CustomerService();
	
	private CustomerRepository customerRepository = CustomerRepository.SINGLETON;
	
	/**
	 * Private constructor.
	 */
	private CustomerService () {
		
	}
	
	/**
	 * Inserts a new customer.
	 * 
	 * @param customer the customer.
	 * @return
	 */
	public boolean insert (Customer customer) {
		return customerRepository.insert (customer);
	}
	
	/**
	 * Updates a customer.
	 * 
	 * @param customer the customer.
	 * @return
	 */
	public boolean update (Customer customer) {
		return customerRepository.update (customer);
	}
	
	/**
	 * Deletes a customer.
	 * 
	 * @param customer the customer.
	 * @return
	 */
	public boolean delete (Customer customer) {
		return customerRepository.delete (customer);
	}
	
	/**
	 * Finds a customer by id.
	 * 
	 * @param customer the customer.
	 * @return
	 */
	public Customer findById (Customer customer) {
		return customerRepository.findById (customer);
	}
	
	/**
	 * Finds all the customers.
	 * 
	 * @return
	 */
	public List<Customer> findAll () {
		return customerRepository.findAll();
	}
	
	/**
	 * Simulates a loan.
	 * 
	 * @param parcel the parcel.
	 * @param loanValue the loan value.
	 * @param customerRisk the customer risk.
	 * @return
	 */
	public BigDecimal simulatesLoan (int parcel, BigDecimal loanValue, Character customerRisk) {
		BigDecimal result = BigDecimal.ZERO;
		double taxRate = 0.0;
		
		if (customerRisk == Constants.RISK_A) {
			taxRate = Constants.RISK_A_TAX_RATE;
		} else if (customerRisk == Constants.RISK_B) {
			taxRate = Constants.RISK_B_TAX_RATE;
		} else if (customerRisk == Constants.RISK_C) {
			taxRate = Constants.RISK_C_TAX_RATE;
		}		
		
		result = loanValue.multiply (new BigDecimal (taxRate)).divide (new BigDecimal(parcel), MathContext.DECIMAL128);
		
		return result;
	}
	
}
