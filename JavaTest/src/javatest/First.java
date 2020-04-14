package javatest;

import java.util.Calendar;

public class First {

	public static void main(String[] args) {
		int born_year=0;
		born_year=1995;
		
		
		int age=0;
		Calendar cal = Calendar.getInstance();
		int this_year =cal.get(Calendar.YEAR);
		age=this_year -born_year;
		
		System.out.println("내가 태어난 연도 : "+ born_year +"\n내 나이 :"+age);

	}

}
//공식:현재년도-태어난 년도