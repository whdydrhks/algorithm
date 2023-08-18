import java.util.*;

class Solution {
    static class User {
        String uid, action;
        User(String uid, String action) {
            this.uid=uid;
            this.action=action;
        }
    }
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> hmap = new HashMap<>(); // uid, nickname
        ArrayList<User> list = new ArrayList<>();
        for(String rec : record) {
            String[] recs = rec.split(" ");
            String action = recs[0];
            String uid = recs[1];
            
            if(action.equals("Enter")) {
                hmap.put(uid, recs[2]);
                list.add(new User(uid, action));
            }
            else if(action.equals("Leave")) {
                list.add(new User(uid, action));
            }
            else if(action.equals("Change")) {
                hmap.put(uid, recs[2]);
            }
        }
        
        answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            User user = list.get(i);
            if(user.action.equals("Enter")) {
                answer[i] = hmap.get(user.uid)+"님이 들어왔습니다.";
            }
            else if(user.action.equals("Leave")) {
                answer[i] = hmap.get(user.uid)+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }

}

// 닉네임을 바꾸면, 이전의 기록도 갱신된다.
// 닉네임 바꾸기: 1) change, 2) 나가서 바꾸고 재입장

// uid를 보고, 닉네임에 맞춰 이전 데이터까지 갱신.