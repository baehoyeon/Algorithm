import java.util.Scanner;
/**
 * 
 * @author pooh.explorer
 * https://www.acmicpc.net/problem/11403
 */
public class SearchRouteTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] adMatrix; // 입력인접행렬
		int[][] result; // 결과행렬
		int count;
		
		count = sc.nextInt();
		adMatrix = new int[count][count];
		result = new int[count][count];
		
		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++){
				adMatrix[i][j] = sc.nextInt();
			}
		}
		sc.close(); // 입력종료
		
		// 알고리즘 실행
		for(int i=0;i<count;i++){ // 정점만큼 실행
			int[] isVisits = new int[count];
			DFS(adMatrix,isVisits, i, true); // isFirst를 해서 시작하는 시점인지 아닌지 판별
			result[i] = isVisits;
		}
		
		// 출력
		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++){
				System.out.print(result[i][j]);
				if(j!=count-1) System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void DFS(int[][] graph, int[] isVisits, int vertex, boolean isFirst){ // graph : 인접행렬, isVisit : 방문행렬, vertex : 정점, isFirst : 시작시점인지
		if(!isFirst) isVisits[vertex] = 1; // 시작시점이 아닐 때만 방문행렬 수정
        for(int i=0;i<graph.length;i++)
        {
            if(graph[vertex][i] == 1 && isVisits[i]==0){ // 그래프의 경로가 있고, 방문하지 않았을 때
                DFS(graph, isVisits, i, false);
            }
        }
		
	}
}
