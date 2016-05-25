import java.util.Scanner;
/**
 * @author pooh.explorer
 */
public class QueueTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;

		T = sc.nextInt();
		sc.nextLine();
		
		Queue<Integer> queue = new Queue();
		for (int test_case = 0; test_case < T; test_case++) {
			String input = sc.nextLine();
			command(queue,input);
		}
	}
	
	public static void command(Queue<Integer> queue, String input){
		String[] splits = input.split(" ");
		Integer result;
		switch (splits[0]) {
		case "push":
			queue.enqueue(Integer.parseInt(splits[1]));
			break;
		case "pop":
			result = queue.dequeue();
			if(result==null)
				System.out.println("-1");
			else
				System.out.println(result);
			break;
		case "size":
			System.out.println(queue.getSize());
			break;
		case "empty":
			if(queue.isEmpty()){
				System.out.println("1");
			}else{
				System.out.println("0");
			}
			break;
		case "front":
			result = queue.getFront();
			if(result==null)
				System.out.println("-1");
			else
				System.out.println(result);
			
			break;
		case "back":
			result = queue.getBack();
			if(result==null)
				System.out.println("-1");
			else
				System.out.println(result);
			break;
		default:
			break;
		}
	}
}

class Queue<E> {
	private Node<E> front;
	private Node<E> back;
	private int count;

	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data);
		if (front == null) {
			front = newNode;
			back = newNode;
		} else {
			back.next = newNode;
			back = newNode;
		}
		count++;
	}

	public E dequeue() {
		Node<E> temp = front;
		if (temp == null)
			return null;
		if (front.next == null) {
			front = null;
			back = null;
		} else {
			front = front.next;
		}
		count--;
		return temp.data;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public int getSize() {
		return count;
	}
	
	public E getFront(){
		if(front!=null)
			return front.data;
		else
			return null;
	}
	
	public E getBack(){
		if(back!=null)
			return back.data;
		else
			return null;
	}

	class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
		}
	}
}