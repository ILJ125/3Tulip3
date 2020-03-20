package c_control;

import java.util.Scanner;

public class Ex01_if_학번 {

	public static void main(String[] args) {
		// 카페 [연습] if 문
		Scanner input=new Scanner(System.in);
		System.out.println("학번을 입력해주세요");
		String id = input.nextLine();//학번 10자리 
//		String id ="2017111001";
		
		//id에서 숫자 추출
		char id_department =id.charAt(4);//id에서 학과 추출, 한 자리
		String id_major=id.substring(5,7);//id에서 전공번호 추출, 2자리
		//입학년도 추출
		String start_year = id.substring(0,4);
		
		//단과번호(1이면 공대, 2이면 사회대
		String department="";
		String major="";//단과,전공 입력할 변수 문자열로 선언
		if(id_department=='1') {
			//공대
			 department="공대";
			//전공
		
//			if(id_major.equals("11")) {
//				 major="컴퓨터학과";
//			}else if(id_major.equals("12"))
//			{
//				 major="소프트웨어학과";
//			}else if(id_major.equals("13"))
//			{
//				 major="모바일학과";
//			}else if(id_major.equals("22"))
//			{
//				 major="자바학과";
//			}else if(id_major.equals("33"))
//			{
//				 major="서버학과";
//			}
			 switch(id_major) {
			 
			 case "11": major="컴퓨터학과";break;
			 case "12": major="소프트웨어학과";break;
			 case "13": major="모바일학과";break;
			 case "22": major="자바학과";break;
			 case "33": major="서버학과";break;
			 default:major="공대";
			 }
			
			
		}else if (id_department=='2'){
			//사회대
			 department="사회대";
			if(id_major.equals("11")) {
				 major="사회학과";
			}else if(id_major.equals("12"))
			{
				 major="경영학과";}
			else if(id_major.equals("13")) 
			{
				 major="경제 학과";
			}
			
		}
		
//		System.out.println(id+" 는  " +start_year+"년도에 입학한 "+department +" "+ major+" 학생입니다.");
		System.out.println(id+"\n입학년도 : "+start_year+"\n단과대학 : "+department+"\n전공 : "+major);
	}

	
	
}
