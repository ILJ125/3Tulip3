package temp;

import java.util.Scanner;

public class mini_idea1 {

	public static void main(String[] args) {
		//쇼핑 할 때 어느 패키지가 더 저렴하게 살 수 있는지 
		String goods_name =null ;
		int total=0,bundle=0,bundle_gram=0,item_gram=0,total_gram=0,item=0;
		double onegram_cost=0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("상품이름은 무엇입니까?");
		goods_name = input.nextLine();//상품이름 묻기
		
		System.out.println("총 금액은 얼마 입니까?");
		total =input.nextInt();
				
		System.out.println("패키지 안에 총 몇 개의 묶음을 판매 하고 있습니까?");
		bundle =input.nextInt();
		
		System.out.println("한 묶음당 몇 개가 들어 있습니까?");
		item=input.nextInt();
		
		System.out.println("낱개당 몇 그램 입니까?");
		item_gram=input.nextInt();
		
		bundle_gram=item_gram*item;
		total_gram=bundle_gram*bundle;//총 패키지 구매하게 되는 gram
		
		onegram_cost=(double)total/total_gram;
		
		System.out.println("상품"+goods_name+"1g당 가격은 "+onegram_cost );
	}

}
