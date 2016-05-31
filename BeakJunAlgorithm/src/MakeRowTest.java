import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author pooh.explorer 
 * https://www.acmicpc.net/problem/2252
 */
public class MakeRowTest {
	static int N;
	static int[][] graph;
	static boolean[] isVisits;
	static Stack<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		result = new Stack<Integer>();
		N = sc.nextInt();
		int M = sc.nextInt();
		graph = new int[N + 1][N + 1];
		isVisits = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int big = sc.nextInt();
			int small = sc.nextInt();
			graph[big][small] = 1;
		}
		sc.close();
		// 입력종료
		
		while (true) {
			int vertex = getStartVertex();
			if (vertex == -1)
				break;
			dfs(vertex);
		}

		printStack(result);
		
	}

	private static int getStartVertex() { // 진입간선이 없는 점 찾기
		for (int column = 1; column < graph.length; column++) {
			if (isVisits[column])
				continue;
			boolean isStart = true;
			for (int row = 1; row < graph.length; row++) {
				if (graph[row][column] == 1)
					isStart = false;
			}
			if (isStart)
				return column;
		}
		return -1; // 시작할 정점이 없을 때
	}

	private static void dfs(int vertex) {
		isVisits[vertex] = true;
		for (int i = 1; i < graph.length; i++) {
			if (!isVisits[i] && graph[vertex][i] == 1) {
				dfs(i);
			}
		}
		result.push(vertex);
	}
	
	private static void printStack(Stack<Integer> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.print(" ");
		}
	}


}