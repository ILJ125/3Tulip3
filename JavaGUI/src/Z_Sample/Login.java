package Z_Sample;

import javax.swing.*;
import java.awt.*;
public class Login extends JFrame{
	//멤버 변수 선언
	JTextField tf[]=new JTextField[2];
	JButton bt;
	
	//생성자 함수
	public Login() {
		//객체 생성
		tf[0]=new JTextField(10);
		tf[1]=new JTextField(10);
		bt=new JButton("Login");
	}
	public void display() {
		//붙이기
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,2));
			p.add(new JLabel("ID"));
			p.add(tf[0]);
			p.add(new JLabel("Password"));
			p.add(tf[1]);
		add(p,BorderLayout.CENTER);
		
		add(bt,BorderLayout.EAST);
		//화면 만들기
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args)  {
		//클래스 안에 함수를 부르긴 위해서는 꼭 클래스 객체를 생성해줘야한다. 그래서 객체 생성이 1번
		Login login = new Login();
		
		login.display();

	}

}
