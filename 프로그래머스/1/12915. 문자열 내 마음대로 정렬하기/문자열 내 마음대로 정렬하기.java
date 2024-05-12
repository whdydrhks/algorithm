import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, new Comparator<String> () {
           @Override
			public int compare(String arg0, String arg1) {
				if(arg0.charAt(n)==arg1.charAt(n)) {
					return arg0.compareTo(arg1);
				}
				return arg0.substring(n,arg0.length()).compareTo(arg1.substring(n,arg1.length()));
			}
        });
        answer = strings;
        return answer;
    }
}