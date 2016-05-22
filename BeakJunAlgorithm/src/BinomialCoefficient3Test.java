import java.util.Scanner;


public class BinomialCoefficient3Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		long N,K;

		N = Long.parseLong(inputs[0]);
		K = Long.parseLong(inputs[1]);
		
		System.out.println(bino(N,K)+"");
		
	}
	static final long limit = 1000000007;
	public static long bino(long N,long K){
		if(K == 0 || N == K) return 1;
		return (bino(N-1,K-1) + bino(N-1,K)) % limit;
	}
}
