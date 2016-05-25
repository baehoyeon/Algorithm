import java.io.IOException;
import java.util.Scanner;

/**
 * @author pooh.explorer 
 * https://www.acmicpc.net/problem/2805
 */
public class CutTreeTest {

	public static void main(String[] args) throws IOException {
		int treeCount, limitCapacity;
		Scanner sc = new Scanner(System.in);
		treeCount = sc.nextInt();
		limitCapacity = sc.nextInt();
		int[] inputs = new int[treeCount];
		int max = 0;
		for (int i = 0; i < treeCount; i++) {
			int input = sc.nextInt();
			if (max < input)
				max = input;
			inputs[i] = input;
		}
		sc.close();
		// 입력 완료

		int result = binarySearchSolve(inputs, limitCapacity, max);
		System.out.println(result);

	}

	public static int binarySearchSolve(int[] inputs, int limitCapacity, int maxValue) {
		int left = 0;
		int right = maxValue;
		int max = left;
		while (left <= right) {
			long sum = 0;
			int middle = (left + right) / 2;
			for (int i = 0; i < inputs.length; i++) {
				if (inputs[i] > middle)
					sum += (inputs[i] - middle);
			}

			if (sum > limitCapacity) {
				max = middle;
				left = middle + 1;
			} else if (sum < limitCapacity) {
				right = middle - 1;
			} else {
				max = middle;
				break;
			}
		}
		return max;
	}

}
