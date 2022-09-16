package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bank extends JFrame {
    //생성자
    public Bank() {
        setTitle("DK BANK");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel title =
                new JLabel("DK Bank ", JLabel.CENTER);
        title.setForeground(new Color(5, 0, 153));
        title.setFont(new Font("휴먼편지체", Font.BOLD, 30));

        setLayout(new FlowLayout());
        JButton join = new JButton("로그인");
        JButton makeaccount = new JButton("회원가입");

        JTextField id = new JTextField(10);
        JPasswordField pwd = new JPasswordField(10);
        JTextField name = new JTextField(10);
        JTextField bac = new JTextField(10);

//		JRadioButton client = new JRadioButton("고객");
//		JRadioButton manager = new JRadioButton("관리자");

        Container contentPane = getContentPane();
        ButtonGroup bg = new ButtonGroup();
//		JPanel radioPanel = new JPanel();
//		radioPanel.add(client);
//		radioPanel.add(manager);
//		bg.add(client);
//		bg.add(manager);

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        idPanel.add(new JLabel("아이디 : "));
        idPanel.add(id);


        JPanel pwdPanel = new JPanel();
        pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pwdPanel.add(new JLabel("비밀번호 : "));
        pwdPanel.add(pwd);


        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        namePanel.add(new JLabel("이    름 : "));
        namePanel.add(name);

        contentPane.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1));
        formPanel.add(idPanel);
        formPanel.add(pwdPanel);
        formPanel.add(namePanel);

        // radio + form panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
//		contentPanel.add(radioPanel);
        contentPanel.add(formPanel);

        // button panel
        JPanel panel = new JPanel();
        panel.add(join);
        panel.add(makeaccount);

        add(title, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);


        setBounds(400, 400, 300, 300); // 3번째 가로

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //컴포넌트 생성 및 추가
        //	this.add();
        setVisible(true);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Bank();

    }

}
