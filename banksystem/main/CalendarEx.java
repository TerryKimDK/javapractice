package main;

import java.util.Calendar;
public class CalendarEx implements Runnable {
    public CalendarEx() {
        (new Thread(this)).start();
    }

    public static void main(String[] args) {
        new CalendarEx();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(1);
        int month = cal.get(2) + 1;
        int date = cal.get(5);
        int hour = cal.get(10);
        int minute = cal.get(12);
        int second = cal.get(13);
        boolean run = false;
        System.out.println(hour + " 시" + "\t" + minute + " 분" + "\t" + second + "초 입니다.");
        int dayOfWeek = cal.get(7);
        System.out.println(dayOfWeek);
        String korDate = "";
        switch (dayOfWeek) {
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
        }

        System.out.println(korDate + "요일입니다.");
        String[] yoil = new String[]{"월", "화", "수", "목", "금", "토", "일"};
        System.out.println("오늘의 요일은 " + yoil[dayOfWeek - 1] + "요일입니다.");
//        int year = 2022;
//        int month = 9;
        cal.set(year, month - 1, 1);
        int lastDay = cal.getActualMaximum(5);
        System.out.println("일\t월\t화\t수\t목\t금\t토 ");

        for(int i = 1; i < lastDay + dayOfWeek; ++i) {
            if (i < dayOfWeek) {
                System.out.print("\t");
            } else {
                System.out.print(i - dayOfWeek + 1 + "\t");
                if (i % 7 == 0) {
                    System.out.println();
                }
            }
        }

    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000L);
                System.out.println(Calendar.getInstance().get(13));
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
    }
}
