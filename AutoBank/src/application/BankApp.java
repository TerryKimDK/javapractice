package application;

import java.util.Scanner;

public class BankApp implements Bank {

	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	@Override
	public boolean createAccount() {
		System.out.println("--------");
		System.out.println("계좌생성");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String ano = sc.next();

		System.out.print("계좌주: ");
		String owner = sc.next();

		System.out.print("초기입금액: ");
		int money = sc.nextInt();

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = new Account(ano, owner, money);
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
		return false;
	}

	@Override
	public boolean accountList() {
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("--------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			System.out.println(
				"게좌번호: " + accountArray[i].getAno() + "\n" + "소유주: " + accountArray[i].getOwner() + "\n" + "잔고: " + accountArray[i].getBalance());
		}
		return false;
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

	public static void main(String[] args) {

		BankApp app = new BankApp();
//		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int balance = 0;
		do {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.잔고 | 6.종료");
			System.out.println("------------------------------------------------------------");
			System.out.println("선택>");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1:
				app.createAccount();
				break;
			case 2:
				app.accountList();
				break;
			case 3:
				app.deposit();
				break;
			case 4:
				app.withDraw();
				break;
			case 5:
				System.out.println("잔고>");
				System.out.println(balance);
				break;
			case 6:
				run = false;
				break;
			default:
				System.out.println("Wrong Answer");
			}
			System.out.println();
		} while (run);
		System.out.println("종료 되었습니다.");
	}

}