import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            s = move(s);
            if(check(s)) answer++;   
        }
        return answer;
    }
    
    public static String move(String s) {
        char ch = s.charAt(0);
        s = s.substring(1) + ch;
        return s;
    }
    
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(char data : arr) {
            if(stack.isEmpty()) stack.push(data);
            else if(stack.peek()=='[' && data==']') stack.pop();
            else if(stack.peek()=='{' && data=='}') stack.pop();
            else if(stack.peek()=='(' && data==')') stack.pop();
            else stack.push(data);
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}