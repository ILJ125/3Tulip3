package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.MainModel;

public class MainView extends JPanel {
	// 디자인
	int max = 20;// 최대 손님수
//cus_index => 손님 버튼 눌렀을 때이다.
//좌석 번호 눌렀을 때에 입력받을 값이 필요한가?--------------------------------------------------------??????
	JButton bcustom[] = new JButton[max + 1];// 고객 선택 할 때
	JButton bcon_seat[] = new JButton[max + 1];// dialog 한눈에 보기 에 좌석
	JLabel lcon_custom[] = new JLabel[max + 1];// 다이얼로그
	JPanel pcon_custom[] = new JPanel[max + 1];// 다이얼로그

	JButton bstart;// 버튼을 누른 시점을 기준으로 시간 계산
	JButton bend;// 시간 종료 후 요금 계산

	JButton bAddpoint;// 낚시로 낚은 물고기 이벤트로 포인트 지급
	JButton bUsepoint;// 포인트 사용

	JButton bconfirm;// 고객 상황 한눈에 보기

	JLabel lcon_usingtime[] = new JLabel[max + 1];
	JPanel peach[] = new JPanel[max + 1];// main
	int seat_index;
	int seat_num[] = new int[max + 1];
	int seat_cusnum[] = new int[max + 1];// 좌석에 손님 번호
	int cus_index = 0;// 클릭한 버튼의 손님의 팔찌번호 가져오기 위해서 //cus_index의 초기화 값 = -1
	long starttime[] = new long[max + 1]; // 시작 시간
	long endtime[] = new long[max + 1]; // 끝나는 시간
	long usingtime = 0;// 정확한 usingtime
	int usinghours = 0;
	int usingmin = 0;
	int usingsec = 0;
	int num = 0;// 팔찌 번호
	String[] Itemname = new String[max + 1];

//	static JPanel center_center = new JPanel();
//	{
//	 background=new ImageIcon(MainView.class.getResource("C:\\Users\\Canon\\git\\ilj125.github.com\\FishCafe\\src\\image\\fish.png")).getImage();} 
//	public void paint(Graphics g) 
//	{
//		//그리는 함수 
//		g.drawImage(background, 0, 0, null);//background를 그려줌
//	}

	// ITem
	JButton bItem[] = new JButton[max + 1];

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
		for (int i = 0; i <= max; i++) {
			// 메인
			bItem[i] = new JButton();
			bcon_seat[i] = new JButton();
			bcon_seat[i].setPreferredSize(new Dimension(230, 150));
			bcustom[i] = new JButton(i+"번 손님");
			bcustom[i].setBorder(new LineBorder(Color.BLACK, 1));
			lcon_custom[i] = new JLabel(i + "번 좌석");
			pcon_custom[i] = new JPanel();
			lcon_usingtime[i] = new JLabel("이용시간");
			lcon_usingtime[i].setFont(new Font("usingtime", Font.BOLD, 13));
			peach[i] = new JPanel();// 손님 마다에 패널
		}
		bItemOrder = new JButton(" 주문하기 ");
		bItemOrder.setPreferredSize(new Dimension(100, 50));

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
		for (int i = 1; i < bItem.length; i++) {
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

		for (int i = 1; i <= max; i++) {
			peach[i] = new JPanel(new BorderLayout());
			peach[i].add(new JLabel(i + "번"), BorderLayout.NORTH);
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
			bcon_seat[i].addActionListener(btnHandler);
		}
		bconfirm.addActionListener(btnHandler);
		bstart.addActionListener(btnHandler);
		bend.addActionListener(btnHandler);
////		bAddpoint.addActionListener(new pointDialogActionListener());
////		bUsepoint.addActionListener(btnHandler);
	}

	// 좌석 한눈에 보기
	public class confirmSeat extends JFrame implements ActionListener {

		public confirmSeat() {
			// 화면 구성
			// 붙이기
			for (int i = 1; i < bcustom.length; i++) {
				lcon_usingtime[i].setBorder(new EtchedBorder());
				pcon_custom[i].setLayout(new BorderLayout());
				pcon_custom[i].add(lcon_custom[i], BorderLayout.NORTH);
				pcon_custom[i].add(bcon_seat[i], BorderLayout.CENTER);
				pcon_custom[i].add(lcon_usingtime[i], BorderLayout.SOUTH);
			}
			// 전체 구성
			setLayout(new BorderLayout());
			JPanel north = new JPanel();
			north.setLayout(new BorderLayout());
			north.add(new JLabel(), BorderLayout.EAST);
			JPanel north_center = new JPanel();
			north_center.setLayout(new GridLayout(1, 7));
			for (int i = 1; i <= 7; i++) {
				north_center.add(pcon_custom[i]);
			}
			north.add(north_center, BorderLayout.CENTER);
			north.add(new JLabel(), BorderLayout.WEST);
			add(north, BorderLayout.NORTH);
			// 센터
			JPanel center = new JPanel();
			center.setLayout(new BorderLayout());
			JPanel center_west = new JPanel();
			center_west.setLayout(new GridLayout(3, 1));
			for (int i = 20; i >= 18; i--) {
				center_west.add(pcon_custom[i]);
			}
			center.add(center_west, BorderLayout.WEST);
			JPanel center_center = new JPanel();
			center_center.setLayout(new GridLayout(1, 1));
			center_center.setBackground(Color.BLUE);
			center_center.add(new JLabel());
			center.add(center_center, BorderLayout.CENTER);
			JPanel center_east = new JPanel();
			center_east.setLayout(new GridLayout(3, 1));
			for (int i = 8; i <= 10; i++) {
				center_east.add(pcon_custom[i]);
			}
			center.add(center_east, BorderLayout.EAST);
			add(center, BorderLayout.CENTER);

			// south
			JPanel south = new JPanel();
			south.setLayout(new BorderLayout());
			south.add(new JLabel(), BorderLayout.EAST);
			JPanel south_center = new JPanel();
			south_center.setLayout(new GridLayout(1, 7));
			for (int i = 17; i >= 11; i--) {
				south_center.add(pcon_custom[i]);
			}
			south.add(south_center, BorderLayout.CENTER);
			south.add(new JLabel(), BorderLayout.WEST);
			add(south, BorderLayout.SOUTH);

			setVisible(true);
			setSize(1920, 1080);
			setExtendedState(JFrame.MAXIMIZED_BOTH); // 프로그램 시작시 최대화
//			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("좌석 확인");

		}

		// custom버튼 클릭시 이벤트
		public void actionPerformed(ActionEvent e) {

			JButton o = (JButton) e.getSource();

		}
	}

	// 버튼 이벤트
	public class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JButton ov = (JButton) ev.getSource();
			Thr_usingtime ut = new Thr_usingtime(cus_index);

			if (ov == bstart) {
				if (cus_index == 0) {
					JOptionPane.showConfirmDialog(null, "팔찌 번호를 먼저 지정해주세요.");
				} else if (seat_num[cus_index] == 0) {
					JOptionPane.showConfirmDialog(null, cus_index + "번 손님께 지정된 좌석이 없습니다.좌석을 지정해주세요.");
					new confirmSeat();
				} else if (starttime[cus_index] != 0) {
					JOptionPane.showConfirmDialog(null, "이미 낚시를 진행중인 손님 입니다.");
				}
			} else if (ov == bend) {
				timeEnd();
			} else if (ov == bconfirm) {
				confirmSeat cs = new confirmSeat();
			} else {
				for (int i = 0; i <= max; i++) {

					if (bcustom[i] == ov) {
						bcustom[seat_cusnum[seat_index]].setBorder(new LineBorder(Color.BLACK, 1));
						bcustom[cus_index].setBorder(new LineBorder(Color.BLACK, 1));
						cus_index = i;
						bcustom[cus_index].setBorder(new LineBorder(Color.RED, 3));
						// 번호 누를때 원래 눌렀던 번호 없애기
					} else if (bcon_seat[i] == ov) {
						// 버튼 눌렀을 때 좌석 번호와 고객번호에 테두리가 바뀐다.
						bcon_seat[seat_index].setBorder(new LineBorder(Color.BLACK, 1));
//						bcustom[sea].setBorder(new LineBorder(Color.BLACK,1));
						seat_index = i;
						bcon_seat[seat_index].setBorder(new LineBorder(Color.YELLOW, 3));
						if (i == 0 | cus_index == 0) {
							JOptionPane.showConfirmDialog(null, "지정된 손님이 없습니다.");
						} else if (i != 0) {
							if (bcon_seat[i].getText() == "") {
								if (starttime[cus_index] == 0) {
									bcustom[cus_index].setBorder(new LineBorder(Color.BLACK, 1));
									int result = JOptionPane.showConfirmDialog(null, cus_index + "번 손님을 이자리에 지정하시겠습니까?",
											"자리지정", JOptionPane.YES_NO_OPTION);
									if (result == JOptionPane.YES_OPTION) {
										if (starttime[seat_cusnum[seat_index]] == 0) {
											// con_custom에 서 버튼 index는 좌석번호 =i이므로 seat_num[손님번호]= 손님의 좌석번호
											seat_cusnum[seat_index] = cus_index;// i에 좌석번호가 들어가면 seat_cusnum이 손님번호
											// 내가 선택한 버튼 index i (=좌석번호)를 cus_index에 줄게
											seat_num[cus_index] = seat_index;// seat_num[seat_cusnum[i]]=cus_index(좌석번호);
											// n번 손님의 좌석 번호 seat_num[n]=> seat_num[seat_cusnum[i]]=cus_index;
											// 함수 가져다 붙이기
											// ---------------------------------------------------------------------------------
											// 이용 시간이랑 팔찌번호만 가져와야겠다.
											// 테스트
//									System.out.println((seat_cusnum[seat_index]+1) + "번 손님 의 좌석 : " +(seat_index+1)+"번");
//									System.out.println((seat_num[seat_cusnum[seat_index]]+1)+"=>좌석 번호       "+(seat_cusnum[seat_index]+1) +"=>손님번호" );
											// 좌석 버튼에 손님 번호를 입력해줄거야
											bcon_seat[seat_index].setText(seat_cusnum[seat_index] + "번 손님 ");
											bcustom[cus_index].setBorder(new LineBorder(Color.RED, 3));
											// 다른 상황이 오면 위험하니깐
											if (starttime[cus_index] == 0) {
												ut.start();
											}
											timeStart();
										}
									}
								} else if (seat_num[cus_index] == 0) {
									JOptionPane.showConfirmDialog(null,
											(cus_index) + "번 손님은 게임은 진행 중이나 지정된 좌석이 없는 손님입니다.");
								} else if (seat_num[cus_index] != 0) {
									JOptionPane.showConfirmDialog(null, cus_index + "번 손님은 이미 지정된 좌석이 있습니다.");
								}

							} else {
								bcustom[cus_index].setBorder(new LineBorder(Color.BLACK, 1));
								bcustom[seat_cusnum[seat_index]].setBorder(new LineBorder(Color.RED, 3));

							}
						}
					}

				}
			}
		}
	}

	public class Thr_usingtime extends Thread {
		long time[] = new long[max + 1];
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
						lcon_usingtime[seat_num[index]].setText(hours + "시" + min + "분" + sec + "초");
					} else if (endtime[index] != 0) {
						lcon_usingtime[seat_num[index]].setText("이용시간");
						endtime[index] = 0;
						stop = false;

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
			bcon_seat[seat_num[cus_index]].setText("");
			seat_cusnum[seat_num[cus_index]] = 0;
			seat_num[cus_index] = 0;
		}
	}
}
//	}
//	public void getItemname() throws Exception {
//		MainModel mm= new MainModel();
//		
//	Itemname = mm.itemname();
//	}
