package com.user;

public class Transaction {

	private String date;
	private double amount;
	
	public Transaction() {
		
	}
	
	public Transaction(String now, double amount) {
		this.date = now;
		this.amount = amount;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {

		String positive = "";
		if(amount > 0) {
		positive = "+";
	}
		return date + "," + positive + "$" + amount;
	}
}
