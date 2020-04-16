package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.CustomerDao;
import model.dao.CustomerModel;
import model.vo.Customer;

public class CustomerView extends JPanel {
	JFrame frm;
	JTextField tfCustName, tfCustTel, tfCustTelAid, tfCustAddr, tfCustEmail;
	JButton bCustRegist, bCustModify;

	JTextField tfCustNameSearch, tfCustTelSearch;
	JButton bCustNameSearch, bCustTelSearch;

	JRadioButton[] button;
	JDialog dialog = new JDialog();
	// 모델단 변수
	CustomerDao model;

	public CustomerView() {
		addLayout();
		connectDB();
		eventProc();
	}

	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		// 이벤트 등록
		bCustRegist.addActionListener(btnHandler);
		bCustModify.addActionListener(btnHandler);
		bCustNameSearch.addActionListener(btnHandler);
		bCustTelSearch.addActionListener(btnHandler);

	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();

			if (o == bCustRegist) {
				registCustomer(); // 회원등록
			} else if (o == bCustModify) {
				updateCustomer(); // 회원정보수정
			} else if (o == bCustTelSearch) { // 이름검색
				searchByTel(); // 전화번호 검색
			} else if (o == bCustNameSearch) { // 이름검색
				searchByName();
			}
		}
	}

	// 라디오 이벤트 핸들러 만들기
	class RadioEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent rev) {
			for (int i = 0; i < button.length; i++) {
				if (button[i].isSelected()) {
					tfCustTelSearch.setText(button[i].getText());
					dialog.setVisible(false);
					searchByTel();

				}
			}
		}

	}

	// 회원가입하는 메소드
	public void registCustomer() {

		// 1. 화면 텍스트필드의 입력값 얻어오기
		String cname = tfCustName.getText();
		String ctel1 = tfCustTel.getText();
		String ctel2 = tfCustTelAid.getText();
		String caddr = tfCustAddr.getText();
		String cemail = tfCustEmail.getText();

		// 2. 1값들을 Customer 클래스의 멤버로지정
		Customer vo = new Customer(cname, ctel1, ctel2, caddr, cemail);
		// 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
		try {
			model.insertCustomer(vo);
			System.out.println("성공했어요.");
		} catch (Exception e) {
			System.out.println("vo 인자호출 실패" + e);
		}
		// 4. 화면 초기화
		// JOptionPane.showMessageDialog(null, "입력");
		tfCustName.setText("");
		tfCustTel.setText("");
		tfCustTelAid.setText("");
		tfCustAddr.setText("");
		tfCustEmail.setText("");
	}

	/*
	 * tel1이 프라이머리 키여서 이름 검색할 때 index 설정 해줘야하나? 전화번호에 의한 검색
	 */
	public void searchByTel() {
		// 1. 입력한 전화번호 얻어오기
		String searchTel = tfCustTelSearch.getText();
		// 2. Model의 전화번호 검색메소드 selectByTel() 호출
		try {
			Customer dao = model.selectByTel(searchTel);
			// 3. 2번의 넘겨받은 Customer의 각각의 값을 화면 텍스트 필드 지정
			tfCustName.setText(dao.getCustName());
			tfCustTel.setText(dao.getCustTel1());
			tfCustTelAid.setText(dao.getCustTel2());
			tfCustAddr.setText(dao.getCustAddr());
			tfCustEmail.setText(dao.getCustEmail());
		} catch (Exception e) {
			System.out.println("selectBy에서 문제가 생긴거야");
		}
	}

	public void searchByName() {
		// 이름을 얻어와서 동명인 없는지 확인하고 없으면 바로 selectByTel()함수 실행 ->동명이인 있으면 radio버튼 호출
		// 1.tf에서 이름 얻어오기
		String searchName = tfCustNameSearch.getText();
		ArrayList<String> list = new ArrayList<String>();

		// 2.함수 호출
		try {
			// 동명이인 확인 하는 함수 호출

			list = model.searchSameName(searchName);
			// 전화번호선택해서 이름 검색텍스트 필드에 입력)

			button = new JRadioButton[list.size()];
			radioSelect(list);
			// 선택된 전호번호로 searchByTel()함수 호출
			//

			// 3.출력
		} catch (Exception e) {
			System.out.println("함수 불러오기 실패" + e);
		}

	}//

	public void radioSelect(ArrayList<String> list) {

		dialog.setTitle("동명이인 목록");
		// 동명이인이 있는 경우 전화번호 선택
		// 1.radiobtn 생성 & 객체 생성
		for (int i = 0; i < button.length; i++) {
			button[i] = new JRadioButton(list.get(i));
		}
		dialog.setLayout(new GridLayout(button.length, 1));
		for (int i = 0; i < button.length; i++) {
			dialog.add(button[i]);
		}
		dialog.setSize(250, 300);
		dialog.setVisible(true);

		RadioEventHandler rdoHandler = new RadioEventHandler();
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(rdoHandler);
		}
	}

	// 회원정보수정
	public void updateCustomer() {
		//검색이 되있어요.
		//tel을 가지고 와요 정보를 전부 가지고 온다.
		String cname = tfCustName.getText();
		String ctel1 = tfCustTel.getText();
		String ctel2 = tfCustTelAid.getText();
		String caddr = tfCustAddr.getText();
		String cemail = tfCustEmail.getText();

		// 2. 1값들을 Customer 클래스의 멤버로지정
		Customer vo = new Customer(cname, ctel1, ctel2, caddr, cemail);
		// 3. Model 클래스 안에 insertCustomer () 메소드 호출하여 2번 VO 객체를 넘김
		try {
			model.updateCustomer(vo);
		} catch (Exception e) {
			System.out.println("vo 인자호출 실패" + e);
		}
		// 4. 화면 초기화
		// JOptionPane.showMessageDialog(null, "입력");
		tfCustName.setText("");
		tfCustTel.setText("");
		tfCustTelAid.setText("");
		tfCustAddr.setText("");
		tfCustEmail.setText("");
		

	}

	public void connectDB() {
		// 모델단 연결
		// 인터페이스여서 객체 생성이 안되니 인터페이스 구현해주는 놈으로 객체 만듬
		try {
			model = new CustomerModel();
		} catch (Exception e) {
			System.out.println("모델 연결 실패");
		}

	}

	public void addLayout() {

		tfCustName = new JTextField(20);
		tfCustTel = new JTextField(20);
		tfCustTelAid = new JTextField(20);
		tfCustAddr = new JTextField(20);
		tfCustEmail = new JTextField(20);

		tfCustNameSearch = new JTextField(20);
		tfCustTelSearch = new JTextField(20);

		bCustRegist = new JButton("회원가입");
		bCustModify = new JButton("회원수정");
		bCustNameSearch = new JButton("이름검색");
		bCustTelSearch = new JButton("번호검색");

		// 회원가입 부분 붙이기
		// ( 그 복잡하다던 GridBagLayout을 사용해서 복잡해 보임..다른 쉬운것으로...대치 가능 )
		JPanel pRegist = new JPanel();
		pRegist.setLayout(new GridBagLayout());
		GridBagConstraints cbc = new GridBagConstraints();
		cbc.weightx = 1.0;
		cbc.weighty = 1.0;
		cbc.fill = GridBagConstraints.BOTH;
		cbc.gridx = 0;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	이	름	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustName, cbc);
		cbc.gridx = 2;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(bCustModify, cbc);
		cbc.gridx = 3;
		cbc.gridy = 0;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(bCustRegist, cbc);

		cbc.gridx = 0;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	전	화	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustTel, cbc);
		cbc.gridx = 2;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel(" 추가전화  "), cbc);
		cbc.gridx = 3;
		cbc.gridy = 1;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(tfCustTelAid, cbc);

		cbc.gridx = 0;
		cbc.gridy = 2;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	주	소	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 2;
		cbc.gridwidth = 3;
		cbc.gridheight = 1;
		pRegist.add(tfCustAddr, cbc);

		cbc.gridx = 0;
		cbc.gridy = 3;
		cbc.gridwidth = 1;
		cbc.gridheight = 1;
		pRegist.add(new JLabel("	이메일	"), cbc);
		cbc.gridx = 1;
		cbc.gridy = 3;
		cbc.gridwidth = 3;
		cbc.gridheight = 1;
		pRegist.add(tfCustEmail, cbc);

		// 회원검색 부분 붙이기
		JPanel pSearch = new JPanel();
		pSearch.setLayout(new GridLayout(2, 1));
		JPanel pSearchName = new JPanel();
		pSearchName.add(new JLabel("이 	름	"));
		pSearchName.add(tfCustNameSearch);
		pSearchName.add(bCustNameSearch);
		JPanel pSearchTel = new JPanel();
		pSearchTel.add(new JLabel("	전화번호	"));
		pSearchTel.add(tfCustTelSearch);
		pSearchTel.add(bCustTelSearch);
		pSearch.add(pSearchName);
		pSearch.add(pSearchTel);

		// 전체 패널에 붙이기
		setLayout(new BorderLayout());
		add("Center", pRegist);
		add("South", pSearch);

	}

}
