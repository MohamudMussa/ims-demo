package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	BigDecimal price = new BigDecimal("88.00");
	
	private Item Item;
	private Item other;
	
	@Before	
	public void setUp() {
		
		Item = new Item(1L, "Pokemon", price);
		other = new Item(1L, "Pokemon", price);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(Item.getItem_id());
		assertNotNull(Item.getItem_name());
		assertNotNull(Item.getItem_price());
		
		Item.setItem_id(null);
		assertNull(Item.getItem_id());
		Item.setItem_name(null);
		assertNull(Item.getItem_name());
		Item.setItem_price(null);
		assertNull(Item.getItem_price());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(Item.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(Item.equals(new Object()));
	}
	
	@Test
	public void createItemWithId() {
		assertEquals(1L, Item.getItem_id(), 0);
		assertEquals("Pokemon", Item.getItem_name());
		assertEquals(price, Item.getItem_price());
	}
	
	@Test
	public void checkEquality() {
		assertTrue(Item.equals(Item));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void ItemNameNullButOtherNameNotNull() {
		Item.setItem_name(null);
		assertFalse(Item.equals(other));
	}
	
	@Test
	public void ItemNamesNotEqual() {
		other.setItem_name("rhys");
		assertFalse(Item.equals(other));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		Item.setItem_name(null);
		other.setItem_name(null);
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void nullId() {
		Item.setItem_id(null);
		assertFalse(Item.equals(other));
	}
	
	@Test
	public void nullIdOnBoth() {
		Item.setItem_id(null);
		other.setItem_id(null);
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void otherIdDifferent() {
		other.setItem_id(2L);
		assertFalse(Item.equals(other));
	}
	
	@Test
	public void nullItemPrice() {
		Item.setItem_price(null);
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void nullSurnameOnBoth() {
		Item.setItem_price(null);
		other.setItem_price(null);
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void otherSurnameDifferent() {
		other.setItem_price(price);
		assertTrue(Item.equals(other));
	}
	
	@Test
	public void constructorWithoutId() {
		Item Item = new Item("Chris", price);
		assertNull(Item.getItem_id());
		assertNotNull(Item.getItem_name());
		assertNotNull(Item.getItem_price());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(Item.hashCode(), other.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
		Item Item = new Item(null, null, null);
		Item other = new Item(null, null, null);
		assertEquals(Item.hashCode(), other.hashCode());
	}
	
	@Test
	public void toStringTest() {
		String toString = "Item [item_id=1 item_name=Pokemon item_price="+price+ "]";
		assertEquals(toString, Item.toString());
	}
}
