package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public final String fileName = "C:\\Training\\Save Data\\BankData.txt";


	public Bank() {
		
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	public void saveToFile() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(toString());
			bw.close();
		} catch (IOException e) {
			System.out.println("Unsuccessful");
		}
	}
	
	public void readFromFile() {
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				//users are separated by &
				String[] userSplit = line.split("&");
				
				for(int y = 0; y < userSplit.length; y++) {
				
				String parseUser = userSplit[y];
				
				//user data is separated by !
				String[] parseLine = parseUser.split("!");
				
				Customer customer = new Customer();
				customer.setFirstName(parseLine[0]);
				customer.setLastName(parseLine[1]);
				
				Address address = new Address();
				address.setStreet(parseLine[2]);
				address.setCity(parseLine[3]);
				address.setState(parseLine[4]);
				address.setZipcode(parseLine[5]);
				
				CheckingAccount checkingAccount = new CheckingAccount();
				checkingAccount.setBalance(Double.parseDouble(parseLine[6]));
				checkingAccount.setTransactionHistory(parseLine[7]);
				
				SavingsAccount savingsAccount = new SavingsAccount();
				savingsAccount.setBalance(Double.parseDouble(parseLine[8]));
				savingsAccount.setTransactionHistory(parseLine[9]);
				
				customer.setCheckingAccount(checkingAccount);
				customer.setSavingsAccount(savingsAccount);
				customer.setAddress(address);
				customer.setEmail(parseLine[10]);
				customer.setPassword(parseLine[11]);
				
				customers.add(customer);
				}
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("FAILURE ! ! ! !");
		}
		
	}
	
	public String toString() {
		String saveString = "";
		for(int p = 0; p < customers.size(); p++) {
			if(p == customers.size() - 1) {
			saveString = saveString + customers.get(p);
		} else {
			saveString = saveString + customers.get(p) + "&";
		}
		}
		return saveString;
	}
	
}
