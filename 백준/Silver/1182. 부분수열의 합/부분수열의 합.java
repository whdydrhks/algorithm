import java.io.*;
import java.util.*;

public class Main {
	
	static int N, S;
	static int[] arr;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N];
		
		if(S==0) answer=-1;
		else answer=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(answer);
	}
	
	public static void subset(int depth) {
		if(depth == N) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) list.add(arr[i]);
			}
			
			int sum=0;
			for(int i=0; i<list.size(); i++) {
				sum+=list.get(i);
			}
			
			if(sum==S) {
//				System.out.println(list.toString());
				answer++;
			}
			
			return;
		}
		
		visited[depth] = false;
		subset(depth+1);
		
		visited[depth] = true;
		subset(depth+1);
	}
}
