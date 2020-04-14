package d_array;

import java.util.Scanner;

public class Ex6_baseball {

	public static void main(String[] args) {
		// 야구 게임

		int [] baseball=new int[3];//컴퓨터로 랜덤 숫자 3개 받을 정수형 배열
		int [] answer = new int[3];//직접 입력할 숫자 3개 받을 정수형 배열
		//임의 수 저장 +중복 수 배제
		for(int i=0;i<baseball.length;i++) //컴퓨터에 3개의 숫자를 입력해야함 (3번반복) =배열 baseball의 길이(3) 만큼 반복 
		{
			baseball[i]=(int)(Math.random()*10);//baseball[0]~[2] 배열에 0~9까지 정수형으로 랜덤 숫자 저장
			if(i != 0) //baseball[i]와 그 이전 숫자를 비교하는데 i=0일때  baseball[0]의 이전 숫자 없음. 0이 아닐때 비교를 해야한다.
					   //baseball[i]와 이전 숫자를 비교해서 중복 되면 다시 숫자를 랜덤으로 저장하고 중복 되지 않으면 통과!
			{
				boolean compare=true;//while은 true 일때 반복 되니,반복을 위해 먼저 true로 잡아주고, 나오고 싶을 때 false를 저장해 준다.
				while(compare) {
					if(baseball[i]==baseball[i-1]) {
						baseball[i]=(int)(Math.random()*10);//다시 랜덤으로 설정
					}else {
						compare=false;//중복 되지 않으면 while 반복문 탈출!
					}
				}
			}
//			System.out.print(baseball[i]+" ");//컴퓨터 입력 숫자를 알고싶어서 출력해 봄
		}
		System.out.println();//컴퓨터 결과 값 보고 뛰어쓰기 한번 하고 싶었어
		
		int strike =0;
		int ball=0;//do { ]while(조건) 일때 ,만약 { } 안에서 int strike를 선언해주면 블럭 바깥에 조건문에서 strike 변수를 인식 못함 
		//입력자에게 숫자 입력 받기
		HERE://중복이 있을 경우 continue로 do 반복문 블록의 제일 끝으로 가서 다시 반복 시키기 위해서 
			do{
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				strike=0;//정답을 못 맞췄을 때 다시 strike와 ball을 초기화 시켜줘야지 게임 진행에 오류가 없다.
				ball=0;
				Scanner input=new Scanner(System.in);//Scanner 통로 선언
				System.out.println("0~9까지 중복되지 않는 3개 숫자를 입력해주세요.");
				for(int i=0;i<answer.length;i++) //숫자 3개를 입력 받아서 answer[0]~[answer의 길이-1]입력 받고 싶어서
				{
					answer[i]=input.nextInt();

				}
				//입력받은 값 중복 제거
				for(int i=0;i<answer.length;i++)//위 for 에서 숫자 3개를 다 입력받고 그 후에 중복체크를 해주기위해 또 반복문을 만듬 
				{
					if(i != 0) {
						boolean compare=true;//위 컴퓨터 입력받은 값 중복제거와 유형이 같다. 
						while(compare) {
							if(answer[i]==answer[i-1]) {
								System.out.println("중복이 있습니다.");
								continue HERE ;//중복이 있다고 알리고, 다시 숫자를 입력받기 위해서 숫자 입력부터 다시하는 do while 반복문을 반복하고 싶어서 continue Label 사용
							}else compare=false;//false를 꼭 입력해줘야한다. 아무것도 입력안해주면 무한 반복 된다.
						}
					}
				}


				//S 인지 B인지 비교
				
				//baseball[0]에 answer[0]~[2] 3개 숫자를 비교해주고, baseball[1]에도 3개 숫자 비교 해서 각 baseball[] 배열에 answer배열 각각 비교하기위해 2중 반복문 사용
				for(int i=0;i<baseball.length;i++) {
					for(int j=0;j<answer.length;j++) {
						if(baseball[i]==answer[j])//컴퓨터 숫자와 내가 입력한 숫자가 같을 때 ,컴퓨터숫자의 위치랑 내가입력한 숫자의 위치가 같으면 S 위치가 다르면 B 
							{
							if(i==j) {
								strike++;
							}else {
								ball++;
							}
						}
					}
				}
				System.out.println("Strike = "+strike);
				System.out.println("Ball = "+ball);
			}while(strike<3);//strike가 3이 되면 false로 while 반복문 벗어나기 위해서 
		System.out.println("정답입니다. 축하합니다 ");
	}

}
