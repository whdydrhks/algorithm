import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i);
			
			if(temp==')' && stack.size()==0) 
				return false;
			else if(temp==')' && stack.size()>0) 
				stack.pop();
			else if(temp=='(') {
				stack.push(temp);
			}
		}
		
		if(stack.size()!=0) answer=false;
		return answer;
    }
}