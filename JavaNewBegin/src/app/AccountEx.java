package app;

public class AccountEx {
	

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		//예금하기
		account.deposit(2000);
		System.out.println("예금액 : " + account.getBalance());
		//출금하기
		try {
			account.withdraw(5000);
		}catch(BalanceInsufficientException e) { 
			
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
