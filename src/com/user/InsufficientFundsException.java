package com.user;

public class InsufficientFundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFundsException() {
		
	}
	
	@Override
	public String toString() {
		return "Insufficient Funds for this Withdrawal";
		
	}
	
}
