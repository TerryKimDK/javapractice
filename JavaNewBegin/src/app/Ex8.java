package app;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex8 {
	Ex2[] member;
	static List<Ex2> List;
	
	public Ex8() {
		member = new Ex2[3];
		member[0] = new Ex2("홍길동1", "a", "1");
		member[1] = new Ex2("홍길동2", "b", "2");
		member[2] = new Ex2("홍길동3", "c", "3");
		List = Arrays.asList(member);
		for(Ex2 m: List) {
			System.out.println(m.getName());
		}
		List = new LinkedList<>(List);
//		Object obj = List.get(0);
//		Ex2 user = (Ex2)obj;
		Iterator<Ex2> iter = List.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
		
		//delete
		//index로지울수 있고 객체로도 지울 수 있다.
		List.remove(member[1]);
		for(Ex2 m: List) {
			System.out.println(m.getName());
		}
	}
	public static void main(String args[]) {
		new Ex8();
	}
}