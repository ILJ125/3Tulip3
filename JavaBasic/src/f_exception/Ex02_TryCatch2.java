package f_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02_TryCatch2 {

	public static void main(String[] args) {

		//		java 파일 외 파일에서 정보 가져오고 싶을 때사용한느 가상 토로
		//		FileInputStream fis = new FileInputStream("data.txt");
		//		try catch가 없으면 오류가난다.
		//		오류해결에서 surround try catch를누르면 try구문생성
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("data.txt");
			System.out.println("파일 연결됨");
			fis.read();


		} 
		//			catch (FileNotFoundException e) {
		//			
		//			System.out.println("파일없음 예외");
		//		}catch(IOException e) {
		//			System.out.println("읽을 때 예외 발생");
		//		}
		catch(Exception e) {
			System.out.println("그 외 예외처리");
		}
		finally {
			try {
				fis.close();//통로 닫는 앤느 꼭 필요하다.
			} catch (IOException e) {

			}


		}

	}

}
