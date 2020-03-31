package E_event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class TestA extends JFrame{
	JButton b ;
	JTextField tf ;
	public TestA() {
		//객체 생성
		b= new JButton();
		tf=new JTextField(20);
		//붙이기
		setLayout(new FlowLayout());
		add(b);
		add(tf);
		
	}
	public void display(){
		//화면 출력
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//이벤트 관련된건 다 여기 쓸거야
	public void eventProc() {
		//2)이벤트 핸들러 객체생성
		MyEvent ehandler=new MyEvent();
		
		
		//3)이벤트 연결
		b.addActionListener(ehandler);//나 버튼클릭 할 때 이벤트 발생 시킬거야 
		tf.addActionListener(ehandler);
		
	}
	// (1) 이벤트 핸들러 //이벤트 연결만 하고 기다리다고 사용자가 이벤트 발생시키면 부름 
	class MyEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object evt =e.getSource(); //이벤트 발생한 객체 가져옴,Object로 받는다 왜냐하면 textfiled일 수도 있고 버튼 일수도 있으니
			if(evt == b) {
				//이벤트 발생된 버튼이 어느건지 알고 싶어서 
				String msg=b.getText();
				JOptionPane.showMessageDialog(null, msg+"이벤트발생b");	
			}else if(evt ==tf) {
				String msg = tf.getText();
			JOptionPane.showMessageDialog(null, msg+"를 입력하셨습니다.");//이벤트 발생 시 뜨는 메세지
			}
		}
		
		
	}

	public static void main(String[] args) {
		TestA testa = new TestA();
		testa.display();
		testa.eventProc();
	}

}
