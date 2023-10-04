import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        // 10 10 60 70 80  100 => 3
        int idx=0;
        for(int i=people.length-1; i>=0; i--){
            if(people[i]==0) break;
            int sum=people[i];
            
            boolean flag=false;
            for(int j=idx; j<i; j++) {
                if(people[j]==0) continue;
                sum+=people[j];
                if(sum>limit) break;
                people[j]=0;
                flag=true;
                break;
            }
            answer++;
            if(flag) idx++;
            // System.out.println(list.toString());
        }
        
        return answer;
    }
}