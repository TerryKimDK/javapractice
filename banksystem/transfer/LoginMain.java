package transfer;

import dBUtil.DBUtil;
import main.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginMain {
    Scanner sc = new Scanner(System.in);
    Main main = new Main();

    public void loginView() {
        ResultSet rs = null;
        System.out.println("안녕하세요 DK 은행 입니다.");
        System.out.println("로그인");
        System.out.println("Id를 입력해주세요");
        String accountNumber = sc.next();
        System.out.print("accountPW 숫자로 입력해주세요: ");
        int accountPW = sc.nextInt();
       String sql = "SELECT accountpw FROM account WHERE accountId = (?)";
       try {
           Connection conn = DBUtil.getInstance().getConnection();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,  accountNumber);
           rs = pstmt.executeQuery();
           if(rs.next()){
               if(rs.getInt(1)==(accountPW)){
                   System.out.println("로그인에 성공");
                   System.out.println("계좌이체를 하시겠습니까?");
                   System.out.println("\n1. 예");
                   System.out.println("2. 아니오");
                   int num = sc.nextInt();
                   if (num == 1){
                        System.out.println("계좌이체를 진행하겠습니다.");
                   }else {
                       main.reMain();
                   }

               }
               else {
                   System.out.println("비밀번호가 틀렸습니다.");
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}


