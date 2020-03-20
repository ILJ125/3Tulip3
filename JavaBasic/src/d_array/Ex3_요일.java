package d_array;

import java.util.Calendar;

public class Ex3_요일 {

	public static void main(String[] args) {
		// 날짜
		Calendar cal = Calendar.getInstance();//새로 만드는게 아니라 만들어진걸 가져 온다.
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH);
		int date=cal.get(Calendar.DATE);
		//시,분,초
		int hour =cal.get(Calendar.HOUR);
		int minute =cal.get(Calendar.MINUTE);
		int second=cal.get(Calendar.SECOND);
		//요일
		int day=cal.get(Calendar.DAY_OF_WEEK);
		
		String [] yoil= {"일","월","화","수","목","금","토"};
		
		System.out.println(year+"년 "+(month+1)+"월 "+date+"일 "+(yoil[cal.get((int)Calendar.DAY_OF_WEEK)-1])+"요일 ");
		System.out.println(hour+"시"+(minute)+"분"+second+"초");
	}

}
