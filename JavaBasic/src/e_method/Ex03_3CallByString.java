package e_method;

public class Ex03_3CallByString {

	public static void main(String[] args) {
		String a = new String("안녕");
		String b = new String("하이");
		add(a,b);
		System.out.println("A="+a+ ",B="+b);
	}
	//참조형이 인자이다 보니 주소값을 보낸다. 그렇기 때문에 원본이수정이 됩니다.
	static void add(String a, String b) 
	{
		a+=b;
		System.out.println("A=" +a+ ", B= " +b);
	}

}
