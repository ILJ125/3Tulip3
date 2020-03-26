package f_innerclass;

class Outer
{
	class Inner //밖에 클래스에서는 안에 클래스가 멤버 변수처럼 취급 된다.
	{
		void naJabara(){
			System.out.println("잡아보슈~~");
		}
	}
}

public class InnerTest {
	public static void main(String[] args) 
	{
		Outer o=new Outer();
		Outer.Inner in =o.new Inner();//이렇게 써야하는 거야 외워 그냥
		in.naJabara();
		
	}
}


