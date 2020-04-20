package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class MainView2 extends JPanel {
	int max = 20;// 최대 손님수

	JButton bcustom[] = new JButton[max];
	JLabel lcustom[] = new JLabel[max];
	JPanel pcustom[] = new JPanel[max];

	JButton bstart;// 버튼을 누른 시점을 기준으로 시간 계산
	JButton bend;// 시간 종료 후 요금 계산
	JButton bAddpoint;// 낚시로 낚은 물고기 이벤트로 포인트 지급
	JButton bUsepoint;// 포인트 사용

	JLabel lusingtime[] = new JLabel[max];

	int cus_index = 0;// 클릭한 버튼의 손님의 팔찌번호 가져오기 위해서
	long starttime[] = new long[max]; // 시작 시간
	long endtime[] = new long[max]; // 끝나는 시간
	long usingtime = 0;// 정확한 usingtime
	int usinghours = 0;
	int usingmin = 0;
	int usingsec = 0;
	int num = 0;// 팔찌 번호

	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

	public MainView2() {
		addLayout();
		eventProc();
	}

	// 화면설계 메소드
	public void addLayout() {
		// 멤버 변수 객체 생성
		for (int i = 0; i < bcustom.length; i++) {
			bcustom[i] = new JButton();
			lcustom[i] = new JLabel(String.valueOf(i + 1) + "번 손님");
			pcustom[i] = new JPanel();
			lusingtime[i] = new JLabel("이용시간");
		}
		bstart = new JButton("시작~");
		bend = new JButton("종료");
		bAddpoint = new JButton("포인트 추가");
		bUsepoint = new JButton("포인트 사용");

		// 화면 구성
		// 붙이기
		for (int i = 0; i < bcustom.length; i++) {
			lusingtime[i].setBorder(new EtchedBorder());
			pcustom[i].setLayout(new BorderLayout());
			pcustom[i].add(lcustom[i], BorderLayout.NORTH);
			pcustom[i].add(bcustom[i], BorderLayout.CENTER);
			pcustom[i].add(lusingtime[i], BorderLayout.SOUTH);
		}
		// 전체 구성
		setLayout(new GridLayout(4, 5));
		for (int i = 0; i < bcustom.length; i++) {
			add(pcustom[i]);
		}
	}

	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();
		for (int i = 0; i < bcustom.length; i++) {
			bcustom[i].addActionListener(new DialogActionListener());
		}

		bstart.addActionListener(btnHandler);
		bend.addActionListener(btnHandler);
		bAddpoint.addActionListener(new pointDialogActionListener());
//		bUsepoint.addActionListener(btnHandler);
	}

	// dialog이벤트
	public class DialogActionListener extends JDialog implements ActionListener {

		public DialogActionListener() {
			super();// JDialog 생성
		}

		private void CreateDialog() {

			setTitle(String.valueOf(cus_index + 1) + "번 손님");
			setSize(600, 600);
			// 붙이기
			setLayout(new GridLayout(4, 1));
			add(bstart);
			add(bend);
			add(bAddpoint);
			add(bUsepoint);

			setVisible(true);
		}

		// custom버튼 클릭시 이벤트
		public void actionPerformed(ActionEvent e) {

			JButton o = (JButton) e.getSource();

			for (int i = 0; i < bcustom.length; i++)
				if (o == bcustom[i]) {
					cus_index = i;
					CreateDialog();
				}
		}

	}

	// 버튼 이벤트
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			JButton ov = (JButton) ev.getSource();
			Thr_usingtime ut = new Thr_usingtime(cus_index);
			if (ov == bstart) {
				if (starttime[cus_index] == 0) {
					ut.start();
				}
				timeStart(); // 시간 시작-----------------------------------------------이부분 수정
			} else if (ov == bend) {
				timeEnd(); // 시간 종료
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

						if (time[index] < 60) {
							lusingtime[index].setText("이용시간 : " + String.valueOf(time[index]) + "초");
						} else if (time[index] < 3600) {
							lusingtime[index].setText("이용시간 : " + String.valueOf((int) (time[index] / 60)) + "분"
									+ String.valueOf(time[index] % 60) + "초");
						}
					} else if (endtime[index] != 0) {
						stop = false;
						endtime[index] = 0;
						lusingtime[index].setText("이용시간");
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
			System.out.println("종료시간" + str);
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

	// 물고기 이벤트3개
	public class pointDialogActionListener extends JDialog implements ActionListener {

		public pointDialogActionListener() {
			super();// JDialog 생성
		}

		private void CreatePointDialog() {

			setTitle(String.valueOf(cus_index + 1) + "번 손님 포인트 추가");
			setSize(1200, 800);
			// 붙이기
			setLayout(new GridLayout(1, 2));
			JPanel left =new JPanel();
			left.add(new JButton("1번"));
			add(left);
				
			
			setVisible(true);
		}

		public void actionPerformed(ActionEvent arg0) {
			JButton arg = (JButton) arg0.getSource();

			if (arg == bAddpoint) {
				CreatePointDialog();
			}

		}

	}
}