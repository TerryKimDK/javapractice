package app;

public class BalanceInsufficientException  extends Exception{
	public BalanceInsufficientException() {
		System.out.println("gd");
	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
