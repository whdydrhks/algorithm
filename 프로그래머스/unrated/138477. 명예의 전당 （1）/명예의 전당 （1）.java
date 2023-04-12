import java.util.*;

class Solution {
    
    public static class Score implements Comparable<Score> {
        int score;
        public Score(int score) {
            super();
            this.score=score;
        }
        public int compareTo(Score s) {
            return s.score-this.score;
        }
    }
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Score> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            list.add(new Score(score[i]));
            Collections.sort(list);
            if(i<k) answer[i] = list.get(list.size()-1).score;
            else answer[i] = list.get(k-1).score;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}