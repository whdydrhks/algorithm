import java.util.*;
class Solution {
    public String solution(String str) {
//         String answer = "";
//         String[] strarr = s.split(" ");
//         int[] arr = new int[strarr.length];
//         for(int i=0; i<arr.length; i++){
//             arr[i] = Integer.parseInt(strarr[i]);
//         }
//         Arrays.sort(arr);
//         answer += arr[0];
//         answer+=" ";
//         answer+=arr[arr.length-1];
        
//         System.out.println(answer);
//         return answer;
        
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;
    }
}