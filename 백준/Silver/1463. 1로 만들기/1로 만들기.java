import java.io.*;
import java.util.*;

public class Main {
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N+1];
		dp[0] = dp[1] = 0;
		
		// 무조건 3->2 와 같이 큰 수로 나눠지는게 아닌, "최소의 경우"를 찾아야 된다.
		System.out.println(recur(N));
		
	}
	
	public static int recur(int N) {
		if(dp[N]==null) {
			// 6으로 나뉘는 경우
			if(N % 6==0) { 
				// 6으로 나눠진다 => 1) 3의경우, 2) 2의경우, 3) N-1의 경우
				dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2)))+1;
			}
			else if(N % 3==0) { 
				// 3으로 나눠진다 => 1) 3의 경우, 2) N-1의 경우
				dp[N] = Math.min(recur(N/3), recur(N-1))+1;
			}
			else if(N % 2==0) {
				dp[N] = Math.min(recur(N/2), recur(N-1))+1;
			}
			else {
				dp[N] = recur(N-1)+1;
			}
		}
		return dp[N];
	}
}
