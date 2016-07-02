import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author pooh.explorer 
 * https://www.acmicpc.net/problem/1197
 */
public class MinSpanningTreeMatrixTest {
	public static final int INF = 1000001;

	public static void main(String[] args) {
		int vertexCount, edgeCount, start = 0;
		int[][] graph;
		boolean[] isVisit;
		Scanner sc = new Scanner(System.in);
		vertexCount = sc.nextInt();
		edgeCount = sc.nextInt();

		graph = new int[vertexCount][vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			for(int j=0;j<vertexCount;j++){
				graph[i][j] = INF;
			}
		}
		isVisit = new boolean[vertexCount];

		for (int i = 0; i < edgeCount; i++) {
			int beforeVertex = sc.nextInt() - 1;
			int afterVertex = sc.nextInt() - 1;
			int weight = sc.nextInt();
			
			graph[beforeVertex][afterVertex] = graph[afterVertex][beforeVertex] = weight;
		}
		sc.close();
		// 입력완료
		// 초기화

		int sum = 0;
		ArrayList<Integer> visits = new ArrayList<Integer>();
		isVisit[start] = true;
		visits.add(start);
		
		while (true) {
			int minColumn = INF;
			int value = INF;
			for(int i=0;i<visits.size();i++){
				int vertex = visits.get(i);
				if(isVisit[vertex]){
					for(int j=0;j<vertexCount;j++){
						if (!isVisit[j] && value > graph[vertex][j]) { // 방문한 적이 없고, weight가 적은 놈을 고른다.
							minColumn = j;
							value = graph[vertex][j];
						}
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
}
