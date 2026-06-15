import java.time.LocalDate;
import java.util.ArrayList;

public class BankService {
	ArrayList<BankDomain> account = new ArrayList<>();
	
	public void createAccount(BankDomain bank) {
		if (bank.getAccountType().equals("Saving") && bank.getBalance() < 1000) {
			System.out.println("Saving Account requires minimum balance of 1000");
			return;
		}
		account.add(bank);		
	}
	
	public void depositAmount(long accountNo, double amount) {
		
		BankDomain bank = null;
		for (BankDomain acc : account) {
			if (acc.getAccountNo() == accountNo) {
				bank = acc;
				break;
			}
		}
		
		if (bank == null){
			System.out.println("Account Not fount");
		}
		
		bank.setBalance(bank.getBalance() + amount);
		
		bank.setLastTransactionDate(LocalDate.now());
		
		System.out.println("Total Balance : "+bank.getBalance());
		
	}
	
	public void withdrawAmount(long accountNo , double amount) {
		BankDomain bank = null;
		for(BankDomain acc : account) {
			if (acc.getAccountNo() == accountNo) {
				bank = acc;
				break;
			}
		}
		if (bank.getAccountType().equals("Saving")) {
			if (bank.getBalance() - amount < 1000) {
				System.out.println("Minimum balance of 1000 must be maintaied");
				return;
			}
		}
		
		if (bank.getAccountType().equals("Current")) {
			if(bank.getBalance() - amount < 0) {
				System.out.println("Insufficient balance");
				return;
			}
		}
		
		if (bank == null){
			System.out.println("Account Not fount");
		}
		
		bank.setBalance(bank.getBalance() - amount);
		bank.setLastTransactionDate(LocalDate.now());
		
		System.out.println("Total Balance: "+bank.getBalance());
		
	}
	
	public void viewAllAccount(long accountNumber) {
		if(account.isEmpty()) {
			System.out.println("No account available");
		}
		
		for (BankDomain b : account) {
			if(b.getAccountNo() == accountNumber) {
				b.displayAccount();
			}
		}
	}
	
	public void transferAmount(long fromAccountNumber, long toAccountNumber, double amount) {
		
		BankDomain fromAccount = null;		
		
		for(BankDomain acc : account) {
			if (acc.getAccountNo() == fromAccountNumber) {
				fromAccount = acc;
				break;
			}
		}
		
		BankDomain toAccount = null;
		
		for (BankDomain acc : account) {
			if (acc.getAccountNo() == toAccountNumber) {
				toAccount = acc;
				break;
			}
		}
		
		if (fromAccount.getAccountType().equals("Saving")) {
			if (fromAccount.getBalance() - amount < 1000) {
				System.out.println("Transfer Failed. Saving account must maintain minimum balance of 1000");
				return;
			}
		}
		
		if (fromAccount.getAccountType().equals("Current")) {
			if (fromAccount.getBalance() - amount < 0) {
				System.out.println("Insufficient Balance");
				return;
			}
		}
		
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);
		
		fromAccount.setLastTransactionDate(LocalDate.now());
		toAccount.setLastTransactionDate(LocalDate.now());
		
		System.out.println("Transfer Successful");
		System.out.println("Sender Remaining Balance: "+fromAccount.getBalance());
		System.out.println("Reciver Balance: "+toAccount.getBalance());
		
		
		
	}
	
	public void generateStatement(long accountNo) {
		BankDomain b = null;
		
		for (BankDomain acc : account) {
			if (acc.getAccountNo() == accountNo) {
				b = acc;
				break;
			}
		}
		
		double interest = 0;

		if (b.getAccountType().equals("Saving")) {
			interest = b.getBalance() * 6 / 100;
		}
		else {
			interest = b.getBalance() * 2 / 100;
		}
		
		
		for(BankDomain acc : account) {
			if (acc.getAccountNo() == accountNo) {
				System.out.println("===================================");
				System.out.println("||       Monthly Statement       ||");
				System.out.println("===================================");
				acc.displayAccount();
				System.out.println("Interest Earned         : "+interest);
			}
		}
	}
	
	public void calculateInterest(long accountNumber) {
		BankDomain bank = null;
		
		for(BankDomain b : account) {
			if(b.getAccountNo() == accountNumber) {
				bank = b;
				break;
			}
		}
		
		double interest = 0;
		double balance = bank.getBalance();
		
		if (bank.getAccountType().equals("Saving")) {
			interest = balance * 6 / 100;
			
		}
		else if(bank.getAccountType().equals("Current")) {
			interest = balance * 2 / 100;
		}
		
		bank.setBalance(balance + interest);
		System.out.println("Interest: "+interest);
		System.out.println("Total Balance: "+bank.getBalance());
		
		
	}
	
	public void viewAllAccounts() {
		if (account.isEmpty()) {
			System.out.println("No account Available");
		}
		for (BankDomain b : account) {
			b.displayAccount();
		}
	}
	
}