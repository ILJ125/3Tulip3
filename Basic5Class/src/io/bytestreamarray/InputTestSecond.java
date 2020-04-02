package io.bytestreamarray;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputTestSecond
{
	public static void main( String args[] ) 
	{
		try
		{
			//숫자형 인식은 notepad는 못 쓴다.
			//Filtering으로 byte로 받아온걸 자바가 숫자로 인식할 수 있도록
			//notepad랑도 공유할려면 문자형으로 다받아야겠다.
			FileInputStream fis = new FileInputStream("b.txt");
			byte [] data = new byte[1024]; //배열의 단점 갯수가 한정되있음
			
			int count = fis.read(data);
			
			for (int i=0; i<count;i++) {
				System.out.println((char)data[i]);
			}
			
		}catch( Exception ex ){
			System.out.println("파일전송실패 :" + ex.toString() );
		}
	}	
}

/*
	======================================
		결과 출력
	======================================

	` 숫자만 나오는데, 우선 열개만 읽어서 숫자 자체로 출력하고
	나머지는 읽어서 (char) 형변환 하면 문자로 출력될 것이
*/