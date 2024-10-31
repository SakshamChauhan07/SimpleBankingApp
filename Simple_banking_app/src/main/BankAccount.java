package main;
import static main.myUtil.*; // For using my own util methods

public class BankAccount {
	
	String accHolderName;
	int accNumber;
	float accBalance;
	
	
	//Constructor
	public BankAccount(String name, int number) {
		
		
		accHolderName = name;
		accNumber = number ;
		accBalance = 0;
	}
	
	
	// 3 Functions 
	// Deposit, withdraw and get balance
	
	// Deposit Function
	public void deposit(float amount) {
		
		if (amount > 0) {
			
			accBalance += amount;
			print("\nAmount Deposited: $" + amount);
			
		}
		
		else {
			
			print("Could not Deposit: wrong amount");
			print();
			
		}
		
	}
	
	// withdraw function
	public void withdraw(float amount) {
		
		if (amount > 0) {
			
			accBalance -= amount;
			print("Amount Withdrawn: $" + amount);
			print();
			
		}
		else {
			print("Please Enter Positive Amount");
			print();
		}
	}
	
	//get account number
	public String getAccountName() {
		return accHolderName;
	}
	
	public int getAccountNumber() {
		return accNumber;
	}
	// getBalance function
	public float getBalance() {
		return accBalance;
	}
	
	// Add one more function for easy display of data
	public void Display() {
		print("----------------------");
		print("Name: " + accHolderName + "\nAccount Number: " + accNumber + "\nBalance: "+ accBalance);
		print("----------------------");
		print();
	}
}



