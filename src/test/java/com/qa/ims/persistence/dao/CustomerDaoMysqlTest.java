package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.Ims;
import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/Mohamud/resources/sql-schema.sql");
	}

	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from customers;");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}
	/**
	 * UpdateTest
	 */
	@Test
	public void createTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		String first_name = "Mohamud";
		String surname = "Mussa";
		String address = "address";

		Customer customer = new Customer(first_name, surname, address);
		Customer savedCustomer = new Customer(1L, first_name, surname, address);

		customer = customerDaoMysql.create(customer);
		assertEquals(savedCustomer, customer);
	}
	/**
	 * readTest
	 */
	@Test
	public void readTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		List<Customer> customers = List.of(new Customer(1L, "Mohamud", "Mussa", "Address"),
				new Customer(1L, "Mohamud", "Mussa", "Address"),
				new Customer(3L, "saved_test", "saved_tester", "Address"));
		for (Customer customer : customers) {
			customerDaoMysql.create(customer);
		}
		assertEquals(customers, customerDaoMysql.readAll());
	}
	
	/**
	 * readLatestTest
	 */
	@Test
	public void readLatestTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		Long customer_id = 1L;
		String first_name = "Mohamud";
		String surname = "Mussa";
		String address = "address";
		Customer cust_test = new Customer(customer_id, first_name, surname, address);
		Customer cust_test2 = new Customer(customer_id, first_name, surname, address);
		Customer CustomerMade = new Customer(1L, first_name, surname, address);

		customerDaoMysql.create(cust_test);
		customerDaoMysql.create(cust_test2);
		assertEquals(CustomerMade, customerDaoMysql.readLatest());
	}
	/**
	 * updateTest
	 */
	@Test
	public void updateTest() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(username, password);
		String first_name = "Mohamud";
		String surname = "Mussa";
		String address = "address";
		Customer customer = new Customer(first_name, surname, address);
		Customer savedCustomer = new Customer(1L, first_name, surname, address);

		customer = customerDaoMysql.update(customer);
		assertNotEquals(savedCustomer, customer);
	}
	/**
	 * deleteTest
	 */
	@Test
	public void deleteTest() {

		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql(jdbcConnectionUrl, username, password);
		Long customer_id = 1L;
		String first_name = "Mohamud";
		String surname = "Mussa";
		String address = "address";
		Customer customer = new Customer(first_name, surname, address);
		customer = customerDaoMysql.create(customer);

		customerDaoMysql.delete(customer_id);

	}

}