import java.util.*;
class Solution {
    public boolean solution(int x) {
        String tmp = "";
        tmp+=x;
        String[] tmparr = tmp.split("");
        int sum = 0;
        for(int i=0; i<tmparr.length; i++){
            sum+=Integer.parseInt(tmparr[i]);
        }
        
        boolean answer = x%sum==0 ? true : false;
        return answer;
    }
}