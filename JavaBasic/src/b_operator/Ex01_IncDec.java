package b_operator;

/**
 *  증가(++)/감소(--) 연산자
 */
public class Ex01_IncDec {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 7;
/*
		// [1]
		System.out.println("a="+a+" b="+b);
		System.out.println("a="+(a+1)+" b="+(b+1));//a=6. b=8 
		
		// [2]
		a=a+1; //a값에 1을 더 한 수를 a에 집어 넣어 주세요.
		b=b-1;
		System.out.println("a="+a+" b="+b);
		//[2]의 축약형
		a++;//a값에서 -1한 값을 a에 저장해주세요를 축약한 형
		b--;
		System.out.println("a="+(++a)+",b="+(--b));

		//[3]
		int result = ++a;
		System.out.println("결과 ++a : "+ result);
		
		int result2 =b--;
		System.out.println("결과 result2에 대입된 b값 : "+ result2);// b먼저 대입되고 -1이 됬다. result에 원래 b 값이 7이 대입 되고, b는 뒤에 -1이된 6이 b에 들어가 있다. 
		System.out.println("결과 result2에 대입후 변수 b에 들어있는 값 : "+ b);
*/
		//[4]
		System.out.println("a="+ ++a + ",b=" + --b);//6,6
		System.out.println("a="+ a++ + ",b=" + b--);//출력 6,6 데이터값 7,5
		System.out.println("a="+ a + ",b=" + b);//7,5
	}

}
