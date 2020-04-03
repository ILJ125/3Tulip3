package thread.basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex4_ZBombTest extends JFrame{
	private JPanel p1,p2;
	private JButton btn;
	private JLabel lb, image;
	private boolean inputChk;

	Ex4_ZBombTest(){
		setTitle("폭탄 테스트!");
		p1 = new JPanel();
		p1.add(btn = new JButton("시작")); 
		p1.add(lb = new JLabel("카운트다운")); 
		add(p1,"North");
		p2 = new JPanel();
		p2.add(image = new JLabel(new ImageIcon("src\\thread\\basic\\imgs\\bomb_1.jpg")));

		add(p2, "Center");
		setBounds(200, 200, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 1- 카운트 다운을 시작하는 스레드 
				new Thread(new Runnable() {
					public void run() {
						for(int i=15;i>=0;i--) {
							if(inputChk) {
								inputChk = false;
								lb.setText("빙고");
								image.setIcon(new ImageIcon("src\\thread\\basic\\imgs\\bomb_3.jpg"));
								//for문 벗어나고 run메소드도 벗어나고 싶음
								//제어권 완전 반환
								return;
							}
							lb.setText(String.valueOf(i));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						image.setIcon(new ImageIcon("src\\thread\\basic\\imgs\\bomb_2.jpg"));
					}
				}).start();

				// 2- 암호값을 입력받기
				new Thread(new Runnable() {
					public void run() {
						String msg=JOptionPane.showInputDialog("암호를 입력하라");
						do {
						if(msg.equals("love")) {
							inputChk=true;
						}
						else {
							msg=JOptionPane.showInputDialog("암호가 틀렸습니다. 다시 입력해주세요");
							inputChk=false;
						}
						}while(inputChk!=true);
					}
					
				}).start();
				


			}
		});
	}

	public static void main(String[] args) {
		new Ex4_ZBombTest();
	}
}
