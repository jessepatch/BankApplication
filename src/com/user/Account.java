package com.user;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Account {

	private double balance;
	private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();
	
	public Account() {
		
	}
	
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		DecimalFormat df = new DecimalFormat("###.##");	
		df.format(balance);
		this.balance = balance;
	}
	
	public ArrayList<Transaction> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
	public void setTransactionHistory(String string) {
		
		if(string.equals(null)) {
		string = string.substring(1,string.length()-1);
		
		
		}
		String[] parseLine = string.split(",");

		for(int i = 0; i < parseLine.length-1; i=i+2) {
			Transaction temp = new Transaction();
			temp.setDate(parseLine[i]);
			if(parseLine[i+1].substring(0,1).equals("+")) {
			temp.setAmount(Double.parseDouble(parseLine[i+1].substring(2)));
			} else {
				temp.setAmount(Double.parseDouble(parseLine[i+1].substring(2))*(-1));
			}
			transactionHistory.add(temp);
		}

	}
	
	public void makeWithdrawal(double amount) throws InsufficientFundsException {
		try {
		if(amount > balance) {
			throw new InsufficientFundsException();
		}
		} catch(InsufficientFundsException r) {
			System.out.println(r);
		}
		amount = amount - 2*amount;
		balance = balance + amount;
		
		this.setBalance(balance);
		
		   LocalDateTime now = LocalDateTime.now();
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ssa");
		   String nowString = dtf.format(now);
		
		Transaction transaction = new Transaction(nowString, amount);
		System.out.println(transaction);
		transactionHistory.add(transaction);
		
	}
	
	public void makeDeposit(double amount) {
		balance = balance + amount;
		
		this.setBalance(balance);
		
		 LocalDateTime now = LocalDateTime.now();
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ssa");
		 String nowString = dtf.format(now);
			
			Transaction transaction = new Transaction(nowString, amount);
			transactionHistory.add(transaction);
			
	}
	
	public ArrayList<Transaction> viewHistory() {
		
		return transactionHistory;
	}
	
	public ArrayList<Transaction> viewHistory(int n) {
		
		ArrayList<Transaction> recentTransactions = new ArrayList<Transaction>();
		
		for(int q = transactionHistory.size(); q > transactionHistory.size() - n; q--) {
			recentTransactions.add(transactionHistory.get(q - 1));
		}
		
		return recentTransactions;
	}
	
	public ArrayList<Transaction> viewHistory(String month) {
		
		ArrayList<Transaction> monthTransactions = new ArrayList<Transaction>();

		for(int z = 0; z < transactionHistory.size(); z++) {
			if(transactionHistory.get(z).getDate().contains(month)) {
				monthTransactions.add(transactionHistory.get(z));
			}
		}
		return monthTransactions;
	}
	
	public abstract void closeAccount();

	public abstract void transferFunds();
	
	public abstract void requestChecks();

	@Override
	public String toString() {
		String transactions = "";
		if(transactionHistory != null) {
		for (int j = 0; j < transactionHistory.size(); j++) {
		    transactions = transactions + transactionHistory.get(j).toString() + ",";
		}
		
		
	}	
		return balance + "!" + transactions;
}
	
}
