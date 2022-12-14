package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Ex14 extends Frame implements Runnable{
	int x = 0;
	int y = 20;
	
	boolean xOrient, yOrient;
	public Ex14() {
		super("hi");
		setSize(300, 200);
		setVisible(true);
		addWindowFocusListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		
	}
	public void paint(Graphics gr) {
		Random ran = new Random();
		Dimension d = this.getSize();
		if (xOrient) {
			x--;
			if (x < 0) {
				x = 0;
				xOrient = false;
			}
		} else {
			x++; 
			if (x>=d.width-20) {
				x = d.width -20;
				xOrient = true;
			}
		}
		if (yOrient) {
			y--;
			if (y <0) {
				y=0;
				yOrient = false;
			}
		}else {
			y++;
			if(y>=d.height - 20) {
				y= d.height - 20;
				yOrient = true;
			}
		}
		int r = ran.nextInt(255);
		int g = ran.nextInt(255);
		int b = ran.nextInt(255);
		gr.setColor(new Color(r, g, b));
		gr.drawRect(x, y, 20, 20);
	}
	public void update(Graphics g) { //update는 그림을 제거하는 역할 그리고 paint를호출
		paint(g);
		
	}

	public void run() {
		while(true) {
			repaint(); //repaint 는 update 를 호출
			try {
				Thread.sleep(10);
			}catch(InterruptedException e)	{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new Ex14());
		//thread.start(); //run 메소드 호출하는 녀석
		thread.run();
	}

}
