package app;

import java.awt.Toolkit;

public class Ex13 extends Thread {

	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		System.out.println("호출됌");
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
}
