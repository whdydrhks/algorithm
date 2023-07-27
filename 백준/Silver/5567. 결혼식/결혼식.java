import java.io.*;
import java.util.*;

public class Main {
	static int V,E;
	static boolean[] visited;
	static List<Integer>[] friends_list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		V = Integer.parseInt(br.readLine());
		friends_list = new List[V+1];
		visited = new boolean[V+1];
		for(int i=0; i<=V; i++) friends_list[i] = new ArrayList<>();
		
		E = Integer.parseInt(br.readLine());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			friends_list[from].add(to);
			friends_list[to].add(from);
		}
		
		dfs(1, 0);
		int ans=0;
		for(boolean v:visited) if(v) ans++;
		System.out.println(ans==0 ? 0 : ans-1);
		
	}
	
	public static void dfs(int start, int depth) {
		if(depth==2) return; // 0:친구, 1:친구의 친구
		
		for(int friend : friends_list[start]) {
			visited[friend]=true;
			dfs(friend, depth+1);
		}
	}
}
