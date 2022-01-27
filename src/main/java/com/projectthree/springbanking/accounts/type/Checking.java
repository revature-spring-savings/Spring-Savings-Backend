package com.projectthree.springbanking.accounts.type;

import com.projectthree.springbanking.accounts.Account;

public class Checking extends Account {
	private static String accountType = "Checking";
	public Checking(double initialDeposit) {
		this.setBalance(initialDeposit);
		this.checkInterest(0);
	}
	public Checking(int accountID, double balance) {
		this.setBalance(balance);
	}
	@Override
	public String toString() {
		return "Account Type: " + accountType + " Account\n" + " Account Number: " + this.getAccountNumber() + "\n"
				+ " Balance: " + this.getBalance() + "\n" + " Interest rate: " + this.getInterest() + "$\n";

	}

	
	

}
