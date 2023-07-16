import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 100_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 정점 슈
		int M = Integer.parseInt(br.readLine()); // 간선 수
		int[][] dp = new int[N+1][N+1];
		
		// dp 초기화
		for(int i=1; i<=N; i++){
			Arrays.fill(dp[i], INF);
			dp[i][i]=0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			dp[a][b] = Math.min(dp[a][b], cost);
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sb.append(dp[i][j]==INF ? 0 : dp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
