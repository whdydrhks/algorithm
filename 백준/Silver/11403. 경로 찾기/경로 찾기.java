import java.io.*;
import java.util.*;

public class Main { 
	// 플로이드-워샬 알고리즘
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<N; k++) { // 0부터 N까지 각 단계별.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) { 
					// Point : i에서 j로 가능한지
					// Point : i에서 k로 가고, k에서 j로 가능한지
					if(arr[i][k]==1 && arr[k][j]==1) arr[i][j]=1; 
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
