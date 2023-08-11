import java.util.*;
class Solution {
    public int solution(String s) {
        if(s.length()==1) return 1;
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=s.length()/2; i++){ // 2부터 절반까지 
            int len=i;
            ArrayList<String> list = new ArrayList<>();
            for(int j=0; j<=s.length()-len; j=j+len){
                String divided = s.substring(j,j+len);
                list.add(divided);
                // System.out.println(divided);
            }
            String tail = "";
            if(s.length()%len==0) tail="";
            else tail=s.substring(len*(s.length()/len), s.length());
            // System.out.println("Tail: "+tail);
            
            // System.out.println("---Tranforming---");
            // System.out.println("현재 리스트: "+list.toString());
            String transformed="";
            int sum=1;
            String now="";
            for(int j=0; j<list.size(); j++){
                if(j==0) {
                    now=list.get(j);
                    continue;
                }
                else if(j==list.size()-1 && list.get(j).equals(now)) {
                    transformed = transformed+(sum+1)+now;
                    break;
                }
                else if(j==list.size()-1 && !list.get(j).equals(now)) {
                    if(sum==1) transformed = transformed+now+list.get(j);
                    else transformed = transformed+sum+now+list.get(j);
                    // transformed = transformed+sum+now+list.get(j);
                    break;
                }
                else {
                    if(list.get(j).equals(now)) {
                        sum++;
                    }
                    else {
                        if(sum==1) transformed = transformed+now;
                        else transformed = transformed+sum+now;
                        
                        sum=1;
                        now=list.get(j);
                    }
                }
                
            }
            if(transformed.equals("")) transformed=now;
            transformed+=tail;
            // System.out.println("Transformed: "+transformed);
            // System.out.println("-----------");
            answer = Math.min(answer, transformed.length());
            // System.out.println(answer);
        }
        return answer;
    }
}