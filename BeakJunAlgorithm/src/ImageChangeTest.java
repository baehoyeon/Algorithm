import java.util.Scanner;
/**
 * @author pooh.explorer
 */
public class ImageChangeTest {
	static int inf = 99999; // 무한대 값
	static boolean[] isVisits;
	static int[][] adjacencyMatrix;
	static int maxCount;
	static int vertexCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		
		T = sc.nextInt();
		sc.nextLine();
		adjacencyMatrix = new int[T][T];
		isVisits= new boolean[T]; // 거리배열
		
		for(int i=0;i<T;i++){
			String column = sc.nextLine();
			String[] elements = column.split(""); 
			for(int j=0;j<T;j++){
				int input = Integer.parseInt(elements[j]);
				adjacencyMatrix[i][j] = input;
			}
		}
		maxCount = 0;
		vertexCount = T;
		vertifyImage(1, 0, 1);
		System.out.println(maxCount);
	}
	
	public static void vertifyImage(int vertex,int price, int count){
		isVisits[vertex-1] = true;
		for(int i=1;i<=vertexCount;i++){
			if(adjacencyMatrix[vertex-1][i-1] >= price && !isVisits[i-1]){
				vertifyImage(i, adjacencyMatrix[vertex-1][i-1], count+1);
			}
		}
		if(count > maxCount){
			maxCount = count;
		}
	}
}
