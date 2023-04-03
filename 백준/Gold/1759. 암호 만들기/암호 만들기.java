import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static String[] a;
	static String[] aa;
	static ArrayList<String> b;
	
	static String[] mo = {"a","e","i","o","u"};
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// 조건 1. 최소 1개의 모음(a,e,i,o,u)
		// 조건 2. 최소 2개의 자음 
		// 조건 3. 증가하는 순. (abc O, bac X)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken()); // 서로 다른 L개의 알파벳 소문자
		C = Integer.parseInt(st.nextToken()); // 주어지는 문자
		a = new String[C];
		aa = new String[L];
		b = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			a[i]=st.nextToken();
		}
		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
		comb(0,0);
		System.out.println(sb.toString());
	}

	public static void comb(int depth, int start) {
		if(depth==L) {
//			System.out.println(b.toString());
			// 조건 1.
			
/*			
			int m_count=0;
			int m_not_count=0;
			for(String m:mo) {
				if(b.contains(m)) m_count++;
				else m_not_count++;
			}
//			if(m_count<1) return;
//			
//			// 조건 2.
//			if(m_not_count<2) return;
			
			if(m_count <1 || m_not_count<2) return;
			
			for(String s:b) {
				System.out.print(s);
			}
			System.out.println();
			*/
			int m_count=0;
			int m_not_count=0;
			for(int i=0; i<aa.length; i++) {
				if(aa[i].equals("a") || aa[i].equals("e") || aa[i].equals("i") || aa[i].equals("o") || aa[i].equals("u")) m_count++;
				else m_not_count++;
			}
			
			if(m_count<1 || m_not_count<2) return;
			
			for(String ca:aa)
				System.out.print(ca);
			System.out.println();
			
			return;
		}
		
		for(int i=start; i<C; i++) {
//			b.add(a[i]);
//			comb(depth+1, i+1);
////			b.remove(b.size()-1);
//			b.remove(b.indexOf(a[i]));
			
			aa[depth] = a[i];
			comb(depth+1, i+1);
		}
	}
}