import java.util.*;
class Solution {
    
    static ArrayList<Integer> list;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>(); // 종류, 개수
        for(int num : tangerine) {
            hmap.put(num, hmap.getOrDefault(num,0)+1);
        }
        
        list = new ArrayList<>();
        for(int num : hmap.values()) {
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        int sum=0;
        for(Integer num : list) {
            sum+=num;
            if(sum>=k) return answer+1;
            answer++;
        }
        
        
        return 1;
    }
}

// 리스트에 귤 개수를 담고,
// 역순으로 정렬
// 재귀를 돌면서 k가 되는 경우 찾기 depth:1~list.size()