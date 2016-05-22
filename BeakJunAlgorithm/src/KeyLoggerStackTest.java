import java.util.Scanner;

public class KeyLoggerStackTest {//성공

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		sc.nextLine();
		for (int test_case = 0; test_case < T; test_case++) {
			String input = sc.nextLine();
			System.out.println(solve(input));
		}
	}

	public static String solve(String temp) {
		Stack<Character> resultStack = new Stack<Character>();
		Stack<Character> tempStack = new Stack<Character>();
		
		char[] insertArray = temp.toCharArray();
		for (int i = 0; i < insertArray.length; i++) {
			if (insertArray[i] == '<') {
				if (resultStack.peek() != null) {
					tempStack.push(resultStack.pop());
				}
			} else if (insertArray[i] == '>') {
				if (tempStack.peek() != null) {
					resultStack.push(tempStack.pop());
				}
			} else if (insertArray[i] == '-') {
				if (resultStack.peek() != null) {
					resultStack.pop();
				}
			} else {
				resultStack.push(insertArray[i]);
				
			}
		}
		while (tempStack.peek() != null) {
			resultStack.push(tempStack.pop());
		}
		return resultStack.toString();
	}
}

class Stack<E> {
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