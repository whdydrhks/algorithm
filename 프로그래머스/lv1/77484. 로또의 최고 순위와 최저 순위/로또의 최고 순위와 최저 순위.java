import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero_count=0;
        int same=0;
        ArrayList<Integer> lotto_list = new ArrayList<>();
        for(int lotto : lottos) {
            if(lotto==0) {
                zero_count++;
                continue;   
            }
            lotto_list.add(lotto);
        }
        for(int i=0; i<win_nums.length; i++){
            if(lotto_list.contains(win_nums[i])) same++;
        }
        
        answer[0]=rate(same+zero_count);
        answer[1]=rate(same);
        
        return answer;
    }
    
    public static int rate(int num) {
        if(num==6) return 1;
        else if(num==5) return 2;
        else if(num==4) return 3;
        else if(num==3) return 4;
        else if(num==2) return 5;
        else return 6;
    }
}