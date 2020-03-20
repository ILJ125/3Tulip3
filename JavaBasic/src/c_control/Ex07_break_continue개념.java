package c_control;

public class Ex07_break_continue개념 {

	public static void main(String[] args) {
		// break,contine 개념
		
		HERE://Label 뒤에 가장 가까운 반복문을 나간다.
		for(int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++) {
				//if(j==1)break;//작은 for반복문{}블럭을 벗어남,가장가까운 반복문 블록을 벗어남
				//if(j==1)continue;//블럭 안에서 continue 뒤로 실행하지 않고 다시 {}앞부분으로 돌아감
				//if(j==1) break HERE;//중첩 반복문 전부다 나갈 거야
				if(j==1) continue HERE;
			System.out.printf("<%d,%d> \n",i,j);//0~조건식 만큼 즉 2번 반보 **이렇게 반복문끝날때 출력
			}
		System.out.println("==========================");

	}

	
	}
	
}

