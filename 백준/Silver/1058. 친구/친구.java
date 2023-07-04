import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		int max = 100_000_000; // * 주의  * : Integer.MAX_VALUE 하면 값이 다르게 된다... (28 line)
		int ans=0;
		
		// 초기화
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				char ch = str.charAt(j);
				if(ch=='Y') dp[i][j]=1;
				else if(i!=j) dp[i][j]=max;
			}
		}
		
		// 카운팅
		for(int k=0; k<N; k++) { // 경유지
			for(int i=0; i<N; i++) { // 출발지
				for(int j=0; j<N; j++) { // 도착지
					if(i==j || j==k || k==i) continue; // (i==j : 출발지와 도착지가 같다), (j==k : 목적지와 경우지가 같다), (k==i) : 경유지와 출발지가 같다)
					// => 자기 자신으로의 경로는 불필요하기 때문.
					else if(dp[i][j] > dp[i][k] + dp[k][j]) dp[i][j] = dp[i][k]+dp[k][j]; // 최단거리 재설정.				
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int tmp = 0;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				else if(dp[i][j]<=2) tmp++;
			}
			
			ans = Math.max(ans, tmp);
		}
		
		System.out.println(ans);		
	}
}