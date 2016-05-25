import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * @author pooh.explorer
 */
public class StringBombTest {
	public static final String EMPTY_STRING = "FRULA";

	public static void main(String[] args) throws IOException {
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(
				System.in));
		char[] T = bfReader.readLine().toCharArray();
		char[] P = bfReader.readLine().toCharArray();
		bfReader.close();

		print(solve(T, P));
	}

	public static Stack<Character> solve(char[] T, char[] P) {

		Stack<Character> resultStack = new Stack<Character>();
		Stack<Character> tempStack = new Stack<Character>();

		for (int i = 0; i < T.length; i++) {
			if (T[i] == P[P.length - 1]) { // 맨 뒤의 문자가 맞을 경우 검사 시작
				if (!tempStack.isEmpty()) // temp stack 이 비워주기 위한 코드
					tempStack.clear();
				tempStack.push(T[i]);

				for (int j = P.length - 2; j >= 0; j--) {
					tempStack.push(resultStack.pop());
					if (tempStack.peek() != P[j]) { // 틀렸을 경우 tempStack에 있는 모든 문자를 resultStack에 넣어준다.
						while (!tempStack.isEmpty()) {
							resultStack.push(tempStack.pop());
						}
						break;
					} // 안틀렸을 경우는 할 것이 없다. resultStack에서 Pop 하면서 검사하기 때문이다.
				}
			} else {
				resultStack.push(T[i]);
			}
		}
		return resultStack;
	}

	public static void print(Stack<Character> result) { // 거꾸로 뒤집기
		if (result.isEmpty()) {
			System.out.println(EMPTY_STRING);
			return;
		}
		StringBuffer bf = new StringBuffer();
		while (!result.isEmpty()) {
			bf.append(result.pop());
		}
		bf.reverse();
		System.out.println(bf.toString());
	}

}
