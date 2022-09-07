package app;

public class Ex12 {
	public static void main(String[] args) {
		//객체지향 3단계 객체를 생성하고 사용하자
		Thread thread = new Ex13();
		thread.start(); //run 메소드를 호출한다고 생각하면됨
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
