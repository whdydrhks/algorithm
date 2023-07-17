import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str==null) break;

            st = new StringTokenizer(str);

            String pattern = st.nextToken();
            String target = st.nextToken();
            int idx=0;

            for(int i=0; i<target.length(); i++){
                if(target.charAt(i)== pattern.charAt(idx)) idx++;

                if(idx==pattern.length()) {
                    break;
                }
            }

            sb.append(idx==pattern.length() ? "Yes" : "No").append("\n");

        }
        System.out.println(sb.toString());
    }
}