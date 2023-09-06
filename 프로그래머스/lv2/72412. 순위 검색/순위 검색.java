import java.util.*;
class Solution {
    static HashMap<String, ArrayList<Integer>> hmap;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hmap = new HashMap<>();
        for(String inf : info) 
            powerset(inf.split(" "), "", 0);
        
        for(ArrayList<Integer> list : hmap.values()) 
            Collections.sort(list);
        
        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replace(" and ", "");
            String[] str_arr = query[i].split(" ");
            
            answer[i] = binary_search(str_arr[0], Integer.parseInt(str_arr[1]));
        }
        
        return answer;
    }
    
    public static int binary_search(String sql, int score) {
        if(!hmap.containsKey(sql)) return 0;
        else {
            ArrayList<Integer> list = hmap.get(sql);
            int start=0;
            int end = list.size();
            
            while(start<end) {
                int mid = (start+end)/2;
                if(list.get(mid) >= score) 
                    end=mid;
                else
                    start=mid+1;
            }
            
            return list.size()-start;
        }
    }
    
    public static void powerset(String[] inf_arr, String str, int depth) {
        if(depth==4) {
            int score = Integer.parseInt(inf_arr[depth]);
            if(hmap.containsKey(str)) { // 해당 str 키의 value 리스트에 점수 추가
                hmap.get(str).add(score);
            }
            else { // 리스트 생성해서 점수 넣고 hmap에 넣기
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                hmap.put(str, list);
            }
            return;
        }
        
        powerset(inf_arr, str+'-', depth+1);
        powerset(inf_arr, str+inf_arr[depth], depth+1);
    }
    
}

// 해결과정
// 1. info의 각 문자열에 대한 subset을 만든다.
//  - -가 있는 경우, 없는 경우를 모두 포함하는 결과를 만들기 위해서
//  - javabackend, -backend, java-, --모두 같은 케이스니까.
// 2. 위의 결과를 hmap<String, ArrayList<Integer>>에 담는다.
// 3. 각 key에 대한 value들을 오름차순으로 정렬해서 갯수 파악을 쉽게 한다.
// 4. query문을 이분탐색으로 조사한다. 
//  - 발견한 위치를 리스트의 사이즈에서 뺀다.
//  - 100 120 130 140 150 에서 120 이상은 전체 5개 에서 인덱스 1을 뺀 4개가 된다.