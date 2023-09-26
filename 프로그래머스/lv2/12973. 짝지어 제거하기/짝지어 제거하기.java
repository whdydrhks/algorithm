import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()) { 
                stack.push(ch);
                continue;
            }
            if(stack.peek()==ch) {
                stack.pop();
                continue;
            }
            else stack.push(ch);
        }
        
        return stack.size()==0 ? 1:0;
    }
}