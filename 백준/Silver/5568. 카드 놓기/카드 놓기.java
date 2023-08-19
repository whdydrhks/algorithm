import java.io.*;
import java.util.*;

public class Main {
	static String[] b;
	static String[] a;
	static boolean[] v;
	static ArrayList<Integer> list;
	static int n,k;
	static int c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		a = new String[n];
		v = new boolean[n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			a[i]=str;
		}
		//System.out.println(Arrays.toString(a));
		b = new String[k];
		c=0;
		list = new ArrayList();
		perm(0);
//		System.out.println(list.toString());
		System.out.println(c);
	}
	
	public static void perm(int depth) {
		if(depth==k) {
			String str="";
//			System.out.println(Arrays.toString(b));
			for(int i=0; i<b.length; i++) {
				str+=b[i];
			}
			int num = Integer.parseInt(str);
			if(list.contains(num)) return;
			else {
				list.add(num);
				c++;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(v[i]) continue;
			v[i]=true;
			b[depth] = a[i];
			perm(depth+1);
			v[i]=false;
		}
	}
}
