import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author pooh.explorer
 * https://www.acmicpc.net/problem/1120
 */
public class StringTest {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = bf.readLine().split(" ");
		char[] search = inputs[0].toCharArray(); // 찾는 문자열
		char[] total = inputs[1].toCharArray(); // 전체 문자열
		int min = 100;
		for(int i=0;i<=total.length-search.length;i++){
			int count = 0;
			for(int k=0;k<search.length;k++){
				if(search[k]!=total[i+k]){
					count += 1;
				}
			}
			if(min>count) min = count;
		}
		System.out.println(min+"");

	}

}
