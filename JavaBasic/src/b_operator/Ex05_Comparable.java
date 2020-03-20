package b_operator;

public class Ex05_Comparable {

	public static void main(String[] args) {
		
		int kor = 98, eng = 87, math = 78;
		int total = kor + eng + math;
		double avg = total / 3.0;
		
		System.out.println("총점: " +  total ); 
		System.out.println("평균: " +  avg ); 	
		
		
		/*
		 * 90 이상 A / 80부터 90미만 B / 70부터 80미만 C
		 */
		if(avg>=90) {
			System.out.println("A학점 입니다.");
		}else if(avg >= 80) {
			System.out.println("B학점 입니다.");
		}else if(avg >= 70) {
			System.out.println("C학점 입니다.");
		}else {
			System.out.println("D학점 입니다.");
		}

		// 만일 작은 값부터 비교한다면, 예를 들어 avg >= 70 보다 크다를 먼저 비교하면?


	}

}
