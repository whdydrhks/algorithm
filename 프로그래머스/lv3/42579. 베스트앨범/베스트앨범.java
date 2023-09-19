import java.util.*;
class Solution {    
    static class Play {
        int count, idx;
        Play(int count, int idx) {
            this.count=count;
            this.idx=idx;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hmap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            hmap.put(genres[i], hmap.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        // 역순 장르 정렬
        ArrayList<String> genreOrder = new ArrayList<>(); // 역순으로 장르 담을 리스트
        while(hmap.size()!=0) {
            int max = -1;
            String maxGenre = "";
            for(String genre : hmap.keySet()) {
                int cnt = hmap.get(genre);
                if(cnt>max) {
                    max=cnt;
                    maxGenre=genre;
                }
            }
            genreOrder.add(maxGenre);
            hmap.remove(maxGenre);
        }
        
        // plays의 재생횟수, index 구하기
        ArrayList<Integer> result = new ArrayList<>();
        for(String listGenre : genreOrder) { // 역순으로 장르를 찾고,
            ArrayList<Play> playList = new ArrayList<>();
            for(int i=0; i<genres.length; i++){ // 일치하는 장르를 찾아서
                if(genres[i].equals(listGenre)) {
                    playList.add(new Play(plays[i], i)); // 횟수와 index를 담는다.
                }
            }
            Collections.sort(playList, (o1, o2)->o2.count-o1.count); // 역순으로 정렬을 해서
            result.add(playList.get(0).idx);
            if(playList.size()>=2) result.add(playList.get(1).idx);
        }
        
        answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}

// 가장 많은 play의 장르가 먼저.
// 고른 장르별 !!!최대!!! 2개의 play를 고른다.