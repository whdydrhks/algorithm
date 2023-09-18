import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        HashSet<Integer> hsetA = new HashSet<>();
        HashSet<Integer> hsetB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            hsetA.add(Integer.parseInt(st.nextToken()));
        }
        int size = hsetA.size();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hsetA.contains(num)) {
                hsetB.add(num);
                size--;
            }
            else continue;
        }
        sb.append(size).append("\n");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer n : hsetA) {
            if(hsetB.contains(n)) continue;
            pq.offer(n);
        }
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(size==0 ? "0" : sb.toString());
    }
}
