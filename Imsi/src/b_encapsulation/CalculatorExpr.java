package b_encapsulation;

public class CalculatorExpr {
	private int num1=0;
	private int num2=0;
	
	public int getAddition() {
		
		return num1+num2;
	}
	
	public int getSubtraction() {
		
		return num1-num2;
	}
	
	public int getMultiplication() {
		
		return num1*num2;
	}
	
	public double getDivision() {		
		return (double)num1/num2;
	}
//모든 멤버 변수에 대한 getter setter 만듬
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	

}
