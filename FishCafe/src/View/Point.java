package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Point extends JFrame implements Runnable {
	JTextField tf_pnum[] = new JTextField[20];
	JButton bnumber[] = new JButton[12];
	JButton badd = new JButton("추가");
//	JButton buse = new JButton("사용");
	int max = 0;
	int index = 0;


	public Point() {
		super();
		
	}

	public void addPoint(int index) {
		this.index=index;
		for (int i = 0; i < bnumber.length; i++) {
			bnumber[i] = new JButton(String.valueOf(i + 1));
			tf_pnum[i] = new JTextField();
		}
		bnumber[9].setText("0");
		bnumber[10].setText("00");
		bnumber[11].setText("000");
		// 폰트
		Font f = new Font("돋움", Font.PLAIN, 25);
		tf_pnum[index].setFont(f);// 폰트 적용

		// 화면 구성
		setLayout(new BorderLayout());
		add(tf_pnum[index], BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 3));
		for (int i = 0; i < bnumber.length; i++) {
			center.add(bnumber[i]);
		}

		add(center, BorderLayout.CENTER);

		badd.setPreferredSize(new Dimension(600, 70));
		add(badd, BorderLayout.SOUTH);

		setVisible(true);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("포인트 적립");
		
	}

//	public void usePoint(int index) {
//		setLayout(new BorderLayout());
//
//		JPanel east = new JPanel();
//		add(east, BorderLayout.CENTER);
//		buse.setPreferredSize(new Dimension(600, 70));
//		add(buse, BorderLayout.SOUTH);
//
//		setVisible(true);
//		setSize(600, 500);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setTitle("포인트 사용");
//
//	}

	public void peventProc() {
		ButtonEventHandler handler = new ButtonEventHandler();

		for (int i = 0; i < bnumber.length; i++) {
			bnumber[i].addActionListener(handler);
		}
		badd.addActionListener(handler);
//		buse.addActionListener(handler);
	}

	class ButtonEventHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton ev = (JButton) e.getSource();

			for (int i = 0; i < bnumber.length; i++) {
				if (ev == bnumber[i]) {
					String original = tf_pnum[0].getText();
					original += bnumber[i].getText();
					tf_pnum[0].setText(original);
				} else if (ev == badd) {
					// 데이터 베이스에 customer에 포인트를 입력해준다.
					tf_pnum[0].setText("");

				}

			}

		}

	}

	public void run() {
		addPoint(index);
		peventProc();
	}
}
