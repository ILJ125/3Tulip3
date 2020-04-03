package network1.basic;

import java.io.*;
import java.net.*;

public class SimpleServer {
	
	public final static int PORT = 5000;	// PortNumer : 1024 ~
	
	public static void main( String args[] ) {
		
		ServerSocket 		server = null;
		DataInputStream 	in = null;
		DataOutputStream out = null;
		Socket clientSocket = null;
		
		try{
			// 1. 서버 소켓 생성
			server = new ServerSocket( PORT );
			System.out.println("SimpleServer started..");
		
			// 2. 클라이언트 접속시 소켓 생성
			// 3. 소켓의 입출력 스트림 얻기
			clientSocket = server.accept();//많이 중요해 //클라이언트가 접속할 때 바로 Socket에 연결 해줄게
			//이게 여러개이면 여러개의 클라이언트를 받을 수있음(독립적인 제어권 가진 반복문=Thread)
			
			in = new DataInputStream( clientSocket.getInputStream());//소켓안에 입출력을 필터링함
			out = new DataOutputStream( clientSocket.getOutputStream() );
		
			// 4. 데이터 전송
				String line = in.readUTF();//상대방이 write를 했기에 읽기 가능
				System.out.println("we received : " + line );//읽어서 화면에 찍음
				if( line.compareTo("안녕") == 0 ) 
				{
					out.writeUTF("나 배고파여 끄앙." );//내가 쓰겠다는거는 상대방이 읽겠다는겁니다.	
				} else {
					out.writeUTF("안녕만 입력받으니깐 안녕만 쳐여 알겠어여? 네? 알겠냐구요?.");
				}
		
			// 5. 소켓닫기
			in.close();
			out.close();
			clientSocket.close();
		} catch ( Exception ex ) {
			System.out.println( ex.getMessage() );	
		}
	}	
}