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
import com.qa.ims.persistence.domain.Item;

public class ItemDaoMysqlTest {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);

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
			statement.executeUpdate("delete from items;");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Test
	public void createTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		Long item_id = 1l;
		String item_name = "pokemon";
		Double item_price = 15.0;

		Item item = new Item(item_id, item_name, item_price);
		Item savedItem = new Item(1L, item_name, item_price);

		item = itemDaoMysql.create(item);
		assertEquals(savedItem, item);
	}

	@Test
	public void readTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		List<Item> items = List.of(new Item(1L, "pokemon", 15.0), 
				new Item(1L, "pokemon", 15.0),
				new Item(3L, "pokemon", 15.0));
		for (Item item : items) {
			itemDaoMysql.create(item);
		}
		assertEquals(items, itemDaoMysql.readAll());
	}
	
	@Test
	public void readLatestTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		String item_name = "pokemon";
		Double item_price = 15.0;
		Item cust_test = new Item(item_name, item_price);
		Item cust_test2 = new Item(item_name, item_price);
		Item ItemMade = new Item(1L,item_name ,item_price);

		itemDaoMysql.create(cust_test);
		itemDaoMysql.create(cust_test2);
		assertEquals(ItemMade, itemDaoMysql.readLatest());
	}

	@Test
	public void updateTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(username, password);
		String item_name = "pokemon";
		Double item_price = 15.0;
		Item item = new Item(item_name, item_price);
		Item savedItem = new Item(1L, item_name, item_price);

		item = itemDaoMysql.update(item);
		assertNotEquals(savedItem, item);
	}

	@Test
	public void deleteTest() {
		ItemDaoMysql itemDaoMysql = new ItemDaoMysql(jdbcConnectionUrl, username, password);
		Long item_id = 1L;
		String item_name = "pokemon";
		Double item_price = 15.0;
		Item item = new Item(1L, item_name, item_price);
		item = itemDaoMysql.create(item);

		itemDaoMysql.delete(item_id);

	}
	




}