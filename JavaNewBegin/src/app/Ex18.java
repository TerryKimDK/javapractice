//package app;
//
//import java.awt.FileDialog;
//import java.awt.Menu;
//import java.awt.MenuBar;
//import java.awt.MenuItem;
//import java.awt.TextArea;
//import java.awt.event.ActionEvent;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class Ex18 extends implements ActionListener{
//	public MenuBar mb;
//	public Menu m;
//	public MenuItem[] mi;
//	public FileDialog fd_load, fd_save;
//	public TextArea ta;
//	int a = 0;
//	public Ex18 () {
//		ta = new TextArea();
//		ta.setEditable(false);
//		fd_load = new FileDialog(this, "파일 열기", FileDialog.LOAD);
//		fd_save = new FileDialog(this, "파일 저장", FileDialog.SAVE);
//		mb = new MenuBar();
//		m = new Menu("File");
//		mi = new MenuItem[5];
//		mi[0] = new MenuItem("New File");
//		mi[1] = new MenuItem("Open File");
//		mi[2] = new MenuItem("Save File");
//		mi[3] = new MenuItem("Save As");
//		mi[4] = new MenuItem("Exit");
//		for(int i = 0; i < mi.length; i++) {
//			m.add(mi[i]);
//			mi[i].addActionListener(this);
//			if( i != 2 && i != (mi.length -1))
//				m.addSeparator();
//		}
//		mi[1].setEnabled(false);
//		mb.add(m);
//		setMenuBar(mb);
//		add(ta, "Center");
//		setSize(500, 500);
//		setVisible(true);
//	}
//	public void actionPerformed(ActionEvent e) {
//		Object obj = e.getSource();
//		if(obj.equals(mi[4])) {
//			System.exit(0);
//		}else if(obj == mi[0]) {
//			mi[1].setEnabled(true);
//			ta.setEditable(true);
//		}else if(obj == mi[1]) { //open File
//			//open file
//			fd_load.setVisible(true);
////			fd_open.getDirectory() fd_open.getFile()
//			FileReader fr = null;
//			BufferedReader br = null;
//			ta.setEditable(true);
//			ta.setText("");
//			try {
//				File file = new File(fd_load.getDirectory() + fd_load.getFile());
//				fr = new FileReader(file);
//				br = new BufferedReader(fr);
//				while(br.ready()) {
//					ta.append(br.readLine() + "\n");
//				} 
//				}catch(IOException ex) {
//					ex.printStackTrace();
//				}finally {
//					try {
//						br.close();
//						fr.close();
//					}catch(IOException ex) {
//						ex.printStackTrace();
//					}
//				}
//			}
//		}
//	}
