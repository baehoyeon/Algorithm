import java.util.Scanner;


public class ParenthesisTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 0; test_case < T; test_case++) {
			String input = sc.nextLine();
			if(solve(input)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static boolean solve(String inputs) {
		boolean isCorrect=true;
		StackP<Character> resultStack = new StackP<Character>();
		
		char[] insertArray = inputs.toCharArray();
		for (int i = 0; i < insertArray.length; i++) {
			if(insertArray[i]=='('){
				resultStack.push(insertArray[i]);
			}else{
				if(resultStack.peek() == null) {
					isCorrect=false;
					break;
				}else{
					resultStack.pop();
				}
			}
		}
		if(isCorrect&&resultStack.peek()!=null) isCorrect=false;
		return isCorrect;
	}

}
class StackP<E> {
	Node<E> top;
	Node<E> bottom;

	class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;
	}

	public E pop() {
		if (top != null) {
			E temp = top.data;
			if (top.next != null)
				top.next.prev = null;
			top = top.next;
			return temp;
		} else {
			bottom = null;
		}
		return null;
	}

	public void push(E num) {
		Node<E> node = new Node<E>();
		node.data = num;
		node.next = top;
		if (top != null) {
			top.prev = node;
		} else {
			bottom = node;
		}
		top = node;
	}

	public E peek() {
		if (top != null) {
			return top.data;
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuffer bf = new StringBuffer();
		Node<E> temp = bottom;
		while (temp != null) {
			bf.append(temp.data);
			temp = temp.prev;
		}
		return bf.toString();
	}
}