import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        ArrayList<Integer> list = new ArrayList<>();
        int count_1 = check1(answers);
        int count_2 = check2(answers);
        int count_3 = check3(answers);
        
        int max=-1;
        max=Math.max(count_1, count_2);
        max=Math.max(max,count_3);
        
        if(max==count_1) list.add(1);
        if(max==count_2) list.add(2);
        if(max==count_3) list.add(3);
        
        Collections.sort(list);
       
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
    
    public static int check1(int[] answers) {
        int[] check = {1,2,3,4,5};
        int idx=0;
        int sum=0;
        for(int i=0; i<answers.length; i++){
            if(idx==check.length) idx=0;
            if(answers[i]==check[idx]) sum++;
            idx++;
        }
        return sum;
    }
    
    public static int check2(int[] answers) {
        int[] check = {2,1,2,3,2,4,2,5};
        int idx=0;
        int sum=0;
        for(int i=0; i<answers.length; i++){
            if(idx==check.length) idx=0;
            if(answers[i]==check[idx]) sum++;
            idx++;
        }
        return sum;
    }
    
    public static int check3(int[] answers) {
        int[] check = {3,3,1,1,2,2,4,4,5,5};
        int idx=0;
        int sum=0;
        for(int i=0; i<answers.length; i++){
            if(idx==check.length) idx=0;
            if(answers[i]==check[idx]) sum++;
            idx++;
        }
        return sum;
    }
}