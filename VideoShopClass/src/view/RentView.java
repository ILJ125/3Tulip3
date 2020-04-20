package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import model.dao.RentModel;

public class RentView extends JPanel {
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;

	JTextField tfReturnVideoNum;
	JButton bReturn;

	JTable tableRecentList;

	RentTableModel rentTM;
	
	//모델단 변수 선언
	RentModel model;

	// ==============================================
	// 생성자 함수
	public RentView() {
		addLayout(); // 화면구성
		eventProc(); // DB연결
		connectDB();
		
		selectList();//미납 목록 보기
	}
	void selectList() {
		try {
			rentTM.data=model.selectList();
			tableRecentList.setModel(rentTM);
			rentTM.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println("sleelctList 검색"+e.getMessage());
		}
	}

	// DB 연결
	void connectDB() {
		try {
			model = new RentModel();
		} catch (Exception e) {
			System.out.println("대여관리-드라이버로딩 실패 :"+e.getMessage());
		}
	}

	// 이벤트 등록
	public void eventProc() {
		BtnHandler handler = new BtnHandler();
		tfRentTel.addActionListener(handler);
		bRent.addActionListener(handler);
		bReturn.addActionListener(handler);

	}
	//이벤트 핸들러
	class BtnHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object evt = e.getSource();
			if(evt == tfRentTel) {
				selectBytel();
				
				selectList();
			}
			else if(evt ==bRent) {
				rentVideo();
				selectList();
			}
			else if (evt==bReturn) {
				returnVideo();
				selectList();
			}
		}
	}
	void selectBytel() {
		//전화번호 받아오기
		String name =null;
		String tel=tfRentTel.getText();
		//모델단에 소환 +인자 : tel
		try {
			name=model.selectByTel(tel);
		} catch (Exception e) {
			System.out.println("모델단 오류있다. 확인해라"+e.getMessage());
		}
		//고객명으로 입렵 받은
		tfRentCustName.setText(name);
		
	}
	//대여 버튼이 눌러졌을 때
	void rentVideo(){
		
		//전화번호 & 비디오 번호 가져오기
		String tel = tfRentTel.getText();
		String vnum = tfRentVideoNum.getText();
		//모델단 소환 인자 : 전화번호 , 비디오 번호
		try {
			model.rentVideo(tel, vnum);
		} catch (Exception e) {
			System.out.println("모델단 오류있다. 확인해라"+e.getMessage());
		}
		//대여 완료 후
		tfRentTel.setText("");
		tfRentCustName.setText("");
		tfRentVideoNum.setText("");
	}
	void returnVideo(){
		//비디오 번호 가져오기
		String vnum = tfReturnVideoNum.getText();
		//모델단
		try {
			model.returnVideo(vnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tfReturnVideoNum.setText("");
	}
	
	/* 객체 생성 및 화면 구성 */
	void addLayout() {
		// 객체 생성
		tfRentTel = new JTextField();
		tfRentCustName = new JTextField();
		tfRentVideoNum = new JTextField();
		bRent = new JButton("대여");

		tfReturnVideoNum = new JTextField(15);
		bReturn = new JButton("반납");

		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);

		

		// 화면 구성
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1, 2));
		// 북쪽-왼쪽-대여
		JPanel north_left = new JPanel();
		north_left.setLayout(new GridLayout(4, 2));
		north_left.setBorder(new TitledBorder("대여"));
		north_left.add(new JLabel("전화번호"));
		north_left.add(tfRentTel);
		north_left.add(new JLabel("고객명"));
		north_left.add(tfRentCustName);
		north_left.add(new JLabel("비디오번호"));
		north_left.add(tfRentVideoNum);
		north_left.add(bRent);
		north.add(north_left);
		// 북쪽-오른쪽-반납
		JPanel north_right = new JPanel();
		north_right.setLayout(new FlowLayout());
		north_right.setBorder(new TitledBorder("반납"));
		north_right.add(new JLabel("비디오 번호"));
		north_right.add(tfReturnVideoNum);
		north_right.add(bReturn);
		north.add(north_right);

		// 전체 화면구성, 붙이기
		setLayout(new BorderLayout());
		add(north, BorderLayout.NORTH);
		add(new JScrollPane(tableRecentList), BorderLayout.CENTER);

	}

	class RentTableModel extends AbstractTableModel {

		ArrayList data = new ArrayList();
		String[] columnNames = { "비디오번호", "제목", "고객명", "전화번호", "반납예정일", "반납여부" };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.size();
		}

		public Object getValueAt(int row, int col) {
			ArrayList temp = (ArrayList) data.get(row);
			return temp.get(col);
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

}
