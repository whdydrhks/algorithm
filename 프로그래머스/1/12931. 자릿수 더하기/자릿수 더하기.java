import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n!=0) {
            int mok = n/10;
            answer += n%10;
            n=mok;
        }

        return answer;
    }
}