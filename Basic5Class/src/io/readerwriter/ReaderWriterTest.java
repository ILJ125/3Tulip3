package io.readerwriter;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReaderWriterTest
{
	public static void main( String args[])
	{
		UIForm3 ui = new UIForm3();
		ui.addLayout();
		ui.eventProc();	
	}	
}

//========================================
//	화면을 관리하는 클래스 
//----------------------------------------
class UIForm3 extends JFrame
{
	JTextArea	ta;
	JButton 		bSave, bLoad, bClear;

	UIForm3()
	{
		ta		= new JTextArea();		
		bSave 	= new JButton("파일저장");
		bLoad	= new JButton("파일읽기");
		bClear	= new JButton("화면지우기");
	}

	void addLayout()
	{
		JPanel pCenter 	= new JPanel();
		pCenter.setLayout( new BorderLayout() );
		pCenter.add("Center", new JScrollPane(ta) );

		JPanel pSouth	= new JPanel();
		pSouth.add( bSave );
		pSouth.add( bLoad );
		pSouth.add( bClear );

		getContentPane().add("Center", pCenter );
		getContentPane().add("South",  pSouth );

		setSize( 400, 350 );
		setVisible( true );

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	void eventProc()
	{
		EventHandler hdlr = new EventHandler();

		bSave.addActionListener(hdlr);
		bLoad.addActionListener(hdlr);
		bClear.addActionListener(hdlr);
	}

	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object evt = ev.getSource();

			// "파일저장" 버튼이 눌렸을 때 
			if( evt == bSave){
				//
				JFileChooser fd = new JFileChooser();
				//returnValue 사용자가 입력한 값을 가져와서
				int returnValue = fd.showSaveDialog( null );
				if( returnValue == JFileChooser.APPROVE_OPTION )
				{
					//
					File f = fd.getSelectedFile();
					try{
						/** 
						 * @@@@@@@@@@@@@@@@@@@@@@@@@
						 * */
						//화면값 얻어오기
						String msg = ta.getText();
						//파일에 저장
						FileWriter fw= new FileWriter(f);
						fw.write(msg);
						fw.close();



					}catch(Exception ex){
						System.out.println("저장 실패");
					}	
				}
			}else if(evt==bLoad) {
				// "화일읽기" 버튼이 눌렸을 때 
				JFileChooser fd = new JFileChooser();
				int returnValue = fd.showOpenDialog(null);
				if( returnValue == JFileChooser.APPROVE_OPTION )
				{
					File f = fd.getSelectedFile();
					FileReader fr;
					try {
						fr = new FileReader(f);
						//						String tt=fr.read();
						//read라는 함수가 좀 이상함 저장할 배열을 만들어 줘야한다.
						char [] data =new char[1024];
						fr.read(data);

						ta.setText(String.valueOf(data));
						fr.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}else if(evt==bClear) {
				ta.setText("");
			}

		}
	}
}
