package app;

import java.util.Scanner;

public class BankApp implements Bank{
	

	public static void main(String[] args) {
		
			BankApp app = new BankApp();
			Scanner sc = new Scanner(System.in);
			boolean run = true;
			int balance = 0;
			do {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.println("선택>");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			
			case 1:
				app.deposit();
				break;
			case 2:
				app.withDraw();
				break;
			case 3:
				System.out.println("잔고>");
				System.out.println(balance);
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("Wrong Answer");
			}
			System.out.println();
		}while(run);
			System.out.println("종료 되었습니다.");
	}
	
	@Override
	public boolean deposit() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean withDraw() {
		// TODO Auto-generated method stub
		return false;
	}
		
		

}
