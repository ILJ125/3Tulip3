package d_array;

public class Ex6_복습 {

	public static void main(String[] args) {
		// 1. 3*4의 char형 배열 ch를 선언하기
		char[][] ch=new char[3][4];//변수 선언 & 객체생성 같이해줌 

		//값입력
		char alph='A';//출력하고 싶은 초기값을 밖에 설정해 주고 반복문 도는 만큼 증가 시켜 줄 수 있다. 
		for(int i=0;i<ch.length;i++) 
		{
			for(int j=0;j<ch[i].length;j++,alph++) {
				//ch[i][j]='z';
				//ch[i][j]=alph++;//이 반복문은 총 밖에 반복문 3번, 안에 반복문 4번 해서 총 3*4 12번 돈다. 계속 1씩 더하면 12까지 증가한다. 
				ch[i][j]=alph;//증가 부분을 for문에 같이 넣을 수 있다.	
				}
		}
		//출력
		for(int i=0;i<ch.length;i++) 
		{
			for(int j=0;j<ch[i].length;j++) {
				System.out.print(ch[i][j]+" ");
			}
			System.out.println();
		}
	}

}
