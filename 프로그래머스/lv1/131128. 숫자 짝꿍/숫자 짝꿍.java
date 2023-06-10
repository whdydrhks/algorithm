import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<X.length(); i++) {
            pq1.offer(X.charAt(i) - '0');
        }
        for (int i=0; i<Y.length(); i++) {
            pq2.offer(Y.charAt(i) - '0');
        }

        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            if (pq1.peek() == pq2.peek()) {
                sb.append(String.valueOf(pq1.poll()));
                pq2.poll();
            } else if (pq1.peek() > pq2.peek()) {
                pq1.poll();
            } else {
                pq2.poll();
            }
        }

        return sb.toString().equals("") ? "-1" : sb.toString().charAt(0)=='0' ? "0" : sb.toString();
    }
}