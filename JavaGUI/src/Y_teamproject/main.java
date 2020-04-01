package Y_teamproject;

import java.awt.*;
import javax.swing.*;

public class main extends JFrame{
	//멤버변수 선언
	JButton a , b ,c;
	JButton total,cancel,order;
	JLabel price;
	JTextField fi;
	Mainmenu ma;
	Bob bo;
	Noodle nd;
	Drink dr;
	JList ls;
	String[]mu = {};
	String s="";

	main(){
		ma = new Mainmenu();
		bo = new Bob();
		nd = new Noodle();
		dr = new Drink();
		cancel =  new JButton("전체 취소");
		ls = new JList(mu);
		price = new JLabel("0원");
		total = new JButton("주문하기");
	}
	void display() {

		// 각 탭마다 해당 메뉴 부여
		JTabbedPane pane = new JTabbedPane();
		pane.add("추천메뉴", ma);
		pane.add("밥메뉴", bo);
		pane.add("면메뉴",nd);
		pane.add("음료",dr);

		//화면 출력
		setLayout(new BorderLayout());

		add(pane);
		//영역
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2=new JPanel(new GridLayout(2, 1));
		p2.add(new JLabel("주문목록"),BorderLayout.NORTH);
		p2.add(cancel, BorderLayout.NORTH);
		p1.add(p2,BorderLayout.NORTH);
		p1.add(ls, BorderLayout.CENTER);

		//SOUTH영역
		JPanel p = new JPanel(new GridLayout(1,2));
		p.add(price);
		p.add(total);
		p1.add(p, BorderLayout.SOUTH);
		add(p1,BorderLayout.EAST);

		setTitle("PC방 메뉴판");
		setSize(1000,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		main a = new main();
		a.display();
	}

}
