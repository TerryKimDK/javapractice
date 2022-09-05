package app;

public class ShapeUser {
	
	public static void main(String[] args) {
		Shape[] shape = new Shape[3];
		int i;
		// 배열의 특징 선언된 type 만 담을 수 있음
		shape[0] = new Circle(5);
		shape[1] = new Circle(7);
		shape[2] = new Rect(9, 5);
		
//		System.out.println("shape[0]'s area = " + shape[0].area());
//		System.out.println("shape[1]'s area = " + shape[1].area());
//		System.out.println("shape[2]'s area = " + shape[2].area());
//		
		for(i = 0; i < 3; i++ ) {
			System.out.println("shape [" + i + "]'s area = " + shape[i].area());
		}
		
		Rect rect = (Rect)shape[2];
		System.out.println(rect + "나 rect");
		rect.getSize();
		
		
		System.out.println("circumference[0] = " + shape[0].circumference());
		System.out.println("circumference[1] = " + shape[1].circumference());
		System.out.println("circumference[2] = " + shape[2].circumference());
	}

}
