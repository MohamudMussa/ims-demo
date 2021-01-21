package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServicesTest {
	
	@Mock
	private Dao<Item> customerDao;
	
	@InjectMocks
	private ItemServices ItemServices;
	
	@Test
	public void ItemServicesCreate() {
		Item item = new Item(1L, "Pokemon", 88.00);
		ItemServices.create(item);
		Mockito.verify(customerDao, Mockito.times(1)).create(item);
	}
	
	@Test
	public void ItemServicesRead() {
		ItemServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void ItemServicesUpdate() {
		Item item = new Item(1L, "Pokemon", 88.00);
		ItemServices.update(item);
		Mockito.verify(customerDao, Mockito.times(1)).update(item);
	}
	
	@Test
	public void ItemServicesDelete() {
		ItemServices.delete(1L);;
		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
	}
}
