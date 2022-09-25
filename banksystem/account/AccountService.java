package account;

import java.util.Scanner;

public class AccountService {
    AccountDAO dao = new AccountDAO();
    AccountDTO dto = new AccountDTO();

    Scanner sc = new Scanner(System.in);

    public void accountView() {
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("안녕하세요 DK 은행 입니다.");
            System.out.println("------------------------------");
            System.out.println("저희 은행 회원이십니까?\n비회원이실 경우 이용이 제한됩니다.");
            System.out.println("번호는 입력해 원하는 서비스를 선택해주세요.");
            System.out.println("\n1. 입출금 통장 생성");
            System.out.println("2. 통장 정보 보기");
            System.out.println("3. 뒤로가기");
            System.out.println("");
            System.out.print("번호 : ");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("추가");
                System.out.print("accountId : ");
                String accountNumber = sc.next();

                System.out.print("핸드폰 번호를 입력해주세요(계좌번호) : ");
                int customerNumber = sc.nextInt();

                System.out.print("accountPW 숫자로 입력해주세요: ");
                int accountPW = sc.nextInt();

                System.out.println("얼마를 넣으시겠습니까? : ");
                long balance = sc.nextLong();

                dto.setAccountNumber(accountNumber); // [1] 위에서 스캐너로 입력받은 값을 차례대로 dto클래스의 set메서드를 사용해 private한 변수에 넣고
                dto.setCustomerNumber(customerNumber);
                dto.setAccountPW(accountPW);
                dto.setBalance(balance);

                dao.insert(dto); // [2] set된 private 변수들을 dao의 insert메서드의 파라메터에 넣어준다.
            } else if (num == 2) {
                // 계좌검색
                System.out.print("계좌번호 : ");
                String accountNumber = sc.next();
                dto = dao.getAccount(accountNumber);
                System.out.println(dto);
            } else if (num == 3) {
                break;
            } else {
                System.out.println("오타");
            }

        }
    }

}