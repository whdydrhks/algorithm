import java.io.*;
import java.util.*;

public class Main {

	
	// Solution1 - HashSet
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		
//		// HashSet
//		HashSet<String> hset = new HashSet<>();
//		int t = Integer.parseInt(br.readLine());
//		for(int i=0; i<t; i++) {
//			st = new StringTokenizer(br.readLine());
//			String name = st.nextToken();
//			String status = st.nextToken();
//			
//			// enter
//			if(status.equals("enter")) 
//				hset.add(name);
//			
//			// leave
//			else if(status.equals("leave"))
//				if(hset.contains(name)) 
//					hset.remove(name);
//			
//		}
//			List<String> list = new ArrayList<>();
//			// Iterator로 확인
//			Iterator<String> iter = hset.iterator();
//			while(iter.hasNext())
//				list.add(iter.next());
//			
//			// 정렬
//			Collections.sort(list,Collections.reverseOrder());
//			for(String name : list) 
//				System.out.println(name);
//	}
	
	// Solution2 - HashMap
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// HashSet
		HashMap<String, String> hmap = new HashMap<String, String>();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			
			if(hmap.containsKey(name))
				hmap.remove(name);
			else 
				hmap.put(name, status);
		}
		
		List<String> list = new ArrayList<>(hmap.keySet());
		Collections.sort(list, Collections.reverseOrder());
		for(String name : list) 
			System.out.println(name);
		
	}
}
