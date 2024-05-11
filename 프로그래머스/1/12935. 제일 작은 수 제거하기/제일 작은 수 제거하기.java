import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1) return new int[] {-1};
        int min = Integer.MAX_VALUE;
        for(int num:arr) min = Math.min(num, min);
        
        int[] answer = new int[arr.length-1];
        for(int i=0, idx=0; i<arr.length; i++){
            if(arr[i]==min) continue;
            answer[idx++]=arr[i];
        }
        
        return answer;
    }
}

// [3,4,1,2]
// [3,4,2]