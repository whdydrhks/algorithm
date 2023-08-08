import java.util.*;
class Solution {    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        int sum=0;
        
        for(int weights : truck_weights) {
            while(true) {
                if(queue.isEmpty()) { // 큐(다리)가 비었다.
                    queue.offer(weights);
                    answer++;
                    sum+=weights;
                    break; // 한대 더 넣어
                }
                else if(queue.size()==bridge_length) { // 큐(다리)가 꽉 찼다.
                    sum-=queue.poll();
                }
                else { // 큐(다리)가 공간이 있다.
                    if(sum+weights<=weight) {
                        sum+=weights;
                        answer++;
                        queue.offer(weights);
                        break;
                    }
                    else {
                        answer++;
                        queue.offer(0);
                    }
                }
            }
        }
        
        return answer+bridge_length;
    }
}

// 큐(다리) 완전 비어있다.
//   -큐에 넣기
//   -무게 증가
//   -시간+1
// 큐(다리) 공간이 있다.
//   -다음트럭O ?
//      -sum+다음트럭
//      -time+1
//   -다음트럭X
//      -sum+0
//      -time+1
// 큐(다리) 꽉 찼다.
//   -큐 poll()