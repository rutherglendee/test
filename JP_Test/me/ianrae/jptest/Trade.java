package me.ianrae.jptest;

import java.util.Date;

public class Trade {

	private int price;
	private int quantity;
	private boolean isBuy;
	int getPrice() {
		return price;
	}

	int getQuantity() {
		return quantity;
	}

	Date getTimestamp() {
		return timestamp;
	}

	private Date timestamp;

	/**
	 * Constructor; generate the timestamp and store 
	 * 
	 * @param price
	 * @param quantity
	 * @param isBuy
	 */
	public Trade(int price, int quantity, boolean isBuy) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.isBuy = isBuy;
		timestamp = new java.util.Date();
	}
		
}
