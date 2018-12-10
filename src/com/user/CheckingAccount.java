package com.user;

import java.util.ArrayList;

public class CheckingAccount extends Account {

	@Override
	public void closeAccount() {
		
	}

	@Override
	public ArrayList<Transaction> viewHistory() {
		return null;
	}

	@Override
	public void transferFunds() {
		
	}

	@Override
	public void requestChecks() {
		System.out.println("Your checks should arrive within 5-8 business days.");
	}

}
