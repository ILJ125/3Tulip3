package f_exception;

public class MyException extends Exception{
	//영역 별로 보기 위해서 별도 로 만듬
	public String getMessage() {
		return "맨날 실수하는 예외: 배열 범위 잘 봐라";
	}

}
