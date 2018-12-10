package com.user;

import java.util.ArrayList;

public class SavingsAccount extends Account{

	@Override
	public void makeDeposit(double amount) {
		
	}

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
		System.out.println("Sorry, you cannot order checks for a savings account.");
	}

}
