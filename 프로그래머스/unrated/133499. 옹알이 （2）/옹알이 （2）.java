class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
     
        for(String babble : babbling) {
            if(babble.contains("ayaaya") || babble.contains("yeye") || babble.contains("woowoo") || babble.contains("mama")) continue;
            
            babble = babble.replace("aya", " ");
            babble = babble.replace("ye", " ");
            babble = babble.replace("woo", " ");
            babble = babble.replace("ma", " ");
            // ""가 아닌 " "인 이유 ? 
            // Ex) yayae -> ye -> ""가 되므로 " "로 replace 한다.
            
            babble = babble.replace(" ", "");
            
            
            if(babble.equals("")) answer++;
        }
        return answer;
    }
    
}