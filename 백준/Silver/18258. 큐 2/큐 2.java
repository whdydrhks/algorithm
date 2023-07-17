import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.offer(num);
            }
            else if(command.equals("pop")) {
                sb.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
            }
            else if(command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            }
            else if(command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
            else if(command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(deque.size()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}