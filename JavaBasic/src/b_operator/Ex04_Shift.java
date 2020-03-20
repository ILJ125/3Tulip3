package b_operator;

/**
 *  shift : 모든 비트의 값을 이동하는 연산자
 *  
 *  [예] 0000 0010	<<1 		0000 0100
 *  	  0000 0010	>>1		0000 0001
 */
public class Ex04_Shift {

	public static void main(String[] args) {

		int su =-4;
		System.out.println(su);
		System.out.println(su >> 2);//부호는 바뀌지 않음 -1
		System.out.println(su << 2);//-16
		
		System.out.println(su >>>1 );// 부호비트를 0으로 채움
	}

}
