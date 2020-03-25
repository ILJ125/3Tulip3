package a_basic;

public class Student {
	//서로다른 데이터들을 student 라는 클래스로 묶음
	String name;
	int kor,eng,math;
	
	private int total;//아무도 접근해서 값 바꾸지 말록 private 선언 
						//다른 클래스가 접근 못함
	private double avg;
	
	int calTotal() {
		total=kor + eng +math;
		return total;
	}
	
	double calAve() {
		avg=(double)total/3;
		return avg;
	}
	
}
