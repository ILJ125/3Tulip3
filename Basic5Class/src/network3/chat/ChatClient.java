package network3.chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClient implements ActionListener,Runnable {
	JFrame f;

	JTextField connTF, sendTF;
	JButton connB, sendB;
	JTextArea ta;

	Socket s;
	BufferedReader in;
	OutputStream out;

	// 추가0 : 대화명을 바꾸기
	JTextField changeNameTF;
	JButton    changeNameB;

	// 추가2 : 방인원의 대명 보여주기
	// 변수 선언
	JList  memberList;
	Vector list;

	public ChatClient() {
		f = new JFrame("Chat Client");


		connTF = new JTextField();
		sendTF = new JTextField();
		connB = new JButton("접 속");
		sendB = new JButton("확 인");
		ta = new JTextArea(15,40);

		// 추가0: 대화명 바꾸기
		changeNameTF	= new JTextField("guest", 10);
		changeNameB		= new JButton("바꾸기");
		JPanel p_changeName = new JPanel();
		p_changeName.add( new JLabel("대화명 : "),"West" );
		p_changeName.add(changeNameTF, "Center");
		p_changeName.add(changeNameB, "East");

		JPanel p_serverName = new JPanel();
		p_serverName.setLayout( new BorderLayout() );
		p_serverName.add( new JLabel("서버입력 : "),"West" );
		p_serverName.add(connTF, "Center");
		p_serverName.add(connB, "East");

		JPanel p_north = new JPanel();
		p_north.setLayout( new GridLayout(1, 2));
		p_north.add( p_changeName );
		p_north.add( p_serverName );

		JPanel p2 = new JPanel();
		p2.setLayout( new BorderLayout() );
		p2.add( new JLabel("메세지입력 : "),"West" );
		p2.add(sendTF,"Center");
		p2.add(sendB, "East");

		// 추가2 : 방인원의 대명 보여주기
		memberList = new JList();
		list		= new Vector();
		JPanel  p_east = new JPanel();
		p_east.setLayout( new BorderLayout());
		p_east.add("North", new JLabel("   우 리 방 멤 버   "));
		p_east.add("Center", memberList );



		f.getContentPane().add("North", p_north);
		f.getContentPane().add("Center", new JScrollPane(ta));
		f.getContentPane().add("South", p2);
		f.getContentPane().add("East", p_east);

		//f.setSize(500, 300);
		f.pack();
		f.setVisible(true);

		connTF.addActionListener(this);
		connB.addActionListener(this);
		sendTF.addActionListener(this);
		sendB.addActionListener(this);

		//  추가0: 대화명 바꾸기
		changeNameTF.addActionListener(this);
		changeNameB.addActionListener(this);
	}// 생성자 종료

	public void actionPerformed( ActionEvent e ) {
		Object o = e.getSource();

		if( o == connTF || o == connB ) {
			connProc();
		}

		else if( o == sendTF || o == sendB ) {
			sendProc();
		}

		else if( o == changeNameTF || o == changeNameB ) {
			changeNameProc();
		}
	} // actionPerformed ends


	void changeNameProc(){
		String nickname = "\name "+changeNameTF.getText()+"\n";
		
		try {
			out.write(nickname.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
			ta.setText("대화명변경 실패:"+e.toString());
		}
		JOptionPane.showMessageDialog(null, "대화명을 바꿉니다");
		
	}

	void connProc() {
		//		JOptionPane.showMessageDialog(null, "서버에 접속합니다");
		//사용자가 입력한 IP값 가져오기
		String ip=connTF.getText();

		try {
			s=new Socket(ip,1234);
			out =s.getOutputStream();
			in =new BufferedReader(new InputStreamReader(s.getInputStream()));
			//InputStreamReader : byte형을 char형 통로로 변환 해줘서 쓰겠다.
			
			new Thread(this).start();//Runnable을 구현하는 객체를 this 자리에 집어넣어야 한다.
		} catch (Exception e) {
			e.printStackTrace();
			ta.setText("접속실패:"+e.toString());
		}
	} // connProc ends


	public void run() {
		//읽어 와야 하는데 언제 읽어올래? 몰라 쓰레드로 반복 시켜주자 
		//접속하는 순간 부터
		while(s.isConnected()) {
			String msg=null;
			try {
				msg = in.readLine();
			} catch (IOException e) {
				ta.setText("읽기실패:"+e.toString());
			} // \n 전까지 읽고 싶어서 readLIne 사용
			ta.append(msg + "\n");
		}
	}


	void sendProc() {
		//		JOptionPane.showMessageDialog(null, "메세지를 전송합니다");
		String msg=sendTF.getText()+ "\n";//\n까지가 한문장이야 거기까지만 메세지 읽어줘
		//전송
		try {
			out.write(msg.getBytes());//msg가 String형이어서 통로는 BYte형으로 받아서 형변환 
		} catch (IOException e) {
			ta.setText("쓰기실패:"+e.toString());
		}
		//메세지 입력창 지우기
		sendTF.setText(null);
	}// sendProc ends



	public static void main(String [] args ) {
		new ChatClient();
	}


}// ChatClient ends





