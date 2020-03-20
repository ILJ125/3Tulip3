package c_control;

import java.util.*;

public class Ex_while개념 {
	public static void main(String[] args) {
		
		//1~10까지 출력
/*		int hap=0;
		int i=1;//for문 초기값의 적절한 위치는 for문 바로 전
		for(;i<=10;) {
			hap += i;//hap=hap+i i값을 누적으로 합하여 저장
			i++;
		}
		System.out.println(hap);
		
		int hap=0;
		int i=1;
		while(i<=10) {
			hap += i;//hap=hap+i i값을 누적으로 합하여 저장
			i++;
		}//for문에서 초깃값,증가치를 바깥으로 뺀게 while입니다.
		System.out.println(hap);
		
		
		//숫자 하나 입력받기->구구단 출력
		Scanner input=new Scanner(System.in);
		System.out.println("숫자하나 입력해봐라");
		int num=input.nextInt();
		
		for(int i=1;i<10;i++) {
			
				System.out.println(num+"*"+i+"="+num*i);
			
		}
		
		int i=1;
		while(i<10) {
			System.out.println(num+"*"+i+"="+num*i);
			i++;
		}
		
		// 문장을 입력 받아 단어로 나눠서 출력
		// 안녕하세요. 오늘  점심 머에요? 하면 안녕하세요 /오늘/점심/머에요?
		Scanner input=new Scanner(System.in);
		System.out.println("문장 한 번 입력해봐라");
		String line=input.nextLine();
		StringTokenizer st = new StringTokenizer(line);
		while(st.hasMoreTokens()) {
			String temp=st.nextToken();//토큰 가져 오는거
			System.out.println(temp);
			
		}//hasMoreTokens()는 불린 형으로 다음 토큰이 있나요? 있으면 True 없으면 False
	
		//예시)80/90/70 을 / 기준으로 뜯어내서 하나씩 출력해줘봐
		Scanner input=new Scanner(System.in);
		System.out.println("문장 한 번 입력해봐라");
		String line=input.nextLine();
		
		StringTokenizer st = new StringTokenizer(line,"/");
		//"/" 슬러시 기준으로 끊어줘잉
	
		while(st.hasMoreTokens()) {
			String temp=st.nextToken();//뜯어낸 토큰을 임시로 저장
			int su =Integer.parseInt(temp);//나는 숫자를 뜯어내고싶은데 string 형으로 입력 받았으니 int형으로 바꿔줘
			System.out.println(++su);//증감형이 적용되면 숫자형인거니까 확인한번 해볼까?
			}
				
		
		//연습 while문 카페
		
		int even=0;//짝수 갯수 입력
		int odd=0;//홀수 갯수 입력
		Scanner input=new Scanner(System.in);
		System.out.println("숫자 원하는대로  뛰어쓰기해서 입력해라 알겠냐?");
		String line=input.nextLine();
		
		StringTokenizer st = new StringTokenizer(line);
		
		while(st.hasMoreTokens()) {
			String temp=st.nextToken();
			int su =Integer.parseInt(temp);
			if(su%2==0) {
							if(su==0){
								System.out.println("0은 짝수도 홀수도 아니니깐 뺄게");
							}else {
								even++;
							}

			}else  {
				odd++;
			}			
		}
		System.out.println("짝수 갯수 :"+ even );
		System.out.println("홀수 갯수 :"+ odd );
*/

		
		
		
	}
}
