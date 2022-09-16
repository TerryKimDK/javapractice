package app;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.*;
public class LoginByMap {

    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        Map<String, String> map = new Hashtable<>();
        Properties properties = getAdminInfo();

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

    public static Properties getAdminInfo() {
        Properties properties = null;
        try {
            properties = new Properties();
            String path = LoginByMap.class.getResource("database.properties").getPath();
            path = URLDecoder.decode(path, "UTF-8");
            properties.load(new FileReader(path));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
    }
