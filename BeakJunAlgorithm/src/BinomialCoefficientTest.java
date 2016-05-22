import java.util.Scanner;


public class BinomialCoefficientTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;

		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(solve(N,K)+"");
		
	}
	
	public static int solve(int N,int K){
		if(N-K<K) K = N-K;
		int result = 1;
		int n = N;
		int k = 1;
		for(int i=0;i<K;i++){
			result = result * (n-i) / (k+i);
		}
		return result;
		
	}
}
