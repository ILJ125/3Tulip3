package View;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ItemView2 extends JPanel {
   // 멤버변수 선언
   JButton bItem[] = new JButton[20];

   JList liItemOrder;
   Vector vecItem = new Vector();

   JButton bItemOrder, bItemDelete;
   JLabel won;
   
   int sum=0;

   public ItemView2() {
      addLayout();
      eventProc();
   }

   // 화면설계 메소드
   public void addLayout() {
      // 멤버변수 객체 생성
      bItemOrder = new JButton(" 주문하기 ");
      bItemDelete = new JButton("전체삭제");
      // 라벨 주문목록, 요금, 원 / 버튼 주문하기 , 전체삭제
      won = new JLabel("0원");
      // 리스트
      liItemOrder = new JList(vecItem);
      // 20개의 메뉴버튼 배열
      for (int i = 0; i < bItem.length; i++) {
         bItem[i] = new JButton();
      }
      // 왼쪽영역
      JPanel p_left = new JPanel();
      p_left.setLayout(new GridLayout(4, 5));
      for (int i = 0; i < bItem.length; i++) {
         p_left.add(bItem[i]);
      }

      // 오른쪽
      JPanel p_right = new JPanel();

      // 오른쪽 위
      // JLabel 주문목록 , 전체삭제 버튼 grid(2,1)
      JPanel p_right_up = new JPanel();
      p_right_up.setLayout(new GridLayout(2, 1));
      p_right_up.add(new JLabel("주문목록"));
      p_right_up.add(bItemDelete);

      // 오른쪽 중앙
      p_right.add(liItemOrder, BorderLayout.CENTER);
      // 오른쪽 아래
      JPanel p_right_down = new JPanel(new GridLayout(2, 1));
      p_right_down.add(bItemOrder);
      JPanel p_right_down_d = new JPanel(new GridLayout(1, 2));
      p_right_down_d.add(new JLabel("금액"));
      p_right_down_d.add(won);
      p_right_down.add(p_right_down_d);

      // 붙이기
      p_right.setLayout(new BorderLayout());
      p_right.add(p_right_up, BorderLayout.NORTH);
      p_right.add(p_right_down, BorderLayout.SOUTH);

      // 화면붙이기
      setLayout(new BorderLayout());
      add(p_left, BorderLayout.CENTER);
      add(p_right, BorderLayout.EAST);

   }

   // 이벤트 나중에 줄때 리스트 넣기
   public void eventProc() {
      ItemButtonEventHandler handler = new ItemButtonEventHandler();
      for(int i=0;i<bItem.length;i++)
      {      bItem[i].addActionListener(handler);}
      bItemDelete.addActionListener(new ActionListener()
      {   //전체삭제 
         public void actionPerformed(ActionEvent e) {
            JButton evt =(JButton)e.getSource(); 
            System.out.println("삭제");
//            vecItem.clear();
//            liItemOrder.setListData(vecItem);
//            sum=0;
//            won.setText(String.valueOf(0)+"원");
         }
      });
      bItemOrder.addActionListener(new ActionListener()
      {   //주문
         public void actionPerformed(ActionEvent e) {
            JButton evt =(JButton)e.getSource(); 
            System.out.println("주문");
            //주문 -> 매입매출 테이블에 insert 되도록
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         }
      });
   }
   //Item 클릭시 주문목록에 추가
   class ItemButtonEventHandler implements ActionListener {
      public void actionPerformed(ActionEvent ev) {
         Object o = ev.getSource();
         for (int i = 0; i < bItem.length; i++) {
            if (o == bItem[i]) {
               //리스트에 목록 추가
               //Select문으로 가져오기 
               /*보류
               1. 시퀀스는 숫자를 중복시키지 않지만 숫자가 뒤죽박죽이야
                장점: 절대 중복은 없어요. 나중에 상품을 추가해도 .. 프로그램상 이게좋져
                단점: 버튼번호랑 시퀀스랑.. 연동시켜야해요. 
                의문: 시퀀스를 1부터 차례대로 줄 수는 없는가?//베스트

               2. 그냥 여기서 입력할 때 아이디 번호를 직접입력 1~20 
                장점: 우리가 입력한 대로 불러오기 때문에 종류별 분류 와 버튼 연계가 쉽다.
                단점: 중복에 위험이 있다.
                
                */ 
               System.out.println( "아이템 테스트 원투 ");
            }
         }
      }
   }
   

} 
