package Y_teamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class main extends JFrame {
	//멤버변수 선언
	int sum=0;
	int [] ran=new int[4];
	JButton [] menu = new JButton[16];
	JButton [] hot = new JButton[4];
	JButton  total, cancel, order;
	JLabel won;
	Mainmenu ma;
	Setmenu set;
	Bob bo;
	Noodle nd;
	Drink dr;
	JList ls;
	Vector vec= new Vector();
	HashMap <String, Integer> price = new HashMap <String, Integer>();
	int[]pr= {4500, 6000, 4500, 4500, 2500, 2500, 2500, 2500, 1200, 1200, 1200, 1200,3300,3000,5000,5000};
	String[]me = {"불고기덮밥","육회비빔밥","치킨마요덮밥","쭈꾸미덮밥","까르보 불닭볶음면","신라면","너구리","짜파게티","코카콜라","핫식스","코코팜","스프라이트","너구리 + sprite","신라면 + 콜라","치킨마요 +콜라","쭈꾸미덮밥+스프라이트"};
	ArrayList <JButton> list = new ArrayList<JButton>();
	main(){
		//객체 생성
		super("pc방");
		//랜덤 추천 메뉴 선정을 위한 랜덤숫자 지정
		HERE:
			for(int j=0;j<ran.length;) 
			{
				ran[j]=((int)(Math.random()*16));
				for(int k=0;k<j;k++) {
					if(ran[j]==(ran[k])) {
						continue HERE;
					}
				}
				j++;
			}
		//버튼에 이미지 입력 + 버튼 객체 생성
		for(int i=0; i<menu.length; i++) {
			menu[i]= new JButton(new ImageIcon("C:\\Users\\Canon\\git\\ilj125.github.com\\JavaGUI\\src\\Y_teamproject\\Imgs\\캡"+i+".PNG"));
			menu[i].setRolloverIcon (new ImageIcon("C:\\Users\\Canon\\git\\ilj125.github.com\\JavaGUI\\src\\Y_teamproject\\Imgs\\캡처"+i+".PNG"));
			setBackground(Color.WHITE);
		}

		for(int i=0;i<hot.length;i++) {
			hot[i] = new JButton(new ImageIcon("C:\\Users\\Canon\\git\\ilj125.github.com\\JavaGUI\\src\\Y_teamproject\\Imgs\\캡"+ran[i]+".PNG"));
			hot[i].setRolloverIcon(new ImageIcon("C:\\Users\\Canon\\git\\ilj125.github.com\\JavaGUI\\src\\Y_teamproject\\Imgs\\캡처"+ran[i]+".PNG"));
		}

		//각 텝 객체 생성



		ma = new Mainmenu(hot[0],hot[1],hot[2],hot[3]);
		set = new Setmenu(menu[12],menu[13],menu[14],menu[15]);
		bo = new Bob(menu[0],menu[1],menu[2],menu[3]);
		nd = new Noodle(menu[4],menu[5],menu[6],menu[7]);
		dr = new Drink(menu[8],menu[9],menu[10],menu[11]);
		//취소버튼, 리스트, 토탈 값 나오는 라벨, 주문하기 버튼 생성
		cancel =  new JButton("전체 취소");
		ls = new JList(vec);
		won = new JLabel("0원");
		order = new JButton("주문하기");

		//price라는 HashMap에 메뉴이름(me[])를 키로 가격이라는 value 추가
		for(int i=0;i<menu.length;i++) {
			price.put(me[i],pr[i]);
		}
	}
	void display() {
		// 각 탭마다 해당 메뉴 부여
		JTabbedPane pane = new JTabbedPane();
		pane.add("추천메뉴", ma);
		pane.add("세트메뉴",set);
		pane.add("밥메뉴", bo);
		pane.add("면메뉴",nd);
		pane.add("음료",dr);

		//화면 출력
		setLayout(new BorderLayout());
		//center에 탭화면 
		add(pane,BorderLayout.CENTER);

		//tap 외에 화면

		JPanel p1 = new JPanel(new BorderLayout());
		//주문목록이라는 라벨 + 전체 취소버튼 
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
	void deletePrice(String k) {
		sum = sum-(price.get(k)); 
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
		//랜덤 추천 메뉴 클릭시 이벤트
		for(int raw=0;raw<hot.length;raw++) {
			hot[raw].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					JButton evt =(JButton)e.getSource(); 
					for(int j=0;j<hot.length;j++) {
						if(evt==hot[j]) {
							vec.add(me[ran[j]]);
							ls.setListData(vec);
							totalPrice(ran[j]);
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
				sum=0;
				won.setText(String.valueOf(0)+"원");
			}
		});
		//order버튼을 눌렀을 때 예를 누르면 사라지고 아니오를 누르면 Data값이 남아있는다.
		order.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JButton evt = (JButton)e.getSource();
				int result = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?");
				if(result == JOptionPane.OK_OPTION) {
					//주문 정보 콘솔창에 출력
					for(int k=0;k<vec.size();k++) {
						System.out.println(vec.get(k));
					}
					System.out.println(won.getText());
					//정보 삭제
					vec.clear();
					ls.setListData(vec);
					sum=0;
					won.setText(String.valueOf(0)+"원");
				}
			}
		});
		//주문목록 중 선택한 메뉴 클릭시 삭제
		//MouseAdapter는 MouseListener를 다 구현해 놓은 클래스 입니다.
		ls.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?");
				if(result == JOptionPane.OK_OPTION) {
					//클릭한 리스트 목록의 index를 가져옴
					int dex=ls.getSelectedIndex();
					//가격에서도 그 삭제한 메뉴의 가격만큼 삭제
					deletePrice((String)ls.getSelectedValue());
					//ls(주문목록)에서 선택한 index위치에 정보 삭제
					vec.remove(dex);
					ls.setListData(vec);
				}
			}
		});
	}

	public static void main(String[] args) {
		main a = new main();
		a.display();
		a.eventProc();
	}

}
