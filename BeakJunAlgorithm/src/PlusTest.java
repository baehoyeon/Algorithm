import java.util.Scanner;


public class PlusTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;

		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(solve(N,K)+"");
	}
	

	public static double solve(int N,int K){
		
		return (double)N/(double)K;
	}

}
