import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String tmp = ""+n;
        String[] starr = tmp.split("");
        Arrays.sort(starr, Collections.reverseOrder());
        tmp="";
        for(String str : starr) tmp+=str;
        answer = Long.parseLong(tmp);
        return answer;
    }
}