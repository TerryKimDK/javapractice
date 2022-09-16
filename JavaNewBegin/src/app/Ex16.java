package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//inputstream과 outputstream
public class Ex16 {
	public static void main(String[] args) throws IOException{
		File file = new File("D:/IO/IO.txt");
		FileWriter fwriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fwriter); // 여기까지가 출력장치
		PrintWriter pw = new PrintWriter(bw, true);
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("입력 : ");
		String str = "";
		while(!str.equals("end")) {
			str = br.readLine();
			pw.println(str);
		}
		br.close();
		pw.close();
		
	}
	
}
