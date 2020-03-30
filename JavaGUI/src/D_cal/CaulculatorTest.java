package D_cal;

import java.awt.*;
import javax.swing.*;

public class CaulculatorTest extends JFrame {
	//1.멤버변수 선언
	JButton b[]=new JButton[15];
	JTextField tf;
	//2.객체 생성
	public CaulculatorTest() {
		
	tf=new JTextField();

	for(int i =0;i<9;i++) {
	b[i]=new JButton(String.valueOf(i+1));
}
	b[9]=new JButton("+");
	b[9].setToolTipText("더하기");
	b[10]=new JButton("0");
	b[11]=new JButton("=");
	b[11].setToolTipText("계산하기");
	b[12]=new JButton("-");
	b[12].setToolTipText("빼기");
	b[13]=new JButton("*");
	b[13].setToolTipText("곱하기");
	b[14]=new JButton("/");
	b[14].setToolTipText("나누기");
	}
	
	//3.화면 구성 및 출력하기
	public void display() {
		
		setLayout(new BorderLayout());
		add(tf,BorderLayout.NORTH);
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(5,3));
			for(int i=0; i<15;i++) {
				p.add(b[i]);
			}
		add(p,BorderLayout.CENTER);
		
				
		setLocation(100,200);
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		CaulculatorTest t = new CaulculatorTest();
		t.display();
	}

}
