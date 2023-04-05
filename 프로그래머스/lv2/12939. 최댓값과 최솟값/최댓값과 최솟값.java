import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strarr = s.split(" ");
        int[] arr = new int[strarr.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(strarr[i]);
        }
        Arrays.sort(arr);
        answer += arr[0];
        answer+=" ";
        answer+=arr[arr.length-1];
        
        System.out.println(answer);
        return answer;
    }
}