import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
/**
 * @author pooh.explorer
 */
public class KMPSearchTest {

	public static void main(String[] args) throws IOException {
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(
				System.in));

		char[] T = bfReader.readLine().toCharArray(); // 검색할 문자열
		char[] P = bfReader.readLine().toCharArray(); // 검색 패턴
		bfReader.close();

		List result = kmpSearch(T, P);
		System.out.println(result.size());
		for (Object o : result) {
			System.out.print(o + " ");
		}

	}

	public static int[] getMaxBoundaryWidthArray(char[] P) {
		int[] maxBoundaryWidthArray = new int[P.length + 1]; // 마지막 최대너비까지 구해준다.
		for (int i = 0; i <= P.length; i++) {
			if (i == 0) {
				maxBoundaryWidthArray[i] = -1;
				continue;
			}
			int length = i / 2;
			int max = i - 1;
			int count = 0;
			while (length > 0) {
				if (P[(length - 1)] == P[max]) {
					count += 1;
					max -= 1;
				}
				length -= 1;
			}
			maxBoundaryWidthArray[i] = count;
		}
		return maxBoundaryWidthArray;
	}

	public static List kmpSearch(char[] T, char[] P) {
		List matchPrefixIndexResult = new LinkedList<Integer>(); // 결과값
		int[] maxBoundaryWidthArray = getMaxBoundaryWidthArray(P);
		int currentIndex = 0;
		while ((currentIndex + P.length) <= T.length) { // 현재의 위치 + 검색할 문자열의 수가
														// 검색하는 배열의 인덱스를 넘어가면
														// 그만한다.
			int prefixIndex = 0; // 일치 접두부의 길이
			while (prefixIndex < P.length) {
				if (T[currentIndex + prefixIndex] == P[prefixIndex]) {
					prefixIndex += 1; // 맞다면 일치 접두부의 길이 ++;
				} else {
					break;
				}
			}
			if (prefixIndex == P.length) { // 일치 접두부의 길이가 P의 길이와 같다면 일치하는 것이다.
				matchPrefixIndexResult.add(currentIndex + 1);
			}
			int move = prefixIndex - maxBoundaryWidthArray[prefixIndex]; // 이동하는  거리를구한다.
			currentIndex += move;
		}
		return matchPrefixIndexResult;
	}

}
