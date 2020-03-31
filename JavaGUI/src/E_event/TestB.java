package E_event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import E_event.TestA.MyEvent;


public class TestB extends JFrame implements ActionListener{
	JButton b ;
	JTextField tf ;
	
	public TestB() {
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
	
	public void eventProc() {
		//2)이벤트 핸들러 객체생성
		//이미 메인에서  이벤트 핸들러가 된 클래스를 객체 생성함으로 이미 완료 됨
				
		//3)이벤트 연결
		//()안에 이벤트 핸들러 객체 넣어 줘야 하는데 내가 이벤트 핸들러 객체이니 자기자신객체를 지칭 
		b.addActionListener(this);//나 버튼클릭 할 때 이벤트 발생 시킬거야 
		tf.addActionListener(this);
	}
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
	public static void main(String[] args) {
		TestB testa = new TestB();
		testa.display();
		testa.eventProc();
		
	}

	
		


}
