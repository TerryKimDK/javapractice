package app;

class X {
	//필드와 메소드 2개씩
	protected int i = 10;
	protected String msg = "I am an X.";
	
	public void print() { 
		System.out.println(msg);
	}
	
	public void play() {
		System.out.println("Play.." + msg);
	}
}

class Y extends X {
	//필드 2개와 메소드 한개
	protected int i = 20;
	protected String msg = "I am an Y.";
	
	//상위 클래스의 메소드를 overide 하고있다 
	@Override
	public void print() {
		System.out.println(msg);
	}
}


public class Z extends Y{
	protected int i = 30;
	protected String msg = "I am a Z.";
	
	public void print() {
		System.out.println(msg);
	}
	
	public void play() {
		System.out.println("Play.." + msg);
	}
	
	public void doZ() {
		System.out.println("do something in Z.");
	}

	public void test(int i) { // z.test 15 전달
		
		Z z = new Z(); // 형변환
		Y y = z;
		X x = z;
		
		//  문제
		// 타입별로 각각의 메소드를 호출
		z.print();
		y.print();
		x.print();
		super.print(); // this는 나를 보고 super는 부모의 정보를 보겠다\
		play(); // this 가 생략 되어있다
		super.play();
		// y.doZ(); 없으므로 에러
		// super.super.print();
		
		System.out.println("\ni = " + i); // 지역변수 
		System.out.println("this.i = " + this.i); // member 필드를 쓴다면 강제로한다
		System.out.println("super.i =" + super.i); // 위와 마찬가지
		System.out.println("y.i = " + y.i); // 은닉변수 overshadow 
		System.out.println("x.i = " + x.i);
		System.out.println("((Y)this).i = " + ((Y)this).i);
		System.out.println("((X)this).i = " + ((X)this).i);
	}
	
	public static void main(String[] args) {
		Z z = new Z();
		z.test(15);
	}

}
