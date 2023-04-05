import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				dp[i][j] = dp[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum=0;
			for(int j=x1; j<=x2; j++) {
				sum = sum + dp[j][y2] - dp[j][y1-1]; 
			}
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
