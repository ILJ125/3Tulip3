package d_constructor;

public class GradeExpr {
	int [] jumsu;

	public GradeExpr(int jumsu[]){
			this.jumsu=jumsu;
		
	}
	public double getAverage() {
		int total= getTotal();
		double avg = (double)total/jumsu.length;
		return avg;
	}
	public int getTotal() {
		int sum =0; 
		for(int i=0;i<jumsu.length;i++)
		{
			sum+= jumsu[i];
		}
		return sum;
	}
	public int getGoodScore() {
		int max=0;
		for(int i=0;i<jumsu.length;i++) {
			if(jumsu[i]>max) {
				max=jumsu[i];
			}
		}
		return max;
	}
	public int getBadScore() {
		int min=jumsu[0];
		for(int i=0;i<jumsu.length;i++) {
			if(jumsu[i]<min) {
				min=jumsu[i];
			}
		}
		return min;
	}

}
