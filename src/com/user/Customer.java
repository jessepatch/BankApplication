package com.user;

public class Customer {

	private String firstName;
	private String lastName;
	private Address address;
	private Account checkingAccount = new CheckingAccount();
	private Account savingsAccount = new SavingsAccount();
	private String email;
	private String password;
	
	public Customer() {
		
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Account getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(Account checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	public Account getSavingsAccount() {
		return savingsAccount;
	}
	public void setSavingsAccount(Account savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + "!" + lastName + "!" + address.toString()
				+ "!" + checkingAccount.toString() + "!" + savingsAccount.toString() + "!" + email
				+ "!" + password;
	}
	
	
}
