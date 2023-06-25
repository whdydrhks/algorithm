import java.util.*;
class Solution {
    // 1:빵, 2:야채, 3:고기
    // (1-2-3-1)
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            if(stack.size()>=4) {
                if(stack.get(stack.size()-1)==1
                   && stack.get(stack.size()-2)==3
                   && stack.get(stack.size()-3)==2
                   && stack.get(stack.size()-4)==1) {
                    
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
   
}

/*
순서가 1231로 연속적으로 되어 있다.
Stack에 숫자를 넣고
 - 4개 이상이 되었을때,
 - 뒤에서부터 1321 (1231의 역순) 순으로 검사를 한다.
    * Stack의 LIFO 구조를 이용
 - 1231이 확인되면 pop()
*/