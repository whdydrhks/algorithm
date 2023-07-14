import java.util.*;
class Solution {
    
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(!s.equals("1")) {
            int len = s.length(); // 처음 전체길이
            s = s.replaceAll("0","");
            answer[1]+=len-s.length();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}