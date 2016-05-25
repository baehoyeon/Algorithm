import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author pooh.explorer
 */
public class TreeDiameterTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int root = 0;
		int count = sc.nextInt();
		sc.nextLine();
		
		int[][] weights = new int[count + 1][count + 1]; // 간선의 무게값
		for (int i = 0; i < count - 1; i++) {
			String[] inputs = sc.nextLine().split(" ");
			int start = Integer.parseInt(inputs[0]);
			int end = Integer.parseInt(inputs[1]);
			int weight = Integer.parseInt(inputs[2]);
			if (i == 0)
				root = start; // root 노드 설정
			weights[end][start] = weights[start][end] = weight; // weight 값 입력
		}
		sc.close(); // 입력 종료

		Node maxNode = bfs(weights, root); // root 노드에서부터 가장 weight합이 가장 큰 노드
		Node resultNode = bfs(weights, maxNode.value); // 가장 weight합이 가장 큰 노드부터
														// weight합이 가장 큰 지점
		System.out.println(maxNode.toString());
		System.out.println(resultNode.toString());
		// System.out.println(resultNode.sum+"");
	}

	public static Node bfs(int[][] graph, int start) {
		boolean[] isVisit = new boolean[graph.length + 1]; // 방문 배열
		LinkedList queue = new LinkedList<Node>(); // bfs 큐
		// 초기화

		Node maxNode = new Node(start, 0);
		queue.add(maxNode); // 시작지점 세팅

		while (!queue.isEmpty()) {
			Node vertex = (Node) queue.poll();
			isVisit[vertex.value] = true;
			boolean isNotFinish = false;
			for (int i = 1; i < graph.length; i++) {
				if (graph[vertex.value][i] > 0 && !isVisit[i]) {
					queue.add(new Node(i, vertex.sum + graph[vertex.value][i]));
					isNotFinish = true;
				}
			}
			if (!isNotFinish) { // 끝남
				if (maxNode.sum < vertex.sum)
					maxNode = vertex;
			}
		}
		return maxNode;
	}

	static class Node {
		int value;
		int sum;

		public Node(int value, int sum) {

			this.value = value;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "value : " + value + " Sum : " + sum;
		}

	}
}
