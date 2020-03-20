package c_control;

public class Ex03_switch_복습 {

	public static void main(String[] args) {
		// 카페 [복습] switch 문
		int i=1,j=0;
		switch(i) {
		case 2 : j += 6;break;
		case 4 : j += 1;break;
		default : j += 2;break;
		case 0 : j += 4;break;
				
		}
		System.out.println(j);
        // i의 case에 속하는 거 부터 break가 없어서 빠져나가는 게아니라 속하는거 부터 뒤에 내용이 다 실행 된다.
	}

}
