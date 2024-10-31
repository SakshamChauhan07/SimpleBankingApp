package main;


import static main.myUtil.*;
import java.io.*;
import java.util.ArrayList;




import java.io.File; // for input and output in external .txt file


public class fileManager {
	//.txt file for storing and loading of data
	private static final String FILE_NAME = "accountDataFile.txt";
		
	//Method to load data
	public static ArrayList<BankAccount> loadAccountsFromFile(){
		
		ArrayList<BankAccount> accounts = new ArrayList<>();
		File accountFiles = new File(FILE_NAME);
		
		if(accountFiles.exists()) {
			try(BufferedReader bufferedreader = new BufferedReader(new FileReader(accountFiles))){ 
				String line;
				while( ( line = bufferedreader.readLine() )!= null) {
					String[] accountData = line.split(",");
					if (accountData.length == 3) {
						String accountName = accountData[0];
						int accountNumber = Integer.parseInt(accountData[1]);
						float balance = Float.parseFloat(accountData[2]);
						
						BankAccount account= new BankAccount(accountName, accountNumber);
						account.deposit(balance);
						accounts.add(account);
						
					}
				}
				print("The Bank Accounts Loaded Successfully!");
			} catch (IOException e) {
				print("An Error Occured : " + e.getMessage());
			}
		}
		else {
			print("No File Found to be Added");
		}
		
		return accounts;
	}
	
	
	//Method to Save data 
	
	public static void saveAccountsToFile( ArrayList<BankAccount> accounts ){
		try(FileWriter fileWriter = new FileWriter(FILE_NAME)){
			for (BankAccount account: accounts) {
				
				String accInfo = account.getAccountName() + "," + account.getAccountNumber() + "," + account.getBalance()+ "\n";
				
				fileWriter.write(accInfo);
			}
			print("Accounts Saved to The File");
		}
		catch( IOException e) {
			print("Unable to Save Accounts to file Error: " + e.getMessage());
		}
	}
}
