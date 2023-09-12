import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, Integer> hmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(String term : terms) {
            String[] strArr = term.split(" ");
            hmap.put(strArr[0], Integer.parseInt(strArr[1]));
        }
        int idx=1;
        int count=0;
        for(String privacy : privacies) {
            String[] strArr = privacy.split(" ");
            if(check(today, strArr[0], strArr[1], hmap)) {
                idx++;
                continue;
            }
            list.add(idx++);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    public static boolean check(String today, String start, String type, HashMap<String, Integer> hmap) {
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        LocalDate endDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        endDate = startDate.plusMonths(hmap.get(type));
        
        if(todayDate.isAfter(startDate) && todayDate.isBefore(endDate)) return true;
        return false;        
    }
}

// 해결과정
// 1. terms를 hmap에 넣는다. <String, Integer>
// 2. privacies의 날짜를 약관에 맞춰 증가한다. 
//  2-1. "오늘" 날짜가 p의 "시작일"과 "종료일" 사이이면 check