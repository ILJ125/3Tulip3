package h_jtable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableTest extends JFrame {
	JTable table;
	JButton btn;
	MyTableModel myTM;

	public JTableTest() {
		//객체 생성
		myTM = new MyTableModel();//JTable의 데이터와 컬럼명 (model)
		table =new JTable(myTM);//JTable의 화면만 담당(데이터 넣어줘야해)
		btn =new JButton("확인");
		//화면 구성
		//JScrollPane(table) 로 JTable은 꼬옥 이거랑 같이 사용해줘야한다.
		add(new JScrollPane(table),BorderLayout.CENTER);
		add(btn,BorderLayout.NORTH);
		
		//화면 출력
		setBounds(100,100,500,400);//화면
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//이벤트 처리
		//버튼 하나밖에 없어서 한번에 다아 이벤트 등록해주겠습니다.
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();//이너 클래스 에 코딩을 작성하면 제약이 많다. 그래서 함수 호출로 구성
			}
		});
	
	 // 테이블 클릭하면 거기가 몇행 몇열인지  마우스 이벤트 
	table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			System.out.println(row+":" + col + "이벤트 발생");
		}
		});
	}
	
	void change() {
		// 클릭했을 때 발생하는 함수
		ArrayList data = new ArrayList();
		for (int i = 0; i < 5; i++)// 행 row 담당
		{
			ArrayList temp = new ArrayList();
			for (int j = 0; j < 4; j++) {// column열 담당
				if(j==0) temp.add(new Boolean(false)); //불린형태로 값을 주면 체크박스???????????
				temp.add(new Integer(j + 1));// int형을 넣어도 integer로 변환 됩니다.
			}
			data.add(temp);
		}
		// 위에 데이터를 1열에 1,2열에 2등으로 5행 4열로 출력되는 데이터를 JTable 데이터에 집어넣음
		myTM.data = data;
		table.setModel(myTM);// 혹시모르니 Jtable에 다시 myTM 갔다 붙이기
		myTM.fireTableDataChanged();// 모델측에서 화면(뷰)한테 내용변경됨을 알려줌

	}

	class MyTableModel extends AbstractTableModel {
		// table에 내용을 집어넣는 역화를하기 위해 AbstractTableModel 상속
		// 상속받는 클래스가 table 내용을 담당하는 클래스이다.
		// 딱봐도 추상클래스여서 그안에 함수를 오버라이딩 해줘야한다.
		// ??? 테이블 수가 정해저ㅕ있으면 머?
		// 수가 안정해 져있으면 AbstractTableModel 사용

		// 데이터 관리
		// 1. column명을 문자열 배열로
		String[] columnName = { "하나", "둘", "삼", "사" };
		// 2. column에 따른 데이터열의 수를 모르니깐 arrayList 사용
		ArrayList data = new ArrayList();

		public int getColumnCount() {
			// 행의 갯수 가져오는 함수
			return columnName.length;
		}

		public int getRowCount() {
			// 열의 갯수를 가져오는 함수
			return data.size();
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// row행,column열에 있는 데이터 가져오는 함수

			ArrayList temp = (ArrayList) data.get(rowIndex);// rowIndex행의 데이터 전부 가져오기
			return temp.get(columnIndex);// temp는 rowIndex 행의 전부 중 columnIndex열의 데이터를가져옴
		}

		public String getColumnName(int c) {
			// 함수중에서 컬럼 이름 정하는 함수가 있는데 내가 지정한 컬럼네임을 가져다 쓰고 싶어서
			// 오버라이딩 합니다.
			return columnName[c];
		}
		//왜 이거 쓰니깐 체크박스 형태로 바꼈지????????
		public Class getColumnClass(int c) {
			return getValueAt(0,c).getClass();
		}
		
		//0,1열 편집모드 2,3열 노 편집모드
		public boolean isCellEditable(int row, int col) {
			//true이면 편집모드 false면 노 편집모드
			if(col <2)return true;
			else return false;
		}
		//위 함수랑 짝궁인 편집후 저장 할 수있게
		public void setValueAt(Object value, int row, int col) {
			ArrayList temp = (ArrayList)data.get(row);
			temp.set(col, value);
			//row,col위치의 셀이 바뀜
			fireTableCellUpdated(row,col);
			}

	}

	public static void main(String[] args) {
		// 내 클래스 사용하기위해
		JTableTest jt = new JTableTest();

	}

}
