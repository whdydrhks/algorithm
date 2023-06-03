import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int maxLen=0;
        for(int i=0; i<strArr.length; i++){
            maxLen=Math.max(maxLen, strArr[i].length());
        }
        System.out.println(maxLen);
        
        int[] dp = new int[maxLen];
        
        for(int i=0; i<strArr.length; i++){
            dp[strArr[i].length()-1]++;
        }
        
        for(int i=0; i<dp.length; i++){
            answer=Math.max(answer, dp[i]);
        }
        return answer;
    }
}