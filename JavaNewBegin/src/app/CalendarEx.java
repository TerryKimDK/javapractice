package app;

import java.util.Calendar;

/* caleder class 는 1970년 1월 1일 부터 특정 값으로 진보해 오면서 날짜와 시각에 대한 조작을 수행할 수 있는 abstract class다 object 생성법은 다음과 같다*/
// 1.  Calendar cal = Calendar.getInstance
// 2. GregorianCalendar cal = new GregorianCalender
// abstract 여서 new 해서 사요할 수 없음
public class CalendarEx implements Runnable
{
	
	public CalendarEx() {
		new Thread(this).start();
	}
	
	public static void main(String[] args) {
		new CalendarEx();
		Calendar cal = Calendar.getInstance();
//		System.out.print(cal);
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		int date = cal.get(Calendar.DATE);
		// 시, 분, 초 를 출력해보세요 ( hour, minute, second)
		// 요일 출력
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		boolean run = false;
		System.out.println(hour + " 시" + "\t" + minute +" 분" + "\t" + second + "초 입니다.");
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		String korDate = "";
		switch(dayOfWeek) {
		case 1: 
			korDate = "일";
			break;
		case 2: 
			korDate = "월";
			break;
		case 3: 
			korDate = "화";
			break;
		case 4: 
			korDate = "수";
			break;
		case 5: 
			korDate = "목";
			break;
		case 6: 
			korDate = "금";
			break;
		case 7: 
			korDate = "토";
			break;
		}
		
		System.out.println(korDate + "요일입니다.");
		
		String[] yoil = {"월","화","수","목","금","토","일"};
		//요일출력
		System.out.println("오늘의 요일은 " + yoil[dayOfWeek-1] + "요일입니다.");
		
		year = 2022;
		month = 9;
		cal.set(year, month-1, 1);
		//int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		System.out.println("일\t월\t화\t수\t목\t금\t토 ");
		for(int i=1; i< lastDay + dayOfWeek; i++) {
			if(i < dayOfWeek) {
				System.out.print("\t");
				continue;
			}
			System.out.print((i - dayOfWeek + 1) + "\t");
			if( i % 7 == 0) {
				System.out.println();
			}
		}
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(Calendar.getInstance().get(Calendar.SECOND));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
