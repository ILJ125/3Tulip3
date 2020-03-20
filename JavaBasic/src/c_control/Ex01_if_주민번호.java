package c_control;

import java.util.*;


public class Ex01_if_주민번호 {

	public static void main(String[] args) {
	
		//id에서 7번째 문자가 1이면 남자 2이면 여자
		String id="953456-1234567";
		char sung = id.charAt(7);
		//sung 변수에 값이 1,3이면 "남자"출력
		//그렇지 않고 sung 변수에 값이 2,4이면 '여자'출력
		
		if(sung =='1'|sung=='3'|sung=='9') {
			System.out.println("남자");
		}else if(sung=='2'|sung=='4'|sung=='0'){
			System.out.println("여자");
		}
		//나이를 구해 봅시다.
		String s_nai= id.substring(0,2); //문자열로 나이를 구하기 위한 연도를 s_nai 변수에 입력
		//문자열을 정수로 변환
		int i_nai=Integer.parseInt(s_nai);//문자열로 구한 나이를 구하기 위한 연도를 정수형으로 바꿈
		
		//나이 = 올해년도 - (1900 + 주민등록번호 앞자리 2개 ) +1
		int age=0;//계산된 나이
/*		
		//이번 년도 입력으로 받음
		int this_year=0;
		System.out.println("올해 연도는 몇년도 인가요?");
		Scanner input= new Scanner(System.in);
		this_year=input.nextInt();
*/		
		//올해 년도 구하기
		
		Calendar c =Calendar.getInstance();
		int this_year=c.get(Calendar.YEAR);
				
		if(sung=='1'|sung=='2') //1900년대
		{
			age=this_year-(1900+i_nai)+1;
			System.out.println(age);
		}else if(sung=='3'|sung=='4')//2000년대
		{
			age=this_year-(2000+i_nai)+1;
			System.out.println(age);
		}else if(sung=='0'|sung=='9')//1800년대
		{
			age=this_year-(1800+i_nai)+1;
			System.out.println(age);//나이 출력
		}
		
		
	}

}
