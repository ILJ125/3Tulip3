package d_array;

public class Ex5_Lotto {

	public static void main(String[] args) {
		// 변수명 로또

		int [] lotto= new int[6];

		for(int i=0;i<lotto.length;i++) {
			lotto[i]=(int)((Math.random()*45)+1);
			//동일 숫자 배제하기
			for(int k=0;k<i;k++)//현재 숫자를 입력받고 그 숫자랑  이전 숫자랑 비교하기 할려면 너무 복잡쓰 
								//비교 하고 싶은 숫자를 0~ 끝 까지 다 비교 해도 되지 않을까? 된다.돼!
			if(lotto[k]==lotto[i]){
				i--;//i-- 해주면 결국 i가 증가하지 않은 채로 다시 반복 된다. lotto[4]숫자가 앞에 숫자중 중복되는게 있으면  i=4일때를 다시 한번 반복 시켜준다.
			}
		}

		
		
		//정렬
		for(int i=0;i<lotto.length-1;i++) 
		{
			for(int j=0;j<lotto.length-i-1;j++){

				if(lotto[j]>lotto[j+1]) 
				{
					int temp=lotto[j];
					lotto[j]=lotto[j+1];
					lotto[j+1]=temp;

				}

			}



		}
		for(int k=0;k<lotto.length;k++) {
			System.out.print(lotto[k]+ "/");

		}

	}
}

