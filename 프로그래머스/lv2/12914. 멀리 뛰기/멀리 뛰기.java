import java.util.*;
class Solution {
    public long solution(int n) {
        long answer=0;
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}

// DP
// 1:1 [1]
// 2:2 [1,1] [2]
// 3:3 [1,1,1] [1,2] [2,1]
// 4:5 [1,1,1,1] [1,1,2] [1,2,1] [2,1,1] [2,2]
// 5:8 [1,1,1,1,1] [1,1,1,2] [1,1,2,1] [1,2,1,1] [1,2,2] [2,1,1,1] [2,1,2] [2,2,1]