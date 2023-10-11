class Solution {
    static boolean flag;
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        for(String str : goal) answer+=str;
        System.out.println("답: "+answer);
        flag = false;
        recur("", cards1, cards2, 0, cards1.length, 0, cards2.length, answer);
        return flag==true ? "Yes" : "No";
    }

    public static void recur(String tmp, String[] cards1, String[] cards2, int depth1, int limit1, int depth2, int limit2, String answer) {
        if(flag || tmp.equals(answer)) {
            flag=true;
            // System.out.println("Tmp: "+tmp);
            return;
        }
                
        if(depth1<limit1) recur(tmp+cards1[depth1], cards1, cards2, depth1+1, limit1, depth2, limit2, answer);
        if(depth2<limit2) recur(tmp+cards2[depth2], cards1, cards2, depth1, limit1, depth2+1, limit2, answer);
        
    }
}