package f_exception;

public class Ex05_exception {

	public static void main(String[] args) {
		try {
			readArray(); 
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 정상 종료");
	}
	static void readArray() throws Exception{
		try {
			String [] msg = new String[] {"행복하자","끝내자","맛난거먹자"};
			for(int i=0; i<=msg.length;i++) {
				System.out.println(msg[i]);
			}
		}catch(Exception ex) {
			System.out.println("예외발생 :" +ex.getMessage());
			throw new MyException();
		}
	}
}




		/*
  함수에서 예외가 발생하면 main으로 예외발생했다고 던진느거 throws Exception
 MyException 클래스로 던짐
		 */