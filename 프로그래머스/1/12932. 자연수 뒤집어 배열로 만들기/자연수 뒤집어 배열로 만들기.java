import java.util.*;

class Solution {
    public int[] solution(long n) {
        String[] arr = Long.toString(n).split("");        
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            answer[i] = Integer.parseInt(arr[arr.length-i-1]);
        }
        
        return answer;
    }
        
}
