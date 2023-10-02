import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length==1) return new int[] {-1};
        answer = new int[arr.length-1];
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int num : arr) min = Math.min(num, min);
        for(int num : arr) {
            if(num==min) continue;
            list.add(num);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}

// [3,4,1,2]
// [3,4,2]