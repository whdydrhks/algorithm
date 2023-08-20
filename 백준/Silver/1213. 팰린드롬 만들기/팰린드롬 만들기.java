import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		// 문자열의 갯수를 배열에 담는다.
		// 순(절반) + (홀수갯수) + 역(절반)
		int[] alphabet = new int[26];
		int N = str.length();
		for(int i=0; i<N; i++) {
			alphabet[str.charAt(i)-'A']++;
		}
//		int k=0;
//		System.out.println((char)(k+65));
//		System.out.println(Arrays.toString(alphabet));
		
		int numberOne=0;
		for(int i=0; i<26; i++) {
			if(alphabet[i]%2==1) numberOne++;
		}
		
		
		String ans ="";
		if(numberOne>1) System.out.println("I'm Sorry Hansoo");
		else {
			for(int i=0; i<26; i++) {
				for (int j = 0; j < alphabet[i] / 2; j++) {
					ans += (char) (i + 65);
				}				
			}
			String[] tmp=ans.split("");
			
			for(int i=0; i<26; i++) {
				if(alphabet[i]%2==1) {
					ans+=(char)(i+65);					
				}
			}
			
			Arrays.sort(tmp, Collections.reverseOrder());
			ans+=String.join("", tmp);
			System.out.println(ans);
		}
		
		
	}
	
}
