import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i=0; i<name.length; i++){
            hmap.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int score=0;
            for(int j=0; j<photo[i].length; j++){
                if(hmap.get(photo[i][j])==null) continue;
                score+=hmap.get(photo[i][j]);
            }
            answer[i]=score;
        }
        
        return answer;
    }
}