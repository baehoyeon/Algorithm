import java.util.Scanner;


public class BinomialCoefficient2Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K;

		N = sc.nextInt();
		K = sc.nextInt();
		
		System.out.println(solve(N,K)+"");
		
	}
	
	public static int solve(int N,int K){
		final int limit = 10007;
		int bino[][] = new int[N + 1][N + 1];
		
		for(int i=0;i<=N;i++){
			for(int j=0;j<=i;j++){
				if(j==0 || j==i) bino[i][j] = 1;
				else
					bino[i][j] = (bino[i-1][j-1] + bino[i-1][j]) % limit;
			}
		}
		return bino[N][K];
	}
}
