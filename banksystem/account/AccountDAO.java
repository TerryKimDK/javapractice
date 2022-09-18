package account;

import dBUtil.DBUtil;

import java.sql.*;

public class AccountDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    // 1. 입출금 통장 개설
    public void insert(AccountDTO dto) { // [3] 입력된 클래스의 정보를
        // sql = value(accountNumber,customerNumber,accountPW,balance)
        String sql = "insert into account values (?,?,?,?)";
        try (Connection conn = DBUtil.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            // [4] 사용해서 쿼리문을 dto클래스 내부의 get메서드를 사용해서 private 변수들의 값들을 가져와서
            pstmt.setString(1, dto.getAccountNumber());
            pstmt.setInt(2, dto.getCustomerNumber());
            pstmt.setInt(3, dto.getAccountPW());
            pstmt.setLong(4, dto.getBalance());

            int count = pstmt.executeUpdate(); // [5] PreparedStatement클래스의 executeUpdate메서드를 통해 업데이트를 하게된다. * 참고로 ps는
            // conn으로 sql이 연동되어있음을 확인하자.
            if (count > 0) {
                System.out.println(count + "입력됨");
            } else {
                System.out.println("입력 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    // 2. 통장 정보 보기
    public AccountDTO getAccount(String accountNumber) {
        AccountDTO accountDTO = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "select accountNumber,customerNumber,accountPW,balance from account where accountNumber = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, accountNumber);

            rs = pstmt.executeQuery();
            //결과값 얻어오기 없는데이터를 검색했을때 에러나니까 조건문 사용
            if(rs.next()) {
                accountDTO = new AccountDTO();
                accountDTO.setAccountNumber(rs.getString(1)); // 뒤에 숫자는 컬럼순 (컬럼명 직접 지정해줘도 됨 "")
                accountDTO.setCustomerNumber(rs.getInt(2));
                accountDTO.setAccountPW(rs.getInt(3));
                accountDTO.setBalance(rs.getLong(4));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtil.close(conn, pstmt, rs);
        }
        return accountDTO;
    }
}