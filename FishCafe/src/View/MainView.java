package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class MainView extends JPanel {
	int max = 20;

	JButton custom[] = new JButton[max];
	
	JDialog dialog[] = new JDialog[max];
	JButton start;
	JButton end;
	JButton event;
	public MainView() {
		addLayout();
		eventProc();
	}

	// 화면설계 메소드
	public void addLayout() {

		// 멤버 변수 객체 생성
		for (int i = 0; i < custom.length; i++) {
			custom[i] = new JButton();
			dialog[i] = new JDialog();
		}
		// 화면 구성

		// 붙이기

		// 전체 구성
		setLayout(new GridLayout(4, 5));
		for (int i = 0; i < custom.length; i++) {
			add(custom[i]);
		}
	}

	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();
		for(int i=0;i<custom.length;i++) {
			custom[i].addActionListener(btnHandler);
		}
		start.addActionListener(btnHandler);
		end.addActionListener(btnHandler);
		event.addActionListener(btnHandler);
		
		
	}

	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton o = (JButton) e.getSource();

			for (int i = 0; i < custom.length; i++) {
				if (o == custom[i]) {
					//다이어로그로 창 만들기
					dialog[i].setTitle((i+1)+"번 손님");
					//창만들어서 버튼 3개 뜨게 하기 시작,종료,이벤트
					//버튼 객체 생성
					start=new JButton("시작");
					end = new JButton("종료");
					event = new JButton("이번트");
					//붙이기
					dialog[i].setLayout(new GridLayout(3,1));
					dialog[i].add(start);
					dialog[i].add(end);
					dialog[i].add(event);
					
					dialog[i].setSize(600,600);
					dialog[i].setVisible(true);
				}
				else if(o==start) {
					
				}else if(o==end) {
					
				}else if(o==event) {
					
				}
			}
		}
	}

}
