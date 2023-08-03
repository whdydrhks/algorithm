import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int V = Integer.parseInt(br.readLine());
		List<Integer>[] tree = new ArrayList[V+1];
		
		for(int i=0; i<=V; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<V-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}
		
		int[] answer = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);
		visited[1]=true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int n : tree[now]) {
				if(!visited[n]) {
					visited[n]=true;
					answer[n]=now; // 부모는 너다!
					queue.offer(n);
				}
			}
		}
		
		for(int i=2; i<=V; i++) {
			System.out.println(answer[i]);
		}
	}
}
