import java.util.LinkedList;
import java.util.Scanner;
/**
 * 
 * @author pooh.explorer
 * https://www.acmicpc.net/problem/1697
 */
public class HideAndSeekTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start,end;
		start = sc.nextInt();
		end = sc.nextInt();
		sc.close(); // 입력종료
		
		BFS(start,end); // 시작점, 끝점 입력
	}
	public static void BFS(int start, int end){
		boolean[] isVisits = new boolean[100001]; // 방문배열
		LinkedList<Point> queue = new LinkedList<Point>(); // BFS에 이용할 queue
		queue.add(new Point(start, 0));
		
		while(!queue.isEmpty()){
			Point point = queue.poll();
			isVisits[point.getValue()] = true;
			if(point.getValue() == end) {
				System.out.print(point.getCount());
				break;
			}
			if(point.getValue()-1>=0 && !isVisits[point.getValue()-1])
				queue.add(new Point(point.getValue()-1, point.getCount()+1));
			if(point.getValue()+1<=100000 && !isVisits[point.getValue()+1])
				queue.add(new Point(point.getValue()+1, point.getCount()+1));
			if(point.getValue()*2<=100000 && !isVisits[point.getValue()*2])
				queue.add(new Point(point.getValue()*2, point.getCount()+1));
			
		}
	}
	
	
	private static class Point{
		int value;
		int count;
		public Point(int value,int count){
			this.value = value;
			this.count = count;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}

}
