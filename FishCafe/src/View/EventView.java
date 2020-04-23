package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;


public class EventView extends JPanel {
	JTextField tfinput; //포인트 입력
	JButton [] bnum = new JButton[11];//자판
	JButton bcancel;
	
	JButton baddpoint;//포인트 적립 버튼
	JButton busepoint;//사용 버튼
	
	JTextField tfcusnum;//팔찌번호 =입력, enter 치면 입력
	
	JTable tbevtspecial;//special물고기 이벤트 |물고기 종류, 포인트,
	TableDataSpeciallst special;//테이블 데이터 
	
	JButton btevttail;//꼬리뼈 이벤트
	
	JCheckBox ceditable; //편집 가능
	JTextField tfevtabout;//근삿값
	JButton bfirst;
	JButton bsecond;
	JButton bthird;
	
	Font basic =new Font("돋움",Font.PLAIN,30);
	//생성자 함수
	public EventView() {
		make();
		printSplst();
		input();
		addLayout();
		eventProc();
	}
	//객체생성
	public void make() {
		for(int i=0; i<bnum.length;i++)
		{
			bnum[i] = new JButton(String.valueOf(i));//자판
			bnum[i].setFont(new Font("돋움",Font.PLAIN,20));
		}
		bnum[10].setText("00");
		bnum[10].setFont(basic);
		
		bcancel = new JButton("취소");
		bcancel.setFont(basic);
		tfinput = new JTextField(); 
		tfinput.setFont(basic);//포인트 입력
		
		baddpoint= new JButton("추가");//포인트 적립 버튼
		baddpoint.setPreferredSize(new Dimension(50, 80));
		baddpoint.setFont(basic);
		busepoint= new JButton("사용");//사용 버튼
		busepoint.setPreferredSize(new Dimension(50, 80));
		busepoint.setFont(basic);
		
		tfcusnum = new JTextField();//팔찌번호 =입력, enter 치면 입력
		tfcusnum.setPreferredSize(new Dimension(50, 80));
		tfcusnum.setFont(basic);
		tbevtspecial= new JTable(special);//special물고기 이벤트 |물고기 종류, 포인트,
		special= new TableDataSpeciallst();//테이블 데이터 
		
		btevttail= new JButton("꼬리뼈 포인트");
		btevttail.setFont(basic);//꼬리뼈 이벤트
		btevttail.setPreferredSize(new Dimension(50, 80));

		ceditable= new JCheckBox(); //편집 가능

		tfevtabout= new JTextField("123");;//근삿값
		tfevtabout.setPreferredSize(new Dimension(80, 80));
		tfevtabout.setFont(basic);
		tfevtabout.setEditable(false);
		bfirst =new JButton("1등");
		bfirst.setFont(basic);
		bsecond =new JButton("2등");
		bsecond.setFont(basic);
		bthird =new JButton("3등");
		bthird.setFont(basic);
		
	}
	//화면 구성
		public void addLayout()
		{
			//전체 GridLayout 으로 1행 2열
			setLayout(new GridLayout(1,2));
			//왼쪽 영역
			JPanel left =new JPanel(new BorderLayout());
				//왼쪽 위 -자판
				JPanel left_center =new JPanel(new BorderLayout());
				left_center.add(tfinput,BorderLayout.NORTH);
					//자판
					JPanel left_c_tf =new JPanel(new GridLayout(1,1));
					left_c_tf.add(tfcusnum);
					JPanel left_c_board =new JPanel(new GridLayout(4,3));
					for(int i=1;i<bnum.length;i++) {
						left_c_board.add(bnum[i]);
					}
					left_c_board.add(bnum[0]);
					left_c_board.add(bnum[10]);
					left_c_board.add(bcancel);
				//왼쪽 south -버튼 두개
				JPanel left_south =new JPanel(new GridLayout(1,2));
				left_south.add(baddpoint);
				left_south.add(busepoint);
			//오른쪽 영역
			JPanel right =new JPanel(new BorderLayout());
				//북- 팔찌 번호
				JPanel right_north =new JPanel(new BorderLayout());
				right_north.add(new JLabel("팔찌 번호"),BorderLayout.WEST);
				right_north.add(tfcusnum,BorderLayout.CENTER);
				//중심 - 특수물고기(중심),근삿값(south)
				JPanel right_center =new JPanel(new BorderLayout());
				right_center.add(new JScrollPane(tbevtspecial),BorderLayout.CENTER);
					JPanel right_about =new JPanel(new BorderLayout());
					right_about.add(ceditable,BorderLayout.WEST);
					JPanel right_about_exch = new JPanel(new GridLayout(1,4));
					right_about_exch.add(tfevtabout);
					right_about_exch.add(bfirst);
					right_about_exch.add(bsecond);
					right_about_exch.add(bthird);
				//남 - 꼬리고리
				right.add(btevttail,BorderLayout.SOUTH);
			//붙이기
			//왼쪽 영역
			left_center.add(left_c_board,BorderLayout.CENTER);
			left_center.add(left_c_tf,BorderLayout.SOUTH);

			left.add(left_center,BorderLayout.CENTER);
			left.add(left_south,BorderLayout.SOUTH);
			add(left);
			//오른쪽 영역
			right_about.add(right_about_exch,BorderLayout.CENTER);
			right_center.add(right_about,BorderLayout.SOUTH);//꼬리고리
			right.add(right_north,BorderLayout.NORTH);//팔찌번호
			right.add(right_center,BorderLayout.CENTER);//특수물고기,근삿값
			add(right);
			
		}
		void input() {
			ArrayList data1 = new ArrayList();
			ArrayList temp2 = new ArrayList();
			String type[]= {"메기","철갑상어","비단 잉어"};
			int points[]= {2000,10000,5000};
//			for(int i =0; i<3;i++) {
//				System.out.println(type[i]
//);			}
			
			
			for(int i =0; i<3;i++) {
				temp2.add(type[i]);
				System.out.println(temp2.get(0));
				temp2.add(points[i]);
				System.out.println(temp2.get(1));
				data1.add(temp2);
//				
			}
			for(int i=0;i<3;i++) {
				ArrayList eveni =new ArrayList();
				eveni.add(data1.get(i));
				for(int j=0;j<2;i++) {
//					System.out.println(eveni.get(j));
				}
			}
			
			special.arrsplst = data1;
			tbevtspecial.setModel(special);
			special.fireTableDataChanged();
			
		}
	
	//테이블 데이터 관리
	class TableDataSpeciallst extends AbstractTableModel{
		String [] columnName = { "종류","포인트"};
		ArrayList arrsplst = new ArrayList(); 
			
		public int getColumnCount() {
			// 행의 갯수 가져오는 함수
			return columnName.length;
		}
		
		public int getRowCount() {
			// 열의 갯수를 가져오는 함수
			return arrsplst.size();
		}
		
		public Object getValueAt(int rowIndex, int columnIndex) {
			// row행,column열에 있는 데이터 가져오는 함수

			ArrayList temp = (ArrayList) arrsplst.get(rowIndex);// rowIndex행의 데이터 전부 가져오기
			return temp.get(columnIndex);// temp는 rowIndex 행의 전부 중 columnIndex열의 데이터를가져옴
		}
		public String getColumnName(int c) {
			// 함수중에서 컬럼 이름 정하는 함수가 있는데 내가 지정한 컬럼네임을 가져다 쓰고 싶어서
			// 오버라이딩 합니다.
			return columnName[c];
		}
		public boolean isCellEditable(int row, int col) {
			//true이면 편집모드 false면 노 편집모드
			return false;
		}
		
	}
	//테이블 데이터 가져오기
		public void printSplst() {
			//물고기 데이터 가져와서 테이블에 입력하기
			ArrayList arrsplst = new ArrayList();
			//JDBC연결 해서 ArrayLst에 붙여넣기
			
			//Jtable 데이터 입력
			special.arrsplst =arrsplst;
			tbevtspecial.setModel(special);
			special.fireTableDataChanged();
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
	}
	
	public class btnEventHandler implements  ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton evt = (JButton)e.getSource();
			
			for(int i=0;i<bnum.length;i++) {
				if(evt==bnum[i]) {
					String original = tfinput.getText();
					tfinput.setText(original + bnum[i].getText());
				}
			}
			//포인트 추가 버튼 
			if(evt==baddpoint) {
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 더 더해서 update
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
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 더 fist 만큼 더해서  update
				
			}else if (evt==bsecond) {
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 더 bsecond 만큼 더해서  update
			}else if (evt==bthird) {
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 더 bthird 만큼 더해서  update
			}else if (evt==btevttail) {
				//팔찌번호를 가져와서 
				//endtime is null 이고 팔찌번호의 손님께
				//포인트를 원래 물고기 무게에 500 만큼 더해서  update
			}
		}
	}
	public class chckEventHandler implements  ActionListener{

		public void actionPerformed(ActionEvent e) {
			
		tfevtabout.setEditable(ceditable.isSelected());
			
		}
		
	}
	
}

