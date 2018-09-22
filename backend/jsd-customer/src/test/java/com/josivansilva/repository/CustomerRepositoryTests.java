/* Copyright josivanSilva (Developer); 2018 */
package com.josivansilva.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.josivansilva.domain.CommonCustomer;
import com.josivansilva.domain.Customer;
import com.josivansilva.domain.PotentialCustomer;
import com.josivansilva.domain.SpecialCustomer;

/**
 * Customer repository unit tests.
 * 
 * @author josivan@josivansilva.com
 *
 */
public class CustomerRepositoryTests {

	@SuppressWarnings("unused")
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("josivansilva");

	private CustomerRepository customerRepository = CustomerRepository.SINGLETON; 
	
	@Test
	public void testInsertSpecialCustomer () {
		SpecialCustomer specialCustomer = new SpecialCustomer ();
		specialCustomer.setCustomerName("Josivan Ribeiro da Silva");
		specialCustomer.setCustomerType("Special");
		specialCustomer.setCustomerRisk('A');
		specialCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		specialCustomer.setCustomerTotalPatrimony(new BigDecimal (190000));
		specialCustomer.setCustomerAddress("Rua Albion, 155, Apto. 12, Bloco A.");
				
		assertTrue (customerRepository.insert (specialCustomer));		
	}
	
	@Test
	public void testInsertPotentialCustomer () {
		PotentialCustomer potentialCustomer = new PotentialCustomer ();
		potentialCustomer.setCustomerName("Maria Nazaré");
		potentialCustomer.setCustomerType("Potential");
		potentialCustomer.setCustomerRisk('B');
		potentialCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		potentialCustomer.setCustomerAddress("Rua Albion, 255, Apto. 15, Bloco B.");
		potentialCustomer.setCustomerCurrentDebts(new BigDecimal (2000));		
		assertTrue (customerRepository.insert (potentialCustomer));
	}
	
	@Test
	public void testInsertCommonCustomer () {
		CommonCustomer commonCustomer = new CommonCustomer ();
		commonCustomer.setCustomerName("Antonieta Ribeiro");
		commonCustomer.setCustomerType("Common");
		commonCustomer.setCustomerRisk('C');
		commonCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		commonCustomer.setCustomerAddress("Rua Albion, 355, Apto. 16, Bloco C.");
		commonCustomer.setCustomerEmployed (true);		
		assertTrue (customerRepository.insert (commonCustomer));
	}
	
	@Test
	public void testUpdateCommonCustomer () {
		CommonCustomer commonCustomer = new CommonCustomer ();
		commonCustomer.setCustomerId (3);
		commonCustomer.setCustomerName("Antonieta Ribeiro1");
		commonCustomer.setCustomerType("Common");
		commonCustomer.setCustomerRisk('C');
		commonCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		commonCustomer.setCustomerAddress("Rua Albion, 344, Apto. 16, Bloco C.");
		commonCustomer.setCustomerEmployed (false);		
		assertTrue (customerRepository.update (commonCustomer));
	}
	
	@Test
	public void testUpdatePotentialCustomer () {
		PotentialCustomer potentialCustomer = new PotentialCustomer ();
		potentialCustomer.setCustomerId (2);
		potentialCustomer.setCustomerName("Maria Nazaré1");
		potentialCustomer.setCustomerType("Potential");
		potentialCustomer.setCustomerRisk('C');
		potentialCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		potentialCustomer.setCustomerAddress("Rua Albion, 555, Apto. 15, Bloco B.");
		potentialCustomer.setCustomerCurrentDebts(new BigDecimal (3000));		
		assertTrue (customerRepository.update (potentialCustomer));
	}
	
	@Test
	public void testUpdateSpecialCustomer () {
		SpecialCustomer specialCustomer = new SpecialCustomer ();
		specialCustomer.setCustomerId(1);
		specialCustomer.setCustomerName("Josivan Ribeiro da Silva1");
		specialCustomer.setCustomerType("Special");
		specialCustomer.setCustomerRisk('A');
		specialCustomer.setCustomerMonthlyIncome (new BigDecimal(9000));
		specialCustomer.setCustomerTotalPatrimony(new BigDecimal (190000));
		specialCustomer.setCustomerAddress("Rua Albion, 255, Apto. 12, Bloco A.");
				
		assertTrue (customerRepository.update (specialCustomer));		
	}
	
	@Test
	public void testDeleteCustomer () {
		SpecialCustomer specialCustomer = new SpecialCustomer ();
		specialCustomer.setCustomerId(1);
		
		assertTrue (customerRepository.delete (specialCustomer));		
	}
	
	@Test
	public void testFindAllCustomer () {
		List<Customer> customerList = null;
		
		customerList = customerRepository.findAll();
		
		assertNotNull (customerList);
		assertTrue (customerList.size() > 0);
	}
	
}
