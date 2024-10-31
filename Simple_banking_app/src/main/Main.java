package main;

import static main.myUtil.*;// For using my own util methods
//import static main.fileManager.*; // To get all fileManager functionalities

import java.util.ArrayList;// For making arrayList
import java.util.Scanner; // For taking inputs

public class Main{
	
	
	 //making an array in which the data would be stored
	private static ArrayList<BankAccount> customers = new ArrayList<>();
	
	//Scanner method
	private static Scanner input = new Scanner(System.in);
	
	
	
	//Start
	public static void main(String[] args) {
		
		
		 // To load all data from the file
		customers = fileManager.loadAccountsFromFile();
		
		boolean exit = false;
		
		while(!exit) {
			
		//Integer for menu items
		int choice;
		
		//Display Menu items
		print("+++++++++++++++++++++++++++++");
		print("Bank Application Menu");
		print("1: Create A New Account");
		print("2. Display Existing Accounts");
		print("3: Deposit to An Account");
		print("4: Withdraw from An Account");
		print("5: Search Account");
		print("6: Exit");
		print("+++++++++++++++++++++++++++++");
		print();
		ask("Choose an option: ");
		choice = input.nextInt();
		input.nextLine();
		print();
		
		if(choice == 6) {
			fileManager.saveAccountsToFile(customers);
			exit = true;
		}
		else if(choice == 1) {
			
			//Variable for name and taking an input
			String name;
			ask("Enter the Name: ");
			name = input.nextLine();
			
			//Variable for Account number
			int number;
			ask("Enter the Account Number: ");
			number = input.nextInt();
			print();
			
			BankAccount newCustomer = new BankAccount(name, number);
			
			customers.add(newCustomer);
			print("New Account added Successfully!");
			print();
			newCustomer.Display();
			
		}
		else if(choice == 2) {
			for(BankAccount account:customers) {
				account.Display();
			}
		}
		
		else if(choice == 3) {
			ask("Enter the Account Number: ");
			int tempAccNumb = input.nextInt();
			input.nextLine();
			
			BankAccount searchedAcc = findAcc(tempAccNumb);
			
			if(searchedAcc == null) {
				print("No Account Found\n");
			}
			else {
			searchedAcc.Display();
			print();
			ask("Enter the Amount you want to deposit: ");
			float depAmt = input.nextInt();
			
			searchedAcc.deposit(depAmt);
			System.out.println("New Balance: " + searchedAcc.getBalance());
			
			}
		}
		
		else if(choice == 4) {
			ask("Enter the Account Number: ");
			int tempAccNumb = input.nextInt();
			input.nextLine();
			
			BankAccount searchedAcc = findAcc(tempAccNumb);
			
			if(searchedAcc == null) {
				print("No Account Found\n");
			}
			else {
			searchedAcc.Display();
			print();
			ask("Enter the Amount you want to deposit: ");
			float depAmt = input.nextInt();
			
			searchedAcc.withdraw(depAmt);
			System.out.println("New Balance: " + searchedAcc.getBalance());
			
			}
		}
		
		else if(choice == 5) {
			ask("Enter the Account Number: ");
			int tempAccNumb = input.nextInt();
			input.nextLine();
			
			BankAccount searchedAcc = findAcc(tempAccNumb);
			if(searchedAcc == null) {
				print("No Account Found\n");
			}
			else {
			searchedAcc.Display();
			}
			
		}
		
		else {
			print("Wrong input...\n");

		}
		
		
		

		}
		input.close();
		print("Thank you for banking with us :)");
		
		
	}
	
	//method to find account
		public static BankAccount findAcc(int tempAccNumb) {
			// make for loop to find the data
			for(BankAccount account:customers) {
				if(account.getAccountNumber() == tempAccNumb) {
					print("\nSearched Account");
					//account.Display();
					return account;
				}	
			}
			
			return null;
		}
}

