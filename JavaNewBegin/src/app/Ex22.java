package app;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex22 extends JFrame implements Runnable, ActionListener{
	private BufferedReader i;
	private PrintWriter o;
	private JTextArea output;
	private JTextField input;
	private JLabel label;
	private Thread listener;
	private String host; //서버 ip
	private JScrollPane jp;
	private JScrollBar jb;
	TextArea UserList = new TextArea(30, 15);
	

	public Ex22(String server) {
		super("채팅프로그램");
		host = server;
		listener = new Thread(this);
		listener.start();
		output = new JTextArea();
//		getVerticalScrollBar()
//		add (new JScrollPane(output), "Center");
		jp = new JScrollPane(output);
		jb = jp.getVerticalScrollBar();
		add(jp, "Center");
		//add (new JScrollBar(int), "East");
		output.setEditable(false); 
		Panel bottom = new Panel(new BorderLayout());
		Panel list = new Panel(new FlowLayout());
		label = new JLabel("사용자 이름");
		bottom.add(label, "West");
		input = new JTextField();
		bottom.add(input, "Center");
		input.addActionListener(this);
		add(bottom, "South");
		list.add(UserList);
		add(list, "East");
//		JPanel ServerGUI_Panel = new JPanel();
//		JLabel UserLabel = new JLabel("유저 목록");
//		TextArea UserList = new TextArea(30, 15);
//		ServerGUI_Panel.add(UserLabel);
//		ServerGUI_Panel.add(UserList);
//		add(ServerGUI_Panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		
	} // 생성자
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object c = e.getSource(); // getsource는 모든 이밴트 발생 객체를 가져옴
		if(c == input) {
			label.setText("메세지");
			o.println(input.getText());
			input.setText("");
		}
	}

	@Override
	public void run() {
		try {
			Socket s = new Socket(host, 7979);
			InputStream ins = s.getInputStream();
			OutputStream os = s.getOutputStream();
			i = new BufferedReader(new InputStreamReader(ins));
			o = new PrintWriter(new OutputStreamWriter(os), true);
			while(true) {
				String line = i.readLine();
				output.append(line + "\n"); 
				//text가 append 되어지는 개념이기 때문에
				jb.setValue(jb.getMaximum());
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//	public void AppendUserList(ArrayList NickName) {
//		String name;
//		for (int i = 0; i < NickName.size(); i++) {
//			name = (String) NickName.get(i);
//			UserList.append(name + "\n");
//		}
//	}
	
	public static void main(String[] args) {
		if(args.length > 0) {
			new Ex22(args[0]);
		} else {
			new Ex22("localhost");
		}
	}

}
