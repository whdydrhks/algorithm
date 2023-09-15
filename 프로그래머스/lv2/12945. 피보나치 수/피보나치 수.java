class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] DP = new int[n+1];
        DP[0]=0;
        DP[1]=1;
        for(int i=2; i<=n; i++){
            DP[i]=(DP[i-2]+DP[i-1])%1234567;
        }
        answer = DP[n];
        return answer;
    }
}