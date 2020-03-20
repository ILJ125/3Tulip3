package d_array;

public class Ex2_최댓값찾기 {

	public static void main(String[] args) {
		//제일 큰 점수 찾기 

		int [] score = new int [] {88,61,92,35,50};
		int max=score[0];
		for(int i =1; i<score.length;i++) {
			if(max<=score[i]) {
				max=score[i];
			}
		}
		System.out.println("1등 점수 " + max);

	}

}

