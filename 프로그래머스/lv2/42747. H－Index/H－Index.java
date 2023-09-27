import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int len = citations.length;
        int num=1;
        while(true) {
            if(num>len) break;
            int sum=0;
            for(int citation : citations) {
                if(citation>=num) sum++;
            }
            if(sum>=num && (len-sum)<=num) {
                answer = Math.max(answer, num);
            }
            num++;
        }
        return answer;
    }
}