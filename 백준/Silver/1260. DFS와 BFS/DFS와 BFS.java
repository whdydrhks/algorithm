import java.io.*;
import java.util.*;

public class Main {
	static int N,M,V;
	static boolean[] v;
	static int[][] arr;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[1001][10001];
		v = new boolean[N+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e]=1;
			arr[e][s]=1;
		}
		
		dfs(V);
		v = new boolean[N+1];
		System.out.println();
		bfs();
	}
	
	public static void dfs(int depth) {
		v[depth]=true;
		System.out.print(depth+" ");
		
		for(int i=1; i<=N; i++) {
			if(arr[depth][i]==1 && v[i]==false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new ArrayDeque();
		v[V]=true;
		q.offer(V);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			System.out.print(tmp+" ");
			
			for(int i=1; i<=N; i++) {
				if(v[i]==false && arr[tmp][i]==1) {
					q.offer(i);
					v[i]=true;
				}
			}
		}
	}
}
