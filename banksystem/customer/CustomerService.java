package customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {
    CustomerDAO dao = new CustomerDAO();
    CustomerDTO dto = new CustomerDTO();
    Scanner scan = new Scanner(System.in);

    public void customerView() {
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("안녕하세요 DK은행 입니다.");
            System.out.println("번호는 입력해 원하는 서비스를 선택해주세요.");
            System.out.println("\n1. 고객생성");
            System.out.println("2. 고객 전체 검색");
            System.out.println("3. 고객 검색");
            System.out.println("4. 고객 삭제");
            System.out.println("5. 뒤로 가기");
            System.out.println("");
            System.out.print("번호 : ");
            int num = scan.nextInt();
            if (num == 1) {
                System.out.println("고객생성");

                System.out.print("customerName : ");
                String customerName = scan.next();

                System.out.print("customerPhone : ");
                String customerPhone = scan.next();

                System.out.print("customerAddress : ");
                String customerAddress = scan.next();

                System.out.print("customerRRN : ");
                String customerRRN = scan.next();

                System.out.print("customerGender : ");
                String customerGender = scan.next();

                // dto.setCustomerNumber(customerNumber);
                dto.setCustomerName(customerName);
                dto.setCustomerPhone(customerPhone);
                dto.setCustomerAddress(customerAddress);
                dto.setCustomerRRN(customerRRN);
                dto.setCustomerGender(customerGender);
                System.out.print(dto);
                dao.insert(dto);

            } else if (num == 2) {
                List<CustomerDTO> dtoList = dao.getCustomerList();
                for (CustomerDTO i : dtoList) {
                    System.out.println(i);
                }
            } else if (num == 3) {
                System.out.print("고객 번호 : ");
                int customerNumber = scan.nextInt();
                dto = dao.getcustomer(customerNumber);
                System.out.println(dto);
            } else if (num == 4) {
                System.out.print("고객 번호(삭제): ");
                int customerNumber = scan.nextInt();
                dto.setCustomerNumber(customerNumber);
                dao.deleteCustomer(dto);
            } else if (num == 5) {
                break;
            } else {
                System.out.println("오타");
            }

        }
    }
}