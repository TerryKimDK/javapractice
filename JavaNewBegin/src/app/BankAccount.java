package app;

public class BankAccount {
	private long balance;
	
	public BankAccount() {
		
	}
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsufficientException{
	      if(balance < money) { // 실행이 되면 마지막줄 실행  x
	         throw new BalanceInsufficientException
	            ("잔고부족: "+(money-balance) + "모자람");
	      }
	      balance -= money;
	      System.out.println(balance);
	   }

}
