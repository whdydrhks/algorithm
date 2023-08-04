import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap();
		ArrayList<String> list = new ArrayList();
		
		if(N<=M) {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				map.put(str, 1);
			}
			
			for(int i=0; i<M; i++) {
				String str = br.readLine();
				if(map.containsKey(str)) {
					list.add(str);
				}
			}
			System.out.println(list.size());
			Collections.sort(list);
			for(String s:list) {
				System.out.println(s);
			}			
		}
		else {
			String[] arr = new String[N];
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				arr[i]=str;
			}
			
			for(int i=0; i<M; i++) {
				String str = br.readLine();
				map.put(str, 1);
			}
			
			for(int i=0; i<N; i++) {
				if(map.containsKey(arr[i])) list.add(arr[i]);
			}
			System.out.println(list.size());
			Collections.sort(list);
			for(String s:list) System.out.println(s);
		}
	}
}
