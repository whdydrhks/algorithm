import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int V = Integer.parseInt(br.readLine());
		int[][] floyd = new int[V+1][V+1];
		int INF = 100_000_000;
		
		for(int i=0; i<=V; i++) {
			for(int j=0; j<=V; j++) {
				if(i==j) floyd[i][j]=0;
				else floyd[i][j] = INF;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(from==-1 && to==-1) break;
			floyd[from][to]=1;
			floyd[to][from]=1;
		}
		
		for(int k=0; k<=V; k++) {
			for(int i=0; i<=V; i++) {
				for(int j=0; j<=V; j++) {
					if(floyd[i][k]+floyd[k][j] < floyd[i][j]) {
						floyd[i][j] = floyd[i][k]+floyd[k][j];
					}
				}
			}
		}
		
//		for(int[] student : floyd) {
//			System.out.println(Arrays.toString(student));
//		}
		
		int[] arr = new int[V+1];
		for(int i=0; i<=V; i++) {
			int max=0;
			for(int j=0; j<=V; j++) {
				if(floyd[i][j]==INF) continue;
				max = Math.max(max,floyd[i][j]);
			}
			arr[i]=max;
		}
		
//		System.out.println(Arrays.toString(arr));
		int min = INF;
		for(int i=1; i<=V; i++) {
			min = Math.min(min, arr[i]);
		}
		
		// 회장후보의 점수, 회장후보수
		// 회장후보 오름차순
		
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=V; i++) {
			if(arr[i]==min) {
				list.add(i);
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(cnt).append("\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
