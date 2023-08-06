import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> hmap = new HashMap();
		HashMap<String, Integer> hmap2 = new HashMap();
		for(int i=1; i<=N; i++) {
			String poketmon = br.readLine();
			hmap.put(i, poketmon);
			hmap2.put(poketmon, i);
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(Character.isDigit(str.charAt(0))) { // 키로 value값 찾기
				String getPoketmon = (String)hmap.get(Integer.parseInt(str));
				sb.append(getPoketmon).append("\n");
			}
			else if(!Character.isDigit(str.charAt(0))) { // value로 key값 찾기
				sb.append(hmap2.get(str)).append("\n");
				
//				for(Integer num:hmap.keySet()) {
//					if(hmap.get(num).equals(str)) {
//						sb.append(num).append("\n");
//					}
//				}
				
			}
		}
		
		System.out.println(sb.toString());
	}
}
