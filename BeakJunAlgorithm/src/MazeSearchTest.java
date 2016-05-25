import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
/**
 * @author pooh.explorer
 */
public class MazeSearchTest {
	public static void main(String[] args) throws IOException {
		int[][] adjacencyMatrix;
		LinkedList<Point> queue;
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		int rowCount, columnCount;
		
		// 입력 시작
		String[] rowCol = bfReader.readLine().split(" ");
		rowCount = Integer.parseInt(rowCol[0]);
		columnCount = Integer.parseInt(rowCol[1]);
		
		
		adjacencyMatrix = new int[rowCount][columnCount];
		queue = new LinkedList<Point>();

		for (int i = 0; i < rowCount; i++) {
			String column = bfReader.readLine();
			String[] elements = column.split("");
			for (int j = 0; j < columnCount; j++) {
				int input = Integer.parseInt(elements[j]);
				adjacencyMatrix[i][j] = input;
			}
		}
		bfReader.close();
		// 입력 종료
		
		BFS(adjacencyMatrix,queue,0, 0, rowCount, columnCount);
	}

	public static void BFS(int[][] adjacencyMatrix, LinkedList<Point> queue, int rStart, int cStart, int rEnd, int cEnd){
		int minLength = rEnd * cEnd;
		queue.add(new Point(rStart, cStart, 1));// Enqueue
		
		while (!queue.isEmpty()) {
			Point vertex = (Point) queue.poll(); // Dequeue
			if ((vertex.row == rEnd - 1 && vertex.column == cEnd - 1)) {
				if (minLength > vertex.length) {
					minLength = vertex.length;
				}
				break;
			}

			adjacencyMatrix[vertex.row][vertex.column] = 0;

			if ((vertex.row > 0)
					&& (adjacencyMatrix[vertex.row - 1][vertex.column] == 1)) {
				queue.add(new Point(vertex.row - 1, vertex.column,
						vertex.length + 1));
			} // 행렬을 벗어나지 않고, 위로 갈 수 있다면 위의 지점의 좌표정보와 길이를 큐에 넣는다.
			if ((vertex.row < (rEnd - 1))
					&& (adjacencyMatrix[vertex.row + 1][vertex.column] == 1)) {
				queue.add(new Point(vertex.row + 1, vertex.column,
						vertex.length + 1));
			} // 행렬을 벗어나지 않고, 밑으로 갈 수 있다면 밑의 지점의 좌표정보와 길이를 큐에 넣는다.
			if ((vertex.column > 0)
					&& (adjacencyMatrix[vertex.row][vertex.column - 1] == 1)) {
				queue.add(new Point(vertex.row, vertex.column - 1,
						vertex.length + 1));
			} // 행렬을 벗어나지 않고, 왼쪽으로 갈 수 있다면 왼쪽의 지점의 좌표정보와 길이를 큐에 넣는다.
			if ((vertex.column < (cEnd - 1))
					&& (adjacencyMatrix[vertex.row][vertex.column + 1] == 1)) {
				queue.add(new Point(vertex.row, vertex.column + 1,
						vertex.length + 1));
			} // 행렬을 벗어나지 않고, 오른쪽으로 갈 수 있다면 오른쪽의 지점의 좌표정보와 길이를 큐에 넣는다.

		}

		System.out.println(""+minLength);
	}

	private static class Point {
		int row;
		int column;
		int length;

		public Point(int row, int column, int length) {
			this.row = row;
			this.column = column;
			this.length = length;
		}
	}
}
