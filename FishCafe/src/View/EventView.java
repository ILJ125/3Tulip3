package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.EventModel;

public class EventView extends JPanel {
	JTextField tfinput; // 포인트 입력
	JButton[] bnum = new JButton[11];// 자판
	JButton bcancel;

	JButton baddpoint;// 포인트 적립 버튼
	JButton busepoint;// 사용 버튼

	JTextField tfcusnum;// 팔찌번호 =입력, enter 치면 입력

	JTable tbevtspecial;// special물고기 이벤트 |물고기 종류, 포인트,
	TableDataSpeciallst special;// 테이블 데이터

	JButton btevttail;// 꼬리뼈 이벤트

	JCheckBox ceditable; // 편집 가능
	JTextField tfevtabout;// 근삿값
	JButton bfirst;
	JButton bsecond;
	JButton bthird;

	//디자인
	Font basic = new Font("돋움", Font.PLAIN, 30);
	
	//모델
	EventModel eventmodel ;

	
	// 생성자 함수
	public EventView() {
		make();
		fishArray();
		addLayout();
		eventProc();
		
	}

	// 객체생성
	public void make() {
		for (int i = 0; i < bnum.length; i++) {
			bnum[i] = new JButton(String.valueOf(i));// 자판
			bnum[i].setFont(new Font("돋움", Font.PLAIN, 20));
		}
		
		//모델 객체 생성
		try {
			eventmodel =new EventModel();
		} catch (Exception e) {
			e.printStackTrace();
		}
		bnum[10].setText("00");
		bnum[10].setFont(basic);

		bcancel = new JButton("취소");
		bcancel.setFont(basic);
		tfinput = new JTextField();
		tfinput.setFont(basic);// 포인트 입력

		baddpoint = new JButton("추가");// 포인트 적립 버튼
		baddpoint.setPreferredSize(new Dimension(50, 80));
		baddpoint.setFont(basic);
		busepoint = new JButton("사용");// 사용 버튼
		busepoint.setPreferredSize(new Dimension(50, 80));
		busepoint.setFont(basic);

		tfcusnum = new JTextField();// 팔찌번호 =입력, enter 치면 입력
		tfcusnum.setPreferredSize(new Dimension(50, 80));
		tfcusnum.setFont(basic);
		tbevtspecial = new JTable(special);
		tbevtspecial.setFont(new Font("tbevtspecial", Font.BOLD, 25));// special물고기 이벤트 |물고기 종류, 포인트,
		tbevtspecial.setRowHeight(25);
		special = new TableDataSpeciallst();// 테이블 데이터

		btevttail = new JButton("꼬리뼈 포인트");
		btevttail.setFont(basic);// 꼬리뼈 이벤트
		btevttail.setPreferredSize(new Dimension(50, 80));

		ceditable = new JCheckBox(); // 편집 가능

		tfevtabout = new JTextField("123");
		;// 근삿값
		tfevtabout.setPreferredSize(new Dimension(80, 80));
		tfevtabout.setFont(basic);
		tfevtabout.setEditable(false);
		bfirst = new JButton("1등");
		bfirst.setFont(basic);
		bsecond = new JButton("2등");
		bsecond.setFont(basic);
		bthird = new JButton("3등");
		bthird.setFont(basic);

	}

	// 화면 구성
	public void addLayout() {
		// 전체 GridLayout 으로 1행 2열
		setLayout(new GridLayout(1, 2));
		// 왼쪽 영역
		JPanel left = new JPanel(new BorderLayout());
		// 왼쪽 위 -자판
		JPanel left_center = new JPanel(new BorderLayout());
		left_center.add(tfinput, BorderLayout.NORTH);
		// 자판
		JPanel left_c_tf = new JPanel(new GridLayout(1, 1));
		left_c_tf.add(tfcusnum);
		JPanel left_c_board = new JPanel(new GridLayout(4, 3));
		for (int i = 1; i < bnum.length; i++) {
			left_c_board.add(bnum[i]);
		}
		left_c_board.add(bnum[0]);
		left_c_board.add(bnum[10]);
		left_c_board.add(bcancel);
		// 왼쪽 south -버튼 두개
		JPanel left_south = new JPanel(new GridLayout(1, 2));
		left_south.add(baddpoint);
		left_south.add(busepoint);
		// 오른쪽 영역
		JPanel right = new JPanel(new BorderLayout());
		// 북- 팔찌 번호
		JPanel right_north = new JPanel(new BorderLayout());
		right_north.add(new JLabel("팔찌 번호"), BorderLayout.WEST);
		right_north.add(tfcusnum, BorderLayout.CENTER);
		// 중심 - 특수물고기(중심),근삿값(south)
		JPanel right_center = new JPanel(new BorderLayout());
		right_center.add(new JScrollPane(tbevtspecial), BorderLayout.CENTER);
		JPanel right_about = new JPanel(new BorderLayout());
		right_about.add(ceditable, BorderLayout.WEST);
		JPanel right_about_exch = new JPanel(new GridLayout(1, 4));
		right_about_exch.add(tfevtabout);
		right_about_exch.add(bfirst);
		right_about_exch.add(bsecond);
		right_about_exch.add(bthird);
		// 남 - 꼬리고리
		right.add(btevttail, BorderLayout.SOUTH);
		// 붙이기
		// 왼쪽 영역
		left_center.add(left_c_board, BorderLayout.CENTER);
		left_center.add(left_c_tf, BorderLayout.SOUTH);

		left.add(left_center, BorderLayout.CENTER);
		left.add(left_south, BorderLayout.SOUTH);
		add(left);
		// 오른쪽 영역
		right_about.add(right_about_exch, BorderLayout.CENTER);
		right_center.add(right_about, BorderLayout.SOUTH);// 꼬리고리
		right.add(right_north, BorderLayout.NORTH);// 팔찌번호
		right.add(right_center, BorderLayout.CENTER);// 특수물고기,근삿값
		add(right);

	}

	//테이블 데이터 지정 
	public void fishArray() {
		//1. fish 테이블에서 포인트를 가져온다 /type 별로 /2중배열로 가져와서 바로 붙이자 
		ArrayList fishdata = new ArrayList();
		try {
			fishdata=eventmodel.loaddata();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		special.arrspecial = fishdata;
		tbevtspecial.setModel(special);// 혹시모르니 Jtable에 다시 myTM 갔다 붙이기
		special.fireTableDataChanged();

	}

	// 테이블 데이터 관리
	class TableDataSpeciallst extends AbstractTableModel {
		String[] columnName = { "종류", "포인트" };
		ArrayList arrspecial = new ArrayList();

		public int getColumnCount() {
			// 행의 갯수 가져오는 함수
			return columnName.length;
		}

		public int getRowCount() {
			// 열의 갯수를 가져오는 함수
			return arrspecial.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// row행,column열에 있는 데이터 가져오는 함수

			ArrayList temp = (ArrayList) arrspecial.get(rowIndex);// rowIndex행의 데이터 전부 가져오기
			return temp.get(columnIndex);// temp는 rowIndex 행의 전부 중 columnIndex열의 데이터를가져옴
		}

		public String getColumnName(int c) {
			// 함수중에서 컬럼 이름 정하는 함수가 있는데 내가 지정한 컬럼네임을 가져다 쓰고 싶어서
			// 오버라이딩 합니다.
			return columnName[c];
		}

		public boolean isCellEditable(int row, int col) {
			// true이면 편집모드 false면 노 편집모드
			return false;
		}

	}


	public void eventProc() {
		btnEventHandler btnevt = new btnEventHandler();
		for(int i=0;i<bnum.length;i++) {
		bnum[i].addActionListener(btnevt);
		}
		bcancel.addActionListener(btnevt);
		
		
		baddpoint.addActionListener(btnevt);
		busepoint.addActionListener(btnevt);
		
		btevttail.addActionListener(btnevt);

		
		bfirst.addActionListener(btnevt);
		bsecond .addActionListener(btnevt);
		bthird .addActionListener(btnevt);
		
		ceditable.addActionListener(new chckEventHandler());
		
		tbevtspecial.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tbevtspecial.getSelectedRow();
				btninputPoint(String.valueOf(special.getValueAt(row,1)));
			}
			});
	}
	//모든 버튼 액션리스너
	public class btnEventHandler implements  ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton evt = (JButton)e.getSource();
			
			for(int i=0;i<bnum.length;i++) {
				if(evt==bnum[i]) {
					boardinputPoint(bnum[i].getText());
				}
			}
			//포인트 추가 버튼 
			if(evt==baddpoint) {
				if(tfcusnum.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "팔찌번호를 다시확인해주세요.","오류",JOptionPane.OK_OPTION);
				}else if (Integer.parseInt(tfcusnum.getText())>20) {
					JOptionPane.showConfirmDialog(null, "팔찌번호를 다시확인해주세요.","오류",JOptionPane.OK_OPTION);
				}else {
				int client=Integer.parseInt(tfcusnum.getText());
				int num=1;
				int totalpoint = Integer.parseInt(tfinput.getText());
				//업데이트 포인트를 추가해서 올린다.
				try {
					eventmodel.updatePoint(num,totalpoint,client);
				} catch (Exception e1) {
					JOptionPane.showConfirmDialog(null, "포인트 수정을 실패했습니다.");
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(null, "성공적으로 포인트가 수정되었습니다.","성공",JOptionPane.YES_OPTION);   
				}
				
			}
			else if(evt==busepoint) {
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 더 빼서 update
			}
			else if(evt==bcancel) {
				//tfinput 창을 지우기
				tfinput.setText("");
			}else if (evt==bfirst) {
				//근삿값 보다 -10~+10 일때
				btninputPoint(String.valueOf(30000));
			}else if (evt==bsecond) {
				//근삿값 보다 -100~+100일 때
				btninputPoint(String.valueOf(20000));
			}else if (evt==bthird) {
				//근삿값 보다 -300~+300일 때
				btninputPoint(String.valueOf(10000));
			}else if (evt==btevttail) {
				//꼬릿표 있으면 +500
				if(tfinput.equals(""))
				tfinput.setText("0");
				btninputPoint(String.valueOf(500));
			}
		}

		
	}
	
	
	
	//checkbox 액션 리스너
	public class chckEventHandler implements  ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		tfevtabout.setEditable(ceditable.isSelected());
			
		}
		
	}
	//tfinput textfield 보드버튼
	public void boardinputPoint(String text) {
		//숫자보드에서 숫자를 눌렀을 때에 이벤트
		String original=tfinput.getText();
		tfinput.setText(original+text);
	}
	
	//tfinput textfield 계산 함수
	public void btninputPoint(String str) {
		String org=tfinput.getText();
		if(org.equals("")) {
			tfinput.setText(str);
		}else {
			int sum = Integer.parseInt(org);
			int intstr = Integer.parseInt(str);
			sum = sum+Integer.valueOf(str);
			tfinput.setText(String.valueOf(sum));
		}
		
	}
	
}
