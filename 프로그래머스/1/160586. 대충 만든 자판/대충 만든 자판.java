import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++){               
                if(!hmap.containsKey(key.charAt(i))) {
                    hmap.put(key.charAt(i), i+1);
                }
                else if((i+1) < hmap.get(key.charAt(i))) hmap.put(key.charAt(i),i+1);
            }
        }
        
        int answerIdx=-1;
        for(String target : targets) {
            answerIdx++;
            int sum=0;
            boolean flag=false;
            for(int i=0; i<target.length(); i++){
                if(!hmap.containsKey(target.charAt(i))) {
                    answer[answerIdx]=-1;
                    flag=true;
					break;
                }
                sum+=hmap.get(target.charAt(i));
            }
            if(flag) continue;
            else answer[answerIdx] =  sum;
        }
        
        return answer;
    }
}