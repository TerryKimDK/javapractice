package app;


import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class SignIn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        do{
            System.out.println("------------------------------");
            System.out.println("안녕하세요\tDK 은행입니다.");
            System.out.println("------------------------------");
            System.out.println("저희 은행 회원이십니까?\n비회원이실 경우 이용이 제한됩니다.");
            System.out.println("1. 로그인\t 2. 회원가입\t 3. 고객센터\t 4.회원탈퇴\t 5. 종료");
            int joinNum = sc.nextInt(); //회원가입
            if(joinNum == 1){
                Map<String, String> map = new Hashtable<>();
                getAdminInfo();
                // Map<객체, 객체> -> int(X), Integer(O)
                String adminId = properties.getProperty("username");
                String adminPw = properties.getProperty("password");
                map.put(adminId, adminPw);
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println("아이디와 비밀번호를 입력해주세요");
                    System.out.print("ID : ");
                    String id = sc.next();
                    System.out.print("PW : ");
                    String pw = sc.next();
                    if (map.containsKey(id)) {
                        if (map.get(id).equals(pw)) {
                            System.out.println("로그인 되었습니다.");
                            break;
                        } else {

                            System.out.println("비밀번호를 다시 입력해주세요.");
                        }
                    } else
                        System.out.println("존재하지 않는 아이디입니다.");
                }
            }

            }else if (joinNum == 2) {
                new SignInDB().insert();
            }else if(joinNum == 3){ //고객문의 채팅기능

            }else{
                break;
            }
            System.out.println("------------------------------");
        }while(run);
        System.out.println("좋은 하루 되세요.");
    }
}
