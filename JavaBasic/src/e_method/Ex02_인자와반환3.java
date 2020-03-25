package e_method;

public class Ex02_인자와반환3 {

	public static void main(String[] args) {
		//2가지 이상의 값을 함수에서 받고 싶을 때 배열을 사용하겠음
		
		
		//데이터를 넘겨 받아 합 구하고 출력
		int []arr =add();
		int sum=arr[0] +arr[1]; //만약 여기서 계산해야 할 갯수를 모르면 for문으로 돌린다.
	}
	//반환 하는 것이 int형 배열이다.
	static int[] add() {
		//입력 데이터 
		int a  =10, b=20;
		//2가지 이상 변환 시키고 싶다.
		int []arr= {a,b};		
		return arr;
	}


}
