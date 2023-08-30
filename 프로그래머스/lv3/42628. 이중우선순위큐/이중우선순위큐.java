import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; // [최대,최소]
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(String operation : operations) {
            String[] commands = operation.split(" ");
            
            if(commands[0].equals("I")) {
                dq.offer(Integer.parseInt(commands[1]));
                list = new ArrayList<>(dq);
                Collections.sort(list);
                dq = new ArrayDeque<>(list);
                // Collections.sort(dq);
            }
            else if(commands[0].equals("D") && dq.isEmpty()) continue;
            
            else if(commands[0].equals("D") && commands[1].startsWith("-1")) {
                dq.pollFirst();
            }
            else {
                dq.pollLast();
            }
        }
        
        if(dq.isEmpty()) {
            answer[0]=0;
            answer[1]=0;
        }
        else {
            answer[1] = dq.pollFirst();
            answer[0] = dq.pollLast();
        }
        return answer;
    }
}