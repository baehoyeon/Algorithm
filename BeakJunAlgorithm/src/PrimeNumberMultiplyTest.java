import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimeNumberMultiplyTest {

	public static void main(String[] args) throws IOException {

		BufferedReader bfReader = new BufferedReader(new InputStreamReader(
				System.in));
		String[] inputConditions = bfReader.readLine().split(" ");
		String[] stringInputs = bfReader.readLine().split(" ");
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Set<Integer> checkDuplicate = new HashSet<Integer>();

		int primeNumberCount = Integer.parseInt(inputConditions[0]);
		int humbleNumber = Integer.parseInt(inputConditions[1]);

		for (int i = 0; i < primeNumberCount; i++) {
			int input = Integer.parseInt(stringInputs[i]);
			inputs.add(input);
			priorityQueue.add(input);

		}

		int humbleCount = 0;

		while (true) {
			if (priorityQueue.isEmpty())
				break;
			int minValue = priorityQueue.remove();
			humbleCount += 1;

			if (humbleCount == humbleNumber) {
				System.out.println("" + minValue);
				break;
			}

			for (int i = 0; i < primeNumberCount; i++) {
				int temp = minValue * inputs.get(i);

				if (!checkDuplicate.contains(temp)) {
					priorityQueue.add(temp);
					checkDuplicate.add(temp);
				}
			}

		}

	}
}
