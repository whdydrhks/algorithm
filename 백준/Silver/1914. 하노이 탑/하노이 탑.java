import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        BigInteger base = new BigInteger("2");
        base = base.pow(N).subtract(new BigInteger("1"));

        sb.append(base).append("\n");

        if(N<=20)  Hanoi(N,1,2,3);

        System.out.println(sb.toString());
    }

    public static void Hanoi(int N, int from, int mid, int to) {
        if(N==1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        Hanoi(N-1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        Hanoi(N-1, mid, from, to);
    }
}
