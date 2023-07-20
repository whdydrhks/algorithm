import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; 
        int round=0;
        ArrayList<String> list = new ArrayList<>();
        boolean flag=false;
        char ch;
        
        for(int i=0; i<words.length; i++){
            if(i==0) {
                ch=words[i].charAt(words[0].length()-1);
                list.add(words[i]);
                continue;
            }
            ch=words[i-1].charAt(words[i-1].length()-1);
            if(i%n==0) round++;
            if(words[i].charAt(0) != ch) {
                flag=true;
            }
            if(!list.contains(words[i])) {
                list.add(words[i]);
            }
            else {
                flag=true;
            }
            
            if(flag) {
                answer[0] = (i+1)%n;
                if(answer[0]==0) answer[0]=n;
                answer[1]=round+1;
                break;
            }
            
        }
        
        if(!flag) {
            answer[0]=0;
            answer[1]=0;
        }
        
        return answer;
    }
}