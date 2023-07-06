import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>(); 
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		while(list.size() !=1) { 
			for(int i=0; i<K-1; i++) { // K-1까지 돌고, K를 넣는다.
				list.add(list.poll()); // 리스트를 다 돌면 다시 처음부터 돈다. => 리스트의 사이즈가 아닌, K의 횟수
			}
			sb.append(list.poll()).append(",").append(" ");
		}
		sb.append(list.get(0)).append(">");
		
		System.out.println(sb.toString());
	}
}
