import java.util.*;
class Solution {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        // int[][] answer = new int[(int)Math.pow(n,2)-1][2];
        list = new ArrayList<>();
        
        Hanoi(n,1,2,3);
        int[][] answer = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        // for(int[] li:list) {
        //     System.out.println(Arrays.toString(li));
        // }
        return answer;
    }
    
    public static void Hanoi(int n, int from, int mid, int to) {
        if(n==1) {
            list.add(new int[] {from, to});
            return;
        }
        Hanoi(n-1, from, to, mid); // 처음 1번에서 2번으로 옮긴다.       
        list.add(new int[] {from, to});
        Hanoi(n-1, mid, from, to); // 마지막에 2번에서 3번으로 옮긴다.
    }
}