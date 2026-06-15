import java.time.LocalDate;

public class BankDomain {
	private long accountNo;
	private String customerName;
	private String panNumber;
	private String accountType;
	private double balance;
	private String status;
	private LocalDate lastTransactionDate;
	
	BankDomain(long accountNo, String customerName, String panNumber, String accountType, double balance, String status, LocalDate lastTransactionDate){
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.panNumber = panNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.lastTransactionDate = lastTransactionDate;
	}
	
	
	public long getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPanNumber() {
		return panNumber;
	}
	
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getLastTransactionDate() {
		return lastTransactionDate;
	}
	
	public void setLastTransactionDate(LocalDate lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public void displayAccount() {
		System.out.println("Account Number: "+getAccountNo());
		System.out.println("Customer Name: "+getCustomerName());
		System.out.println("Pan number: "+getPanNumber());
		System.out.println("Account Type: "+getAccountType());
		System.out.println("Balance: "+getBalance());
		System.out.println("Status: "+getStatus());
		System.out.println("Last Transaction Date: "+getLastTransactionDate());
	}
	
}