package application;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui extends Frame {
	// 필드
	public Gui() {
		// 생성자
		super("GUI");
		this.setSize(300, 300);
		this.setVisible(false);
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}