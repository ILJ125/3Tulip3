package h_inherit4;

import java.util.Scanner;

public class Management {

	public static void main(String[] args) {
		// 책, 디비디,씨디 관리 
		
		Item i =null;
		  Scanner input = new Scanner(System.in);
		  System.out.println("상품선택(1. Book  2.Dvd   3.Cd");
		  int sel = input.nextInt();
		  switch(sel) {
		  //부모변수에 자식생성 가능함
		  case 1: i = new Book("001","자바","홍길동","코스모"); break;
		  case 2: i = new Dvd("002","킹덤","주지훈","김은희"); break;
		  case 3: i = new Cd("003","아는노래","지코"); break;
		  }
		  // 출력*****
		  i.output();
	}

}
