import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] arr = new int[progresses.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] !=0) arr[i]++;
        }
        
        int num = arr[0];
        int count=1;
        int len=1;
        ArrayList<Integer> list = new ArrayList<>();
        
        if(progresses.length==1) {
            answer=new int[1];
            answer[0]=1;
            return answer;
        }
        
        for(int i=1; i<arr.length; i++){
            if(num>=arr[i]) {
                count++;
            }
            else {
                len++;
                list.add(count);
                num=arr[i];
                count=1;
            }
            
            if(i==arr.length-1) list.add(count);
        }
        
        answer = new int[len];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}
/*
1) (100-progress) / speeds
2) for : progress, 
  count=1
  num=progress[0];
  num보다 큰수가 나오기 전까지 count 증가,
*/

// TC(11) 번례 
// progresses = new int[] {96,94};
// speeds = new int[] {3,3};