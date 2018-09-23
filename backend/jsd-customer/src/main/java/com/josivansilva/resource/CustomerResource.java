/* Copyright josivanSilva (Developer); 2018 */
package com.josivansilva.resource;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.josivansilva.domain.Customer;
import com.josivansilva.service.CustomerService;

/**
 * Customer rest resource.
 * 
 * @author josivan@josivansilva.com
 *
 */
@Path("customers")
public class CustomerResource {

	@Inject
	private CustomerService customerService;

	@GET
	@Path("simulatesLoan/{parcel}/{loanValue}/{customerRisk}")
	@Produces(MediaType.APPLICATION_JSON)
	public BigDecimal simulatesLoan(@PathParam("parcel") int parcel, @PathParam("loanValue") BigDecimal loanValue,
			@PathParam("customerRisk") Character customerRisk) {

		System.out.println("operation = simulatesLoan");

		return customerService.simulatesLoan(parcel, loanValue, customerRisk);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public boolean insertCustomer(Customer customer) {

		System.out.println("operation = insert");

		System.out.println("customer.getCustomerName() = " + customer.getCustomerName());
		System.out.println("customer.getCustomerType() = " + customer.getCustomerType());
		System.out.println("customer.getCustomerRisk() = " + customer.getCustomerRisk());
		System.out.println("customer.getCustomerAddress() = " + customer.getCustomerAddress());
		System.out.println("customer.getCustomerMonthlyIncome() = " + customer.getCustomerMonthlyIncome());

		return customerService.insert(customer);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean updateCustomer(Customer customer) {

		System.out.println("operation = update");

		System.out.println("customer.getCustomerId() = " + customer.getCustomerId());
		System.out.println("customer.getCustomerName() = " + customer.getCustomerName());
		System.out.println("customer.getCustomerType() = " + customer.getCustomerType());
		System.out.println("customer.getCustomerRisk() = " + customer.getCustomerRisk());
		System.out.println("customer.getCustomerAddress() = " + customer.getCustomerAddress());
		System.out.println("customer.getCustomerMonthlyIncome() = " + customer.getCustomerMonthlyIncome());

		return customerService.update(customer);
	}

	@DELETE
	@Path("/{customerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteCustomer(@PathParam("customerId") int customerId) {

		System.out.println("operation = delete");
		System.out.println("customerId = " + customerId);

		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return customerService.delete(customer);
	}

	@GET
	@Path("/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerById(@PathParam("customerId") int customerId) {

		System.out.println("operation = findById");
		System.out.println("customerId = " + customerId);

		Customer customer = new Customer();
		customer.setCustomerId(customerId);

		return customerService.findById(customer);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {

		System.out.println("operation = findAll");
		
		return customerService.findAll();
	}

}
