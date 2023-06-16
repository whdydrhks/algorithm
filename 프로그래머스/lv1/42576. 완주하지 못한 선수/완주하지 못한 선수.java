import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        Arrays.sort(participant);
        Arrays.sort(completion);
        boolean flag=false;
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        if(!flag) return participant[participant.length-1];
        
        return answer;
    }
}