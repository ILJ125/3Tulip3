package thread.basic;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ex4_CounterTest extends JFrame{
	private JPanel p1, p2;
	private JButton btn;
	private JTextArea ta;
	private JLabel lb;
	private boolean inputChk;

	public Ex4_CounterTest() {
		setTitle("단일 스레드 테스트!");
		//JFrame의 기본 레이아웃은 BorderLayout
		p1 = new JPanel();
		p1.add(btn = new JButton("Click"));
		p1.add(lb = new JLabel("Count!"));//추가 
		add(p1,BorderLayout.NORTH);

		p2 = new JPanel();       
		p2.add( ta = new JTextArea(20,50));
		add(p2);//기본값은 BorderLayout 중 센터 

		setBounds(200, 200, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 1- 카운트 다운을 시작하는 스레드 
				new Thread(new Runnable() {
					public void run() //런함수 overriding
					{
						for(int i=10;i>0;i--) {
							if(inputChk) {
								inputChk = false;
								lb.setText("빙고");
								//for문 벗어나고 run메소드도 벗어나고 싶음
								//제어권 완전 반환
								return;
							}

							lb.setText(String.valueOf(i));//카운트를 반복문으로 설정하고 라벨에 붙임
							try {
								Thread.sleep(1000);//1초마다 쉴래
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}).start();

				// 2- 입력값을 받아서 JTextArea에 붙이는 작업 
				new Thread(new Runnable() {
					public void run() {
						String msg =JOptionPane.showInputDialog("암호를 대세요");
						//textarea ta에 입력받은 String 가져다 붙임
						ta.append(msg +"입니다\n");
						//암호가 맞으면
						if(msg.contentEquals("love")) {
							inputChk=true; //true일 때 카운트 그만 하고 싶음
						}

					}
				}).start();





			}
		});
	}
	public static void main(String[] args) {
		new Ex4_CounterTest();
	}
}
