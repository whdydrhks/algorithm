class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp="";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) tmp+=ch;
            else {
                if(ch=='z') {
                    i+=3;
                    tmp+=0;
                    continue;
                }
                else if(ch=='o') {
                    i+=2;
                    tmp+=1;
                    continue;
                }
                else if(ch=='t' && s.charAt(i+1)=='w') {
                    i+=2;
                    tmp+=2;
                    continue;
                }
                else if(ch=='t' && s.charAt(i+1)=='h') {
                    i+=4;
                    tmp+=3;
                    continue;
                }
                else if(ch=='f' && s.charAt(i+1)=='o') {
                    i+=3;
                    tmp+=4;
                    continue;
                }
                else if(ch=='f' && s.charAt(i+1)=='i') {
                    i+=3;
                    tmp+=5;
                    continue;
                }
                else if(ch=='s' && s.charAt(i+1)=='i') {
                    i+=2;
                    tmp+=6;
                    continue;
                }
                else if(ch=='s' && s.charAt(i+1)=='e') {
                    i+=4;
                    tmp+=7;
                    continue;
                }
                else if(ch=='e') {
                    i+=4;
                    tmp+=8;
                    continue;
                }
                else if(ch=='n') {
                    i+=3;
                    tmp+=9;
                    continue;
                }
            }
        }
        System.out.println(tmp);
        answer = Integer.parseInt(tmp);
        return answer;
    }
}