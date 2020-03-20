package d_array;

import java.util.*;

public class Ex5_Lotto2 {

	public static void main(String[] args) {
		// 변수명 로또
		//동일 숫자 배제하기

		int [][]lotto= new int[5][6];//2차원 배열로 6개짜리 변수가 5개 총 40개 5행6열
		//lotto.length=5;
		//lotto[i].length=6;
		
		//lotto 숫자를 랜덤으로 5행 6열 느낌으로 입력해 주기 
		//한 행에 중복되는 숫자는 없어야 한다.
		for(int i=0;i<lotto.length;i++) {

			for(int j=0;j<lotto[i].length;j++) {
				lotto[i][j]=(int)(Math.random()*45)+1;//숫자 입력
				//중복되는 숫자 없애기
				if(j != 0) {
					boolean compare=true;
					while(compare) //
					{
						if(lotto[i][j]==lotto[i][j-1]) {
							lotto[i][j]=(int)(Math.random()*45)+1;
						}else {
							compare=false;//
						}
					}
				}
			}
		}
		//정렬
		for(int k=0;k<lotto.length;k++)//lotto의 행 갯수 만큼 반복 시키고 싶어 
		{
			for(int i=0;i<lotto[k].length-1;i++) //lotto 한 행의 포함된 열의 갯수만큼 반복 시키고 싶어
			{
				for(int j=0;j<lotto[k].length-i-1;j++)//처음에는 열의 갯수만큼 인데, 한번 반복문이 수행 할 때 맨마지막에 큰수가 되니깐 , 그다음 반복은 마지막 큰수 1개 빼고 반복문 돌려도 되겠다.
					//옆에 있는 거 랑 비교하는거니깐 실제 비교 횟수는  n개 있으면 n-1개 반복되
					//1행의 열을 bubble 정렬 해주고, 2행 열을 bubble 정렬 해주고 , i행의 j열을 j-1번 만큼 반복 비교 해준다.
				{

					if(lotto[k][j]>lotto[k][j+1]) 
					{
						int temp=lotto[k][j];
						lotto[k][j]=lotto[k][j+1];
						lotto[k][j+1]=temp;

					}
				}

			}
		}

		//출력
		for(int i=0;i<lotto.length;i++) {
			for(int j=0;j<lotto[i].length;j++) {
				System.out.print(lotto[i][j]+ "/");
			}
			System.out.println();
		}

	}
}

