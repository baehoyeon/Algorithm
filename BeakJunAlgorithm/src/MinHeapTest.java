import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author pooh.explorer
 * https://www.acmicpc.net/problem/1927
 */
public class MinHeapTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input == 0) {
				Integer result = minHeap.poll();
				if(result == null) result = 0;
				System.out.println(result);
				continue;
			}
			minHeap.add(input);
		}
	}

}
