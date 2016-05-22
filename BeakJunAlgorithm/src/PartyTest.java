import java.util.Scanner;


public class PartyTest {
	static int inf = 99999; // 무한대 값
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentsCount, roadsCount, partyPlace;
		int[][] weightMatrix;
		int maxFloyd = 0; 
		int maxDikstra = 0; 
		
		// 입력시작
		studentsCount = sc.nextInt();
		weightMatrix = new int[studentsCount][studentsCount];
		roadsCount = sc.nextInt();
		partyPlace = sc.nextInt()-1;
		sc.nextLine();
		
		for(int i=0;i<studentsCount;i++){
			for(int j=0;j<studentsCount;j++){
				weightMatrix[i][j] = inf;
			}
		} // 그래프 무한대 값으로 초기화
		
		for(int i=0;i<roadsCount;i++){
			String[] inputs = sc.nextLine().split(" ");
			weightMatrix[Integer.parseInt(inputs[0])-1][Integer.parseInt(inputs[1])-1] = Integer.parseInt(inputs[2]); // vertex 입력
		}
		sc.close();
		// 입력종료
		
		//플루이드
		System.out.println("Floyd 알고리즘");
		int[][] resultFloyd = floyd(weightMatrix); 
		printGraph(resultFloyd, studentsCount);
		
		for(int i=0;i<studentsCount;i++){
			if(i == partyPlace) continue;
			int tempTime = resultFloyd[i][partyPlace] + resultFloyd[partyPlace][i];
			if(tempTime>maxFloyd) maxFloyd = tempTime;
		}
		System.out.println(maxFloyd+"");
		
		
		// 다익스트라
		System.out.println("Dikstra 알고리즘");
		int[][] resultDikstra = new int[studentsCount][studentsCount];
		for(int i=0;i<studentsCount;i++){
			resultDikstra[i] = dikstra(weightMatrix,i); // 모든 정점에 대한 알고리즘 계산
		}
		printGraph(resultDikstra, studentsCount);
		
		for(int i=0;i<studentsCount;i++){
			if(i == partyPlace) continue;
			int tempTime = resultDikstra[i][partyPlace] + resultDikstra[partyPlace][i];
			if(tempTime>maxDikstra) maxDikstra = tempTime;
		}
		System.out.println(maxDikstra+"");
	}
	
	public static int[][] floyd(int[][] graph) {
		int count;
		int i, j, k;
		count = graph.length;
		int resultGraph[][] = new int[count][count];
		for (i = 0; i < count; i++)
			for (j = 0; j < count; j++)
				resultGraph[i][j] = graph[i][j];

		for (k = 0; k < count; k++) {
			for (i = 0; i < count; i++) {
				for (j = 0; j < count; j++) {
					if (resultGraph[i][k] + resultGraph[k][j] < resultGraph[i][j])
						resultGraph[i][j] = resultGraph[i][k] + resultGraph[k][j];
				}
			}
		}
		return resultGraph;
	}

	public static int[] dikstra(int[][] graph,int start){
		int vCount = graph[0].length; // 정점의 수
		boolean[] isVisits = new boolean[vCount]; // 방문 배열
		int[] distance = new int[vCount]; // 거리배열
		

		int nextVertex = start; // distance 배열의 최소값의 정점
		int min = 0; // distance 배열의 최소값
		// 초기화
		for (int i = 0; i < vCount; i++) {
			isVisits[i] = false; // 방문 한 곳 없다고 초기화
			distance[i] = inf; // 전부 다 무한대로 초기화
			
		}
		distance[start] = 0; // 시작점 0 으로 초기화

		// 다익스트라 실행
		while (true) {
			min = inf; // 최소값을 infinity 초기화
			for (int j = 0; j < vCount; j++) {
				if (isVisits[j] == false && distance[j] < min) { // 가장 먼저 방문했던 노드는 제외한다, 또한 최소값을 찾기위한 조사(선택정렬을 생각하면 된다.)
					nextVertex = j; // 다음으로 이동할 정점 선택
					min = distance[j]; // 다음으로 이동한 최소값
				}
			}
			if (min == inf)
				break; // 최소값이 infinity이면 모든 정점을 지났다는 것, 최소값이 모든 정점을 지났으면
						// infinity
			isVisits[nextVertex] = true; // 다음으로 이동할 정점 방문

			for (int j = 0; j < vCount; j++) {
				int distanceVertex = distance[nextVertex]
						+ graph[nextVertex][j]; // 정점에서 방문한 다른 정점의 거리
				if (distance[j] > distanceVertex) // 정점에서 다른 정점에서의 거리가 distance
													// 배열보다 적다면 교체해 준다.
				{
					distance[j] = distanceVertex; // 교체해 준다.
				}
			}
		}
		return distance;
	}
	
	public static void printGraph(int[][] graph,int count){
		for(int i=0;i<count;i++){
			System.out.print(i + " : ");
			for(int j=0;j<count;j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
