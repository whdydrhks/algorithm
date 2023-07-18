import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            deque.offer(i);
            list.add(i);
        }
        st = new StringTokenizer(br.readLine());
        int count=0;
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                if(num==deque.peekFirst()) {
                    deque.pollFirst();
                    list = new ArrayList<>();
                    for(int j=0; j<deque.size(); j++){
                        int tmp = deque.pollFirst();
                        list.add(tmp);
                        deque.offerLast(tmp);
                    }
                    break;
                }
                else {
                    if (list.indexOf(num) <= list.size() / 2) { // pollFirst() 하고 다시, offerLast() 하기.
                        count++;
                        list = new ArrayList<>();
                        int tmp = deque.pollFirst();
                        deque.offerLast(tmp);

                        for (int j = 0; j < deque.size(); j++) {
                            tmp = deque.pollFirst();
                            list.add(tmp);
                            deque.offerLast(tmp);
                        }

                    } else if (list.indexOf(num) > list.size() / 2) {
                        count++;
                        list = new ArrayList<>();
                        int tmp_num = deque.pollLast();
                        deque.offerFirst(tmp_num);

                        for (int j = 0; j < deque.size(); j++) {
                            int tmp = deque.pollFirst();
                            list.add(tmp);
                            deque.offerLast(tmp);
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}