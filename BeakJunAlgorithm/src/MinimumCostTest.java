import java.util.Scanner;

/**
 * 
 * @author pooh.explorer
 * https://www.acmicpc.net/problem/1916
 */
public class MinimumCostTest {
	static int INF = 100000001; // 무한대 값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cityCount, busCount;
		int[][] graph;
		int start, end;
		
		cityCount = sc.nextInt();
		busCount = sc.nextInt();
		graph = new int[cityCount][cityCount];
		for(int i=0;i<cityCount;i++){
			for(int j=0;j<cityCount;j++){
				graph[i][j] = -1;
			}
		}
		for(int i=0;i<busCount;i++){
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			int value = sc.nextInt();
			if(graph[r][c]<0)
				graph[r][c] = value;
			else if(graph[r][c]>value){ // 중복된 간선(버스)가 들어왔을 때 최소값으로 대체
				graph[r][c] = value;
			}
		}
		start = (sc.nextInt()-1);
		end = (sc.nextInt()-1);
		sc.close();
		
		System.out.print(dikstra(graph, start)[end]);
			
	}
	
	public static int[] dikstra(int[][] graph,int start){
		int count = graph.length; // 정점의 수
		boolean[] isVisits = new boolean[count]; // 방문 배열
		int[] distance = new int[count]; // 거리배열
		

		int nextVertex = start; // distance 배열의 최소값의 정점
		int min = INF; // distance 배열의 최소값
		// 초기화
		for (int i = 0; i < count; i++) {
			distance[i] = INF; // 전부 다 무한대로 초기화
		}
		distance[start] = 0; // 시작점 0 으로 초기화

		// 다익스트라 실행
		while (true) {
			min = INF; // 최소값을 infinity 초기화
			for (int j = 0; j < count; j++) {
				if (!isVisits[j] && distance[j] < min) { // 가장 먼저 방문했던 노드는 제외한다, 또한 최소값을 찾기위한 조사(선택정렬을 생각하면 된다.)
					nextVertex = j; // 다음으로 이동할 정점 선택
					min = distance[j]; // 다음으로 이동한 최소값
				}
			}
			if (min == INF)
				break; // 최소값이 infinity이면 모든 정점을 지났다는 것, 최소값이 모든 정점을 지났으면
						// infinity
			isVisits[nextVertex] = true; // 다음으로 이동할 정점 방문

			for (int j = 0; j < count; j++) {
				if(graph[nextVertex][j]<0) continue; // 간선이 없다면 시도하지 않는다.
				int distanceVertex = distance[nextVertex] + graph[nextVertex][j]; // 정점에서 방문한 다른 정점의 거리
				if (distance[j] > distanceVertex) // 정점에서 다른 정점에서의 거리가 distance 배열보다 적다면 교체해 준다.
				{
					distance[j] = distanceVertex; // 교체해 준다.
				}
			}
		}
		
		return distance;
	}
}
