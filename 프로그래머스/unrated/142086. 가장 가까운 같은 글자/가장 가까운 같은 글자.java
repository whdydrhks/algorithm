import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0]=-1;
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            int idx=0;
            boolean flag=false;
            for(int j=i-1; j>=0; j--){
                idx++;
                if(ch==s.charAt(j)) {
                    flag=true;
                    break;
                }
            }
            if(flag) answer[i]=idx;
            else answer[i]=-1;
        }
        return answer;
    }
}