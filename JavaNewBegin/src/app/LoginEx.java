package app;

public class LoginEx {
	
	public static void main(String[] args) {
		try {
			login("white", "12345");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			login("blue", "54321");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void login(String id, String pwd)
	throws NotExistIDException,
	WrongPasswordException{
		//id가 blue가 아니라면 notexistEDExcetion 발생
		if(!id.equals("blue")) {
			throw new NotExistIDException("아이디가존재하지않습니다.");
		}
		//password가  12345가 아니라면 wrongpasswordException을 발생
		if(!pwd.equals("12345")) {
			throw new WrongPasswordException("비밀번호가 존재하지 않습니다.");
		}
	}
}
