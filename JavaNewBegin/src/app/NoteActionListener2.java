package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class NoteActionListener2 implements ActionListener{
	//멤버변수
	private JavaTest2 frm;
	String cmd;
	//생성자
	
    public NoteActionListener2(JavaTest2 n) {
        this.frm = n;
    }

	@Override
	public void actionPerformed(ActionEvent eventTestItem) {
		cmd = eventTestItem.getActionCommand();
        switch (cmd) {
 
        case "New File":
            frm.newfile();
            break;
        case "Open File":
            frm.openfile();
            break;
        case "Save File":
            if(frm.fileName.equals("")) { //다른이름으로 저장과 일반 저장을 구분하기 위함, 처음 실행시 일반저장버튼을 눌렀을때 chooser가 열리도록 함
                   int ret = frm.chooser.showSaveDialog(null);
                   
                   if(ret != frm.chooser.APPROVE_OPTION) {
                      JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
                      return;
                   }
                   
                   frm.fileName = frm.chooser.getSelectedFile().getPath();
                }
                frm.savefile(frm.display.getText()); //저장
                
                break;
        case "Save As": //무조건 chooser로 다이얼로그 열어서 저장
                int ret = frm.chooser.showSaveDialog(null);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    frm.fileName = frm.chooser.getSelectedFile().getPath();
                    frm.savefile(frm.display.getText());
                }
                
            break;
        case "Exit":
        	System.exit(0);
            break;
        }
	}
    
}
