package D_cal;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CaulculatorTest extends JFrame implements ActionListener{
	//1.멤버변수 선언
	int num1=0;int num2=0;String operator="";
	JButton b[]=new JButton[15];
	JButton reset;
	JTextField tf;
	//2.객체 생성
	public CaulculatorTest() {

		tf=new JTextField();
		reset=new JButton();
		for(int i =0;i<10;i++) {
			b[i]=new JButton(String.valueOf(i));
		}
		b[10]=new JButton("+");
		b[10].setToolTipText("더하기");
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
		JPanel p2 = new JPanel();
			p2.setLayout(new GridLayout(1,2));
			p2.add(tf);
			p2.add(reset);
		add(p2,BorderLayout.NORTH);
		JPanel p = new JPanel();
			p.setLayout(new GridLayout(5,3));
			for(int i=1; i<11;i++) {
				p.add(b[i]);
			}
			p.add(b[0]);
			for(int i=11;i<15;i++) { 
				p.add(b[i]);
			}
		add(p,BorderLayout.CENTER);
		setLocation(100,200);
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void Eventproc() {
		for(int i=0;i<b.length;i++) {
			b[i].addActionListener(this);
		}
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton evt=(JButton)e.getSource();
		for(int i=0;i<10;i++) {
			if(evt==b[i]) {
				String su=tf.getText();
				su +=b[i].getText();
				tf.setText(su);
			}
		}
		//연산자가 눌러졌을 때
		if(evt==b[10]) {
				num1=Integer.parseInt(tf.getText());
				operator="+";
				tf.setText(null);
				
			} else if(evt==b[11]) {
				//'='
				num2=Integer.parseInt(tf.getText());
				if(operator=="") {
					tf.setText(String.valueOf(num2));
				}else if(operator=="+") {
					
					tf.setText(String.valueOf(num1+num2));
				}else if(operator=="-") {
					
					tf.setText(String.valueOf(num1-num2));
					
				}else if(operator=="*") {
					
					tf.setText(String.valueOf(num1*num2));
					
				}else if(operator=="/") {
					
					tf.setText(String.valueOf((double)num1/num2));
					
				}
				
			} else if(evt==b[12]) {
				num1=Integer.parseInt(tf.getText());
				operator="-";
				tf.setText(null);
			} else if(evt==b[13]) {
				num1=Integer.parseInt(tf.getText());
				operator="*";
				tf.setText(null);
			} else if(evt==b[14]) {
				num1=Integer.parseInt(tf.getText());
				operator="/";
				tf.setText(null);
			}else if(evt==reset) {
				tf.setText(null);
				operator="";
			}
		System.out.println(num1 +" di "+num2);
		}

	
	public static void main(String[] args) {
		CaulculatorTest t = new CaulculatorTest();
		t.display();
		t.Eventproc();
	}



}
