/* Copyright josivanSilva (Developer); 2018 */
package com.josivansilva.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;

/**
 * Customer service unit test class.
 * 
 * @author josivan@josivansilva.com
 *
 */
public class CustomerServiceTests {

	@Inject
	private CustomerService customerService;
	
	@Test
	public void testSimulatesLoanWithRiskA () {
		BigDecimal result = null;
		result = customerService.simulatesLoan (12, new BigDecimal (1000), 'A');
		assertNotNull (result);
		assertTrue (result.doubleValue() > 0);
	}
	
	@Test
	public void testSimulatesLoanWithRiskB () {
		BigDecimal result = null;
		result = customerService.simulatesLoan (12, new BigDecimal (1000), 'B');
		assertNotNull (result);
		assertTrue (result.doubleValue() > 0);
	}
	
	@Test
	public void testSimulatesLoanWithRiskC () {
		BigDecimal result = null;
		result = customerService.simulatesLoan (12, new BigDecimal (1000), 'C');
		assertNotNull (result);
		assertTrue (result.doubleValue() > 0);
	}
	
}
