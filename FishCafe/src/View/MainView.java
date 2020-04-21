package View;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MainView extends JPanel {
	
	//디자인
	int max = 20;// 최대 손님수

	JButton bcustom[] = new JButton[max];// 고객 선택 할 때
	JButton bcon_custom[] = new JButton[max];// dialog 한눈에 보기 에 좌석
	JLabel lcon_custom[] = new JLabel[max];//다이얼로그
	JPanel pcon_custom[] = new JPanel[max];//다이얼로그

	JButton bstart;// 버튼을 누른 시점을 기준으로 시간 계산
	JButton bend;// 시간 종료 후 요금 계산

	JButton bAddpoint;// 낚시로 낚은 물고기 이벤트로 포인트 지급
	JButton bUsepoint;// 포인트 사용

	JButton bconfirm;// 고객 상황 한눈에 보기

	JLabel lcon_usingtime[] = new JLabel[max];
	JPanel peach[] = new JPanel[max];//main

	int cus_index = 0;// 클릭한 버튼의 손님의 팔찌번호 가져오기 위해서
	long starttime[] = new long[max]; // 시작 시간
	long endtime[] = new long[max]; // 끝나는 시간
	long usingtime = 0;// 정확한 usingtime
	int usinghours = 0;
	int usingmin = 0;
	int usingsec = 0;
	int num = 0;// 팔찌 번호

	// ITem
	JButton bItem[] = new JButton[20];

	JList liItemOrder;
	Vector vecItem = new Vector();

	JButton bItemOrder, bItemDelete;
	JLabel won;

	int sum = 0;

	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

	public MainView() {
		make();
		addLayout();
		eventProc();
	}

	// 객체생성
	public void make() {
		for (int i = 0; i < max; i++) {
			// 메인
			bItem[i] = new JButton();
			bcon_custom[i] = new JButton();
			bcustom[i] = new JButton();
			lcon_custom[i] = new JLabel(String.valueOf(i + 1) + "번 손님");
			pcon_custom[i] = new JPanel();
			lcon_usingtime[i] = new JLabel("이용시간");
			lcon_usingtime[i].setFont(new Font("usingtime",Font.BOLD,13));
			peach[i] = new JPanel();// 손님 마다에 패널
		}
		bItemOrder = new JButton(" 주문하기 ");
		bItemOrder.setPreferredSize(new Dimension(200, 50));

		bItemDelete = new JButton("전체삭제");
		bItemDelete.setPreferredSize(new Dimension(100, 40));
		// 라벨 주문목록, 요금, 원 / 버튼 주문하기 , 전체삭제
		won = new JLabel("0원");
		// 리스트
		liItemOrder = new JList(vecItem);
		// 20개의 메뉴버튼 배열

		bstart = new JButton("시작");
		bstart.setPreferredSize(new Dimension(100, 100));
		bend = new JButton("종료");
		bAddpoint = new JButton("포인트 추가");
		bUsepoint = new JButton("포인트 사용");
		bconfirm = new JButton("좌석확인");
	}

	// 화면설계 메소드
	public void addLayout() {
		setLayout(new BorderLayout());

		// C-1.Center - 상품이랑, 좌석
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2));
		// C-2-1 center_left
		JPanel center_left = new JPanel();
		center_left.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < bItem.length; i++) {
			center_left.add(bItem[i]);
		}

		center.add(center_left);
		// C-2-2.center_right----------------------------
		JPanel center_right = new JPanel();
		center_right.setLayout(new BorderLayout());
		// C-3-1.고객 번호들 c_r_center
		JPanel c_right_center = new JPanel();
		c_right_center.setLayout(new GridLayout(5, 4));
		// C-4-1.가각

		for (int i = 0; i < max; i++) {
			peach[i] = new JPanel(new BorderLayout());
			peach[i].add(new JLabel(String.valueOf(i + 1) + "번"), BorderLayout.NORTH);
			peach[i].add(bcustom[i], BorderLayout.CENTER);
			c_right_center.add(peach[i]);
		}
		// C-3-1 붙임
		center_right.add(c_right_center, BorderLayout.CENTER);
		// C-3-2.c_r_south버튼 들 - 좌석확인, 시작,종료
		JPanel c_right_south = new JPanel();
		c_right_south.setLayout(new GridLayout(2, 1));
		c_right_south.add(bconfirm);
		// C-4-2.start-end
		JPanel start_end = new JPanel();
		start_end.setLayout(new GridLayout(1, 2));
		start_end.add(bstart);
		start_end.add(bend);
		// C-4.붙임
		c_right_south.add(start_end);
		// C-3-2.붙임
		center_right.add(c_right_south, BorderLayout.SOUTH);
		// C-2-2.붙임---------------------------------------------
		center.add(center_right);
		// E.east계산---------------------------------------
		JPanel east = new JPanel();
		// E-2-1오른쪽 위
		// JLabel 주문목록 , 전체삭제 버튼 grid(2,1)
		JPanel east_up = new JPanel();
		east_up.setLayout(new GridLayout(2, 1));
		east_up.add(new JLabel("주문목록"));
		east_up.add(bItemDelete);

		// E-2-2오른쪽 중앙
		east.add(liItemOrder, BorderLayout.CENTER);
		// E-2-3오른쪽 아래
		JPanel east_down = new JPanel(new GridLayout(2, 1));
		east_down.add(bItemOrder);
		JPanel e_d_down = new JPanel(new BorderLayout());
		e_d_down.add(new JLabel("금액  "), BorderLayout.WEST);
		e_d_down.add(won, BorderLayout.CENTER);
		east_down.add(e_d_down);

		// 붙이기--------------------------------------
		east.setLayout(new BorderLayout());
		east.add(east_up, BorderLayout.NORTH);
		east.add(east_down, BorderLayout.SOUTH);

		// 1.붙임
		add(center, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
	}

	// 버튼에 eventHandler 부여
	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();
		for (int i = 0; i < bcustom.length; i++) {
			bcustom[i].addActionListener(btnHandler);
			bcon_custom[i].addActionListener(btnHandler);
		}
		bconfirm.addActionListener(new DialogActionListener());
		bstart.addActionListener(btnHandler);
		bend.addActionListener(btnHandler);
////		bAddpoint.addActionListener(new pointDialogActionListener());
////		bUsepoint.addActionListener(btnHandler);
	}

	// 좌석 한눈에 보기
	public class DialogActionListener extends JDialog implements ActionListener {

		public DialogActionListener() {
			super();// JDialog 생성
		}

		private void CreateDialog() {

			setTitle(String.valueOf("한 눈에 보기"));
			// 화면 구성
			// 붙이기
			for (int i = 0; i < bcustom.length; i++) {
				lcon_usingtime[i].setBorder(new EtchedBorder());
				pcon_custom[i].setLayout(new BorderLayout());
				pcon_custom[i].add(lcon_custom[i], BorderLayout.NORTH);
				pcon_custom[i].add(bcon_custom[i], BorderLayout.CENTER);
				pcon_custom[i].add(lcon_usingtime[i], BorderLayout.SOUTH);
			}
			// 전체 구성
			setLayout(new GridLayout(4, 5));
			for (int i = 0; i < bcustom.length; i++) {
				add(pcon_custom[i]);
			}
			setVisible(true);
			setSize(1000, 800);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

		// custom버튼 클릭시 이벤트
		public void actionPerformed(ActionEvent e) {

			JButton o = (JButton) e.getSource();

			if (o == bconfirm) {
				CreateDialog();
			}

		}
	}

	// 버튼 이벤트
	public class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JButton ov = (JButton) ev.getSource();
			Thr_usingtime ut = new Thr_usingtime(cus_index);

			if (ov == bstart) {
				if (starttime[cus_index] == 0) {
					ut.start();
				}
				timeStart();
			} else if (ov == bend) {
				timeEnd();
			} else {
				for (int i = 0; i < max; i++) {
					if (bcustom[i] == ov) {
						BorderSetting(i);
					}else if(bcon_custom[i]== ov) {
						BorderSetting(i);
						System.out.println(cus_index);
					}
				

				}
			}
		}
	}

	public class Thr_usingtime extends Thread {
		long time[] = new long[max];
		int index = 0;

		boolean stop = true;

		Thr_usingtime(int index) {
			this.index = index;//
		}

		public void run() {
			do {
				try {
					if (endtime[index] == 0) {
						Thread.sleep(1000);
						time[index] += 1;

						String sec = String.valueOf(time[index] % (60 * 60) % 60);
						String min = String.valueOf(time[index] % (60 * 60) / 60);
						String hours = String.valueOf(time[index] / (60 * 60));
						lcon_usingtime[index].setText(hours + "시" + min + "분" + sec + "초");
					} else if (endtime[index] != 0) {
						stop = false;
						endtime[index] = 0;
						lcon_usingtime[index].setText("이용시간");
						return;
					}

				} catch (InterruptedException e) {

					System.out.println("오류");
				}
			} while (stop);
			stop = true;
		}
	}

	// 시간 시작
	public void timeStart() {
		if (starttime[cus_index] == 0) {
			starttime[cus_index] = System.currentTimeMillis();
			String str = dayTime.format(starttime[cus_index]);
			System.out.println("시작 시간 : " + str);

		} else {
			JOptionPane.showMessageDialog(null, "이미 낚시 진행중인 손님입니다.");
			System.out.println(starttime[cus_index]);
		}
	}

	// 시간 종료
	public void timeEnd() {
		if (starttime[cus_index] == 0) {
			JOptionPane.showMessageDialog(null, "아직 손님이 지정되지 않은 팔찌 번호입니다.");
		} else {
			// 종료시간
			endtime[cus_index] = System.currentTimeMillis();
			String str = dayTime.format(endtime[cus_index]);
			// 종료시간 출력
			System.out.println("종료시간 : " + str);
			// 이용시간
			usingtime = (endtime[cus_index] - starttime[cus_index]);
			// 이용시간 테스트
			usinghours = (int) usingtime / (1000 * 60 * 60);
			usingmin = (int) usingtime / (1000 * 60) - (usinghours * 60);
			usingsec = ((int) usingtime % (1000 * 60)) / 1000;
			// 이용시간 출력
			System.out.println(usinghours + "시간 " + usingmin + "분 " + usingsec + "초");
			// 초기화
			// endtime 초기화는 Thread문에서 할게용~
			starttime[cus_index] = 0;
			usingtime = 0;
			usinghours = 0;
			usingmin = 0;
			usingsec = 0;
		}
	}
	//버튼 클릭시 테두리 선택 (고객 버전)
	public void BorderSetting (int i) {
		pcon_custom[cus_index].setBorder(null);
		peach[cus_index].setBorder(null);//다른 버튼 클릭하면 원래대로
		cus_index = i;
		peach[cus_index].setBorder(new LineBorder(Color.CYAN, 3));
		pcon_custom[cus_index].setBorder(new LineBorder(Color.CYAN, 3));
	}
}