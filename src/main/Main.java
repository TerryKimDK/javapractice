package main;

import account.AccountService;
import customer.CustomerService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("안녕하세요 DK 은행 입니다.");
            System.out.println("번호는 입력해 원하는 서비스를 선택해주세요.");
            System.out.println("\n1. 고객관리");
            System.out.println("2. 통장개설");
            System.out.println("3. 프로그램 종료");
            System.out.print("번호 : ");
            int num = sc.nextInt();
            if(num == 1) {
                customerService.customerView();
            } else if (num == 2) {
                accountService.accountView();
            } else if (num == 3) {
                sc.close();
                System.exit(0);
            } else {
                System.out.println("오타");
            }
        }
    }
    public void reMain(){
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        Scanner sc = new Scanner(System.in);

        System.out.println("안녕하세요 DK 은행 입니다.");
        System.out.println("번호는 입력해 원하는 서비스를 선택해주세요.");
        System.out.println("\n1. 고객관리");
        System.out.println("2. 통장개설");
        System.out.println("3. 프로그램 종료");
        System.out.println("");
        System.out.print("번호 : ");
        int num = sc.nextInt();
        if(num == 1) {
            customerService.customerView();
        } else if (num == 2) {
            accountService.accountView();
        } else if (num == 3) {
            sc.close();
            System.exit(0);
        } else {
            System.out.println("오타");
        }
    }

}