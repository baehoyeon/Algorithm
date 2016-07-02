import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * 
 * @author pooh.explorer 
 * https://www.acmicpc.net/problem/1197
 */
public class MinSpanningTreeListTest {
	public static final int INF = 1000001;

	public static void main(String[] args) {
		int vertexCount, edgeCount, start = 0, minStartValue = INF;
		LinkedList<Point>[] graph;
		boolean[] isVisit;
		Scanner sc = new Scanner(System.in);
		vertexCount = sc.nextInt();
		edgeCount = sc.nextInt();

		graph = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			graph[i] = new LinkedList<Point>();
		}
		isVisit = new boolean[vertexCount];

		for (int i = 0; i < edgeCount; i++) {
			int beforeVertex = sc.nextInt() - 1;
			int afterVertex = sc.nextInt() - 1;
			int weight = sc.nextInt();

			graph[beforeVertex].add(new Point(afterVertex, weight));
			graph[afterVertex].add(new Point(beforeVertex, weight));

		}
		sc.close();
		// 입력완료
		// 초기화

		int sum = 0;
		isVisit[start] = true;
		LinkedList<Integer> visits = new LinkedList<Integer>();
		visits.add(start);

		while (true) {
			int minColumn = INF;
			int value = INF;
			ListIterator<Integer> iteratorVisit = visits.listIterator();
			while (iteratorVisit.hasNext()) {
				int row = iteratorVisit.next();// 방문한 적이 있는 부분만 검사

				ListIterator<Point> iterator = graph[row].listIterator();
				while (iterator.hasNext()) {
					Point p = iterator.next();
					if (!isVisit[p.vertex] && value > p.weight) { // 방문한 적이 없고, weight가 적은 놈을 고른다.
						minColumn = p.vertex;
						value = p.weight;
					}
				}
			}
			if (value == INF)
				break; // 만약 갈 곳이 없다면 break;
			isVisit[minColumn] = true;
			visits.add(minColumn);
			sum += value;
		}
		System.out.println(sum);

	}

	static class Point {
		int vertex;
		int weight;

		public Point(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

}
