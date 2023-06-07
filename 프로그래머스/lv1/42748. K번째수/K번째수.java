import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int R = commands.length;
        int C = commands[0].length;
        int[] answer = new int[R];
        
        for(int i=0; i<R; i++){
            int start=commands[i][0]-1;
            int end = commands[i][1]-1;
            int idx = commands[i][2]-1;
            int[] arr = new int[end-start+1];
            for(int j=start, k=0; j<=end; j++, k++) {
                arr[k]=array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx];
        }       
        return answer;
    }
}