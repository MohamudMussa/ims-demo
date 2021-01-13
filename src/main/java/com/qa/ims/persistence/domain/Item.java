package com.qa.ims.persistence.domain;

import java.math.BigDecimal;

public class Item {

	private Long item_id;
	private String item_name;
	private BigDecimal item_price;

	public Item(String item_name, BigDecimal item_price) {
		this.item_name = item_name;
		this.item_price = item_price;

	}

	public Item(Long id, String item_name, BigDecimal item_price) {
		this.item_id = id;
		this.item_name = item_name;
		this.item_price = item_price;
		;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public BigDecimal getItem_price() {
		return item_price;
	}

	public void setItem_price(BigDecimal item_price) {
		this.item_price = item_price;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + " item_name=" + item_name + " item_price=" + item_price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;

		return true;
	}

}
