import java.time.LocalDate;
import java.util.Scanner;

public class Bank {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BankService bankService = new BankService();
		
		while(true){
			System.out.println("=========================================");
			System.out.println("||  WELCOME TO BANK MANAGEMENT SYSTEM  ||");
			System.out.println("=========================================");
			
			System.out.println("1. CREATE ACCOUNT");
			System.out.println("2. DEPOSITE AMOUNT");
			System.out.println("3. WITHDRAW AMOUNT");
			System.out.println("4. TRANSFER MONEY");
			System.out.println("5. VIEW ALL ACCOUNT DETAILS");
			System.out.println("6. GENERATE MONTHLY STATEMENT");
			System.out.println("7. CALCULATE INTEREST");
			System.out.println("8. VIEW All ACCOUNTS");
			System.out.println("9. EXIT");
			
			System.out.println("ENTER YOUR CHOICE");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("CREATE ACCOUNT");
				System.out.println("1. SAVING ACCOUNT");
				System.out.println("2. CURRENT ACCOUNT");
				
				int accountChoice = sc.nextInt();
				
				String accountType = "";
				
				if (accountChoice == 1) {
					accountType = "Saving";
					System.out.println("CREATING SAVING ACCOUNT");
				}
				else {
					accountType = "Current";
					System.out.println("CREATING CURRENT ACCOUNT");
				}
				
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo = sc.nextLong();
				sc.nextLine();
				
				System.out.println("ENTER YOUR NAME");
				String customerName = sc.nextLine();
				
				System.out.println("ENTER YOUR PANCARD NUMBER");
				String panNumber = sc.nextLine();
				
				System.out.println("ENTER BALANCE");
				double balance = sc.nextDouble();				
				
				BankDomain bankDomain = new BankDomain(accountNo, customerName, panNumber, accountType, balance, "Normal", LocalDate.now());
				
				bankService.createAccount(bankDomain);
				System.out.println("ACCOUNT CREATED SUCCESSFULLY...");
				break;
				
			case 2:
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo1 = sc.nextLong();
				
				System.out.println("ENTER AMOUNT TO DEPOSIT");
				double amountToDeposit = sc.nextDouble();
				
				bankService.depositAmount(accountNo1, amountToDeposit);
				break;
				
			case 3:
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo2 = sc.nextLong();
				
				System.out.println("ENTER AMOUNT TO WITHDRAW");
				double amountToWithdraw = sc.nextDouble();
				
				bankService.withdrawAmount(accountNo2, amountToWithdraw);
				break;
				
			case 4:
				System.out.println("ENTER SENDER ACCOUNT NUMBER");
				long fromAccount = sc.nextLong();
				
				System.out.println("ENTER RECEIVER ACCOUNT NUMBER");
				long toAccount = sc.nextLong();
				
				System.out.println("ENTER AMOUNT TO TRANSFER");
				double amountToTransfer = sc.nextDouble();
				
				bankService.transferAmount(fromAccount, toAccount, amountToTransfer);
				break;
				
			case 5:
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo3 = sc.nextLong();
				
				bankService.viewAllAccount(accountNo3);
				break;
				
			case 6:
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo4 = sc.nextLong();
				
				bankService.generateStatement(accountNo4);
				break;
				
			case 7:
				System.out.println("ENTER ACCOUNT NUMBER");
				long accountNo5 = sc.nextLong();
				
				bankService.calculateInterest(accountNo5);
				break;
				
			case 8:
				bankService.viewAllAccounts();
				break;
				
			case 9:
				System.exit(0);
				break;
				
			default:
				System.out.println("INVALID CHOICE. PLEASE TRY AGAIN!!!!...");
					
			}
		}
	}
}
