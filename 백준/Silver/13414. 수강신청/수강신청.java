import java.io.*;
import java.util.*;

public class Main {
	static int K, L; // 수강 가능인원, 대기목록 길이
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());		
		LinkedHashSet<String> lhset = new LinkedHashSet<>();
		for(int i=0; i<L; i++) {
			String num = br.readLine();
			if(lhset.contains(num)) { // 두번 클릭했다면!
				lhset.remove(num); // 대기열에서 제거를한다.
			}
			lhset.add(num); // 그리고 맨 뒤에 넣는다.
		}
		
		int count=0;
		for(String value : lhset) {
			count++;
			System.out.println(value);
			if(count==K) break;
		}
	}
}
// HashSet은 순차적으로 데이터가 들어가는게 아니라서 어떤 자료구조를 사용할지 고민했는데,
// LinkedHashSet을 새로 알게 됐다.