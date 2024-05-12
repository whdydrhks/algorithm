import java.util.*;
class Solution {
    static int Answer;
    static int[] trio;
    
    public int solution(int[] number) {
        Answer = 0;
        trio = new int[3];
        
        int len = number.length;
        
        comb(0, 0, len, number); // depth, start, limit, number
        return Answer;
    }
    
    public static void comb(int depth, int start, int limit, int[] number) {
        if(depth==3) {
            int sum = 0;
            for(int num : trio) {
                sum+=num;
            }
            if(sum==0) Answer++;
            return;
        }
        
        for(int i=start; i<number.length; i++){
            trio[depth] = number[i];
            comb(depth+1, i+1, limit, number);
        }
    }
}