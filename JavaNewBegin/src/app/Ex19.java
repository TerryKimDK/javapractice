package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex19 {
	List<Ex2> members;

	public Ex19() {
		members = new ArrayList<>(); // ?????? 필드에 선언한거랑 다른가?
		Ex2 member = new Ex2("c", "3", "3"); // 실행할 때마다 append가 됨
//		members.add(member);
		fileInput(member);
		fileOutput();
		members.add(member);
		for (Ex2 m : members) {
			System.out.println(m.getName());
		}
	}

	public void fileInput(Ex2 member) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File("members.text"), true)); // 덮어쓸 수 있으니 , 기본적으로는
																								// false / true를 하면
																								// append를 하겠다라는 뜻
			// true를 지우면 덮어쓰기가 됨
			StringBuilder sb = new StringBuilder();
			sb.append(member.getName());
			sb.append("#");
			sb.append(member.getId());
			sb.append("#");
			sb.append(member.getPw());
			pw.println(sb.toString());
			pw.close();
//		pw.println(member.getName() + "#" + member.getId() + "#" + member.getPw());
//		pw.close(); // close 사용하지 않으면 사용 불가능
			// buffer 는 사용할때마다 기록
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fileOutput() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("members.text")));
			while (br.ready()) {
				StringTokenizer st = new StringTokenizer(br.readLine(), "#"); // 하나의 문자를 여러 문자의 요소로 나누는 객체 / 각각의 문자열을
																				// "#"으로 짤라야한다.
//				while(st.hasMoreTokens()) { // 커서를 읆겨주는 역할 nexttoken, nextelements 다음으로 넘기기 때문에 통상 while을 사용한다
//					String obj = st.nextToken();
				Ex2 member = new Ex2(st.nextToken(), st.nextToken(), st.nextToken());
				members.add(member);
				// elements 사용시 object로 반환 토큰시 string
//				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Ex19();
	}
}
