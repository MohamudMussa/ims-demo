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
import com.qa.ims.persistence.domain.Order;

public class OrderDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	private static String jdbcConnectionUrl = "jdbc:mysql://localhost:3306/ims_test";
	private static String username = "root";
	private static String password = "root";

	@BeforeClass
	public static void init() {
		Ims ims = new Ims();
		ims.init(jdbcConnectionUrl, username, password, "src/test/resources/sql-schema.sql");
	}

	@Before
	public void setup() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orderline");
			statement.executeUpdate("delete from orders");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	
	/**
	 * createTest
	 */
	@Test
	public void createTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long customer_id = 1l;
		Long orderline_id = 1l;
		
		Order order = new Order(customer_id,orderline_id);
		Order savedOrder = new Order(customer_id,orderline_id);
		
		order = orderDaoMysql.create(order);
		assertEquals(savedOrder, order);
	}

	
	/**
	 * updateTest
	 */
	@Test
	public void updateTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(username, password);
		Long customer_id = 1L;
		Long newcustomer_id = 2L;
		Order order = new Order(customer_id, newcustomer_id);
		Order savedOrder = new Order(customer_id, newcustomer_id);

		order = orderDaoMysql.update(order);
		assertNotEquals(savedOrder, order);
	}
	
	
	/**
	 * readTest
	 */
	@Test
	public void readTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		List<Order> orders = List.of(new Order(1L, 2L, 3L, 10, 4L, 10.0, "Mohamud", "Mussa", "pokemon"),

				new Order(1L, 2L, 3L, 10, 4L, 10.0, "Mohamud", "Mussa", "pokemon"),
				new Order(1L, 2L, 3L, 10, 4L, 10.0, "Mohamud", "Mussa", "pokemon"));
		for (Order order : orders) {
			orderDaoMysql.create(order);
		}
		assertEquals(orders, orderDaoMysql.readAll());
	}
	
	
	/**
	 * readLatestTest
	 */
	@Test
	public void readLatestTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long customer_id = 2L;
		Order order_test = new Order(order_id, customer_id);
		Order order_test2 = new Order(order_id, customer_id);
		Order OrderMade = new Order(customer_id);

		orderDaoMysql.create(order_test);
		orderDaoMysql.create(order_test2);
		assertEquals(OrderMade, orderDaoMysql.readLatest());
	}

	/**
	 * deleteTest
	 */
	@Test
	public void deleteTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id);

	}
	
	
	/**
	 * non functioning addtoOrderlineTest
	 */
	@Test
	public void addtoOrderlineTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.addtoOrderline(ordertwo);

	}
	
	/**
	 * non functioning addToOrderTest - will continue to build this project
	 */
	@Test
	public void addToOrderTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.addToOrder(order);

	}
	
	/**
	 * non functioning calculateOrderTest - will continue to build this project
	 */
	@Test
	public void calculateOrderTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.calculateOrder(order_id);

	}
	
	/**
	 * non functioning deleteOrderlineTest - will continue to build this project
	 */
	@Test
	public void deleteOrderlineTest() {
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning deleteOrderTest - will continue to build this project
	 */
	@Test
	public void deleteOrderTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning updateOrderlineTest - will continue to build this project
	 */
	@Test
	public void updateOrderlineTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	
	/**
	 * non functioning readLatesOrderlineTest - will continue to build this project
	 */
	@Test
	public void readLatesOrderlineTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning addingANewOrderlineTest - will continue to build this project
	 */
	@Test
	public void addingANewOrderlineTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning OrderFromCreateTest - will continue to build this project
	 */
	@Test
	public void OrderFromCreateTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning OrderFromResultSetTest - will continue to build this project
	 */
	@Test
	public void OrderFromResultSetTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
		orderDaoMysql.delete(order_id_two);

	}
	
	/**
	 * non functioning CalculateFormResultSetUpdateTwoTest - will continue to build this project
	 */
	@Test
	public void CalculateFormResultSetUpdateTwoTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);

	}
	
	/**
	 * non functioning OrderFormResultSetUpdateTwoTest - will continue to build this project
	 */
	@Test
	public void OrderFormResultSetUpdateTwoTest() { 
		OrderDaoMysql orderDaoMysql = new OrderDaoMysql(jdbcConnectionUrl, username, password);
		Long order_id = 1L;
		Long order_id_two = 2L;
		Order order = new Order(order_id);
		Order ordertwo = new Order(order_id_two);
		order = orderDaoMysql.create(order);
		order = orderDaoMysql.create(ordertwo);
	}



}