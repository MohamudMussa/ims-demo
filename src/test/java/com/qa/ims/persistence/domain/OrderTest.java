package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	private Order other;

	@Before
	public void setUp() {

		
		order = new Order(1L, 2L, 8, 12.0);
		other = new Order(1L, 2L, 8, 12.0);
		

	}

	@Test
	public void settersTest() {
		assertNotNull(order.getOrder_id());
		assertNotNull(order.getItem_id());
		assertNotNull(order.getQuantity());
		assertNotNull(order.getOrderline_price());


		

		order.setOrder_id(null);
		assertNull(order.getOrder_id());
		order.setOrderline_id(null);
		assertNull(order.getOrder_id());
		order.setItem(null);
		assertNull(order.getItem());
		order.setQuantity(null);
		assertNull(order.getQuantity());
		order.setItem_id(null);
		assertNull(order.getItem_id());
		order.setAddress(null);
		assertNull(order.getAddress());



	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void createOrderWithId() {
		assertEquals(1L, order.getOrder_id(), 0);
		assertEquals(8.0, order.getQuantity(), 0);
		assertEquals(8.0, order.getOrderline_price(), 12.0);
	}

	@Test
	public void checkEquality() {
		assertTrue(order.equals(order));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(order.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		order.setOrderline_price(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void orderline_PriceNamesNotEqual() {
		other.setOrderline_price(12.0);
		assertTrue(order.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullOrderID() {
		order.setOrder_id(null);
		other.setOrder_id(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void nullId() {
		order.setOrder_id(null);
		assertFalse(order.equals(other));
	}
	
	@Test
	public void nullorderlineId() {
		order.setOrderline_id(null);
		assertFalse(order.equals(other));
	}


	@Test
	public void nullIdOnBoth() {
		order.setOrder_id(null);
		other.setOrder_id(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setOrder_id(2L);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullQuantity() {
		order.setOrderline_price(null);
		assertFalse(order.equals(other));
	}

	@Test
	public void nullQuantityOnBoth() {
		order.setOrderline_price(null);
		other.setOrderline_price(null);
		assertTrue(order.equals(other));
	}

	@Test
	public void otherOrderline_priceDifferent() {
		other.setOrderline_price(12.0);
		assertTrue(order.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Order order = new Order(8, 12.0);
		assertNull(order.getOrder_id());
		assertNotNull(order.getOrderline_price());
		assertNotNull(order.getQuantity());
	}

	@Test
	public void hashCodeTest() {
		assertEquals(order.hashCode(), other.hashCode());
	}

	@Test
	public void hashCodeTestWithNull() {
		Order order = new Order(null, null, null, null);
		Order other = new Order(null, null, null, null);
		assertEquals(order.hashCode(), other.hashCode());
	}
	
	

	@Test
	public void toStringTest() {
		String toString = "Order [orderline_id=null, order_id=1, customer_id=null, item_id=2, quantity=8, orderline_price=12.0, first_name=null, surname=null, address=null, item_id=2]";
		assertEquals(toString, order.toString());
	}
}
