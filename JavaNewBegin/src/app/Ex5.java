package app;

import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex5 extends JFrame implements ActionListener {
	JLabel id_la, pw_la;
	JTextField id_tf, pw_tf;
	JButton login, join;
	Ex6 ex6;
	int a;
	// 여기서 표현되는 모든 이름을 컴퍼런트
	// 스프링 프레임워크에서 컨퍼런트는 Bean
	public Ex5() {
		super("GUI");
		a = 10;
		ex6 = new Ex6();
		id_la = new JLabel("ID");
		pw_la = new JLabel("PW");
		id_tf = new JTextField();
		pw_tf = new JTextField();
		login = new JButton("로그인");
		join = new JButton("회원가입");
		Panel p = new Panel();
		Panel p2 = new Panel(new GridLayout(2, 2));
		p.setLayout(new GridLayout(1, 2, 10, 10));
		p.add(login);
		p.add(join);
		p2.add(id_la);
		p2.add(id_tf);
		p2.add(pw_la);
		p2.add(pw_tf);
		this.add(p, "South");
		this.add(p2, "Center");
		this.setSize(300, 300);
		this.setVisible(true);
		setResizable(false);

		// 내부익명 클래스
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		login.addActionListener(this);

	}

	public static void main(String[] args) {
		new Ex5();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("확인: " + id_tf.getText());
		id_tf.setText("");
		ex6.setVisible(true);
		this.setVisible(false);
		ex6.dispose();
//		if(id_tf.getText().equals(members[0].getId())
//				&& pw_tf.getText().equals(members[0].getPw())){
//					
//		}
		
	}
	
}

class A {
	class B {

	}
}
