import static java.lang.Math.pow;
public class BigO implements BigOInterface{
	
	private int count;

	public BigO(){
		count = 0;
	}

    public void cubic(int n){
		
		for (int i = 0; i < n*n; i++){
			for (int j = 0; j < n; j++){
				count = count + j;
			}
		}
		

	}
	
	public void exp(int n){
		int count = 0;
		for (int i = 0; i < pow(2,n); i++){
				count++;
		}
		
	}
	
	public void constant(int n){
		
		n = n + 1;
	}



}