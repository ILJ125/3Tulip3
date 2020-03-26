package e_static_sample;

public class DBConect {
	//100만명이 들어와도  DBConnection은 하나만  사용 합니다.
	static DBConect con; //static은 static에만 접근할 수있기에 getInstance()에서 con에 접근하기 위해서 static 븥여줌

	private DBConect(){
		System.out.println("실제로 디비 연결");
	}
	
	public static DBConect getInstance() //main에서 클래스 객체 생성을 안하고 클래스명으로 이함수를 불러야한다. 그래서 static으로 선언
	{
		if(con==null) con = new DBConect();//맨처음만 생성하고 그 외에는 절 대  생성 안할 거야
		return con;
	}
}