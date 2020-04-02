package Y_teamproject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class main extends JFrame {
	//멤버변수 선언
	int sum =0;
	JButton [] menu = new JButton[12];
	JButton  total, cancel, order;
	JLabel won;
	//	Mainmenu ma;
	Bob bo;
	Noodle nd;
	Drink dr;
	JList ls;
	Vector vec= new Vector();
	HashMap <JButton, Integer> price = new HashMap <JButton, Integer>();
	int[]pr= {4500, 6000, 4500, 4500, 2500, 2500, 2500, 2500, 1200, 1500, 1300, 1400};
	String[]me = {"불고기덮밥","육회비빔밥","치킨마요덮밥","쭈꾸미덮밥","까르보 불닭볶음면","신라면","너구리","짜파게티","코카콜라","핫식스","코코팜","스프라이트"};
	ArrayList <JButton> list = new ArrayList<JButton>();
	main(){
		super("pc방");
		//		ma = new Mainmenu();
		for(int i=0; i<menu.length; i++) {
			menu[i] = new JButton(new ImageIcon("src/pc_plus/Imgs/캡처"+i+".jpg"));
		}
		bo = new Bob(menu[0],menu[1],menu[2],menu[3]);
		nd = new Noodle(menu[4],menu[5],menu[6],menu[7]);
		dr = new Drink(menu[8],menu[9],menu[10],menu[11]);
		cancel =  new JButton("전체 취소");
		ls = new JList(vec);
		won = new JLabel("0원");
		order = new JButton("주문하기");
	}
	void display() {
		// 각 탭마다 해당 메뉴 부여
		JTabbedPane pane = new JTabbedPane();
		//		pane.add("추천메뉴", ma);
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
		p.add(won);
		p.add(order);
		p1.add(p, BorderLayout.SOUTH);
		add(p1,BorderLayout.EAST);

		//메뉴판 사이즈 설정
		setSize(1000,900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//주문 메뉴 총 가격 보여주기
	void totalPrice(int k) {
		sum +=pr[k];
		won.setText(String.valueOf(sum)+"원");
	}
	public void eventProc()
	{
		//(1) 이벤트 핸들러 
		//(2)이벤트 핸들러 객체생성
		//(3)이벤트 연결
		for(int i=0;i<menu.length;i++) {
			menu[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					JButton evt =(JButton)e.getSource(); 
					for(int j=0;j<menu.length;j++) {
						if(evt==menu[j]) {
							vec.add(me[j]);
							ls.setListData(vec);
							totalPrice(j);
						}
					}
				}
			});
		}
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				JButton evt =(JButton)e.getSource(); 
				vec.clear();
				ls.setListData(vec);
				System.out.println("전체취소");
				sum=0;
				won.setText(String.valueOf(0)+"원");
			}
		});


	}


	public static void main(String[] args) {
		main a = new main();
		a.display();
		a.eventProc();
	}

}
