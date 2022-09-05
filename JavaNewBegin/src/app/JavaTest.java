package app;

import java.util.Random;

public class JavaTest {

	public static void main(String[] args) {
		/*
		 // 사각형
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		*/
		/*
		 // 삼각형
		for(int i=0; i<5; i++) {
			for (int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		*/
		
		int[] arr = new int[7];
		Random rd = new Random();
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = rd.nextInt(100)+1;
		}
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		int max = arr[0];
		int min = arr[0];
		
		for (int a=1; a<arr.length; a++) {
			if(max<arr[a]) max = arr[a];
			if(min>arr[a]) min = arr[a];
			
		}
		System.out.println("최대" + max + "최소" + min);
	}

}
