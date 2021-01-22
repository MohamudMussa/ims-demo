package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	/**
	 *  The thing I want to fake functionality for
	 */
	@Mock
	private CustomerServices customerServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	/**
	 * Read Latest
	 */
	@Test
	public void readAllTest() {
		CustomerController customerController = new CustomerController(customerServices);
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P", "A"));
		customers.add(new Customer("Rhys", "T", "A"));
		customers.add(new Customer("Nic", "J", "A"));
		Mockito.when(customerServices.readAll()).thenReturn(customers);
		assertEquals(customers, customerController.readAll());
	}
	
	/**
	 * Create Test
	 */

	@Test
	public void createTest() {
		String id = "1";
		String firstName = "Chris";
		String surname = "Perrins";
		String address = "address";
		Mockito.doReturn(id, firstName, surname, address).when(customerController).getInput();
		Customer customer = new Customer(firstName, surname, address);
		Customer savedCustomer = new Customer(1L, "Chris", "Perrins", "address");
		Mockito.when(customerServices.create(customer)).thenReturn(savedCustomer);
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * UpdateTest
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String firstName = "Rhys";
		String surname = "Thompson";
		String address = "address";
		Mockito.doReturn(id, firstName, surname, address).when(customerController).getInput();
		Customer customer = new Customer(1L, firstName, surname, address);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}
	

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1L);
	}
	
}
