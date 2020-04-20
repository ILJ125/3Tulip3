package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RecordView extends JFrame {
	JButton b;
	JTextField tf;
	
public RecordView() {
	TestC();
	display();
	eventProc();

	
}
	public void TestC() {
		//객체 생성
		b= new JButton();
		tf= new JTextField(50);
		//붙이기
		setLayout(new FlowLayout());
		add(b);
		add(tf);
	}

	public void display() {
		// 화면 출력
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 이벤트 관련된건 다 여기 쓸거야
	public void eventProc() {
		//(1) 이벤트 핸들러 
		//(2)이벤트 핸들러 객체생성
		//(3)이벤트 연결
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				Object evt =e.getSource(); //이벤트 발생한 객체 가져옴,Object로 받는다 왜냐하면 textfiled일 수도 있고 버튼 일수도 있으니
				String msg=b.getText();
				JOptionPane.showMessageDialog(null, msg+"이벤트발생b");	
			}
		});
		tf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				Object evt =e.getSource(); //이벤트 발생한 객체 가져옴,Object로 받는다 왜냐하면 textfiled일 수도 있고 버튼 일수도 있으니
				String msg=tf.getText();
				JOptionPane.showMessageDialog(null, msg+"라는 글자를 만듬");	
			}
		});

	}
	
}
