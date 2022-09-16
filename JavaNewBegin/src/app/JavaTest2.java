package app;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JavaTest2 extends JFrame {
	JMenuItem eventTestItem;
	JPanel displayPanel;
	JPanel inputPanel;
	JTextArea display;
	JTextField input;
	JFileChooser chooser;
	String fileName = "";
	
	public JavaTest2() {

		displayPanel = new JPanel();
		display = new JTextArea(15, 30);
		this.setTitle("Menu Title");
		this.setSize(500, 500);
		setResizable(false);
		
		createMenu(); 	//메뉴바
		
		Font displayFont = new Font("Serif", Font.BOLD, 20);
		display.setFont(displayFont);
		display.setEditable(true);
		

		JScrollPane scroll = new JScrollPane(display);
		displayPanel.add(scroll);
		
// input창		
//		inputPanel = new JPanel();
//		inputPanel.setLayout(new FlowLayout());
//		input = new JTextField();
//		
//		Font inputFont = new Font("Serif", Font.BOLD, 20);
//		input.setFont(inputFont);
//		input.addActionListener(this);
//		
//		inputPanel.add(input);
//		this.setLayout(new BorderLayout());
//		this.add(inputPanel, BorderLayout.CENTER);
		this.add(displayPanel, BorderLayout.CENTER);
		 
		
		this.setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar(); //메뉴바생성
		JMenu fileMenu = new JMenu("File"); // File이라는 이름의 메뉴생성
		JMenu editMenu = new JMenu("Edit"); // Edit이라는 이름의 메뉴생성
		
		mb.add(fileMenu);
		mb.add(editMenu);
		
		
//		NoteActionListener2 n = new JMenuItem("New File");
//		fileMenu.add(eventTestItem);
//		eventTestItem.addActionListener(this);
		fileMenu.addSeparator(); // 분리선
		fileMenu.add(new JMenuItem("Open File"));
		fileMenu.addSeparator(); // 분리선
		fileMenu.add(new JMenuItem("Save File"));
		fileMenu.add(new JMenuItem("Save As"));
		fileMenu.addSeparator(); // 분리선
		fileMenu.add(new JMenuItem("Exit"));
		
//		eventTestItem = new JMenuItem("New File", KeyEvent.VK_E);
//		fileMenu.add(eventTestItem);
		
		
		mb.add(new JMenu("Source"));
		
		this.setJMenuBar(mb);
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
////		String cmd = e.getActionCommand();
////		System.out.println(cmd);
//	}
	
	public void newfile() {
		display.setText("");
	}
	
	public void openfile() {
		 int ret = chooser.showOpenDialog(null);
		 
        if (ret != JFileChooser.APPROVE_OPTION) {
 
            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return;
 
        } else {
            File inFile = chooser.getSelectedFile();
            BufferedReader in;
            try {
                in = new BufferedReader(new FileReader(inFile));
                String c;
                display.setText("");
                while ((c = in.readLine()) != null) {
                    display.append(c + "\r\n");
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
 
        }
        fileName = chooser.getSelectedFile().toString();
        setTitle(chooser.getSelectedFile().getName());
		
	}
	
	public void savefile(String fn) {
		 BufferedWriter out = null;
         File file = new File(fileName);
         try {
            out = new BufferedWriter(new FileWriter(file));
            out.write(fn);
            this.setTitle(file.getName());
            out.close();
         }
         catch(IOException e) {
            e.printStackTrace();
         }
	}

	public void saveAsfile() {
		
	}
	
	public static void main(String[] args) {
		new JavaTest2();
	
	}

}
