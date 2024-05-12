import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int num = arr[0];
        
        list.add(num);
        for(int i=1; i<arr.length; i++){
            if(arr[i]==num) continue;
            else {
                list.add(arr[i]);
                num=arr[i];
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}