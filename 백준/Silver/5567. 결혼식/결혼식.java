import java.io.*;
import java.util.*;

public class Main {
	static int V,E;
	static boolean[] visited;
	static List<Integer>[] friends_list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] f = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			f[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			f[a].add(b);
			f[b].add(a);
		}

		boolean[] v = new boolean[n];

		v[0] = true;

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(0);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if(cnt==2) break;
			for (int i = 0; i < size; i++) {
				int x = q.poll();
				for (int nowx : f[x]) {
					if (v[nowx])
						continue;
					v[nowx] = true;
					res++;
					q.add(nowx);
				}
			}
			cnt++;
		}
		System.out.println(res);
	}
}