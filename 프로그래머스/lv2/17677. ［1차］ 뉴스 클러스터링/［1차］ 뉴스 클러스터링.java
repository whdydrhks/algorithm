import java.util.*;
class Solution {
    static ArrayList<String> list1;
	static ArrayList<String> list2;
	static ArrayList<String> intersection; // 교집합
	static ArrayList<String> union; // 합집합
    public int solution(String str1, String str2) {
		int answer=0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		
		for(int i=0; i<str1.length()-1; i++) {
			String tmp="";
			for(int j=i; j<=i+1; j++) {
				tmp+=str1.charAt(j);
			}
			if(tmp.matches("^[a-zA-Z]*$")) list1.add(tmp); 
		}
		for(int i=0; i<str2.length()-1; i++) {
			String tmp="";
			for(int j=i; j<=i+1; j++) {
				tmp+=str2.charAt(j);
			}
			if(tmp.matches("^[a-zA-Z]*$")) list2.add(tmp);
		}
		intersection = new ArrayList<>();
		union = new ArrayList<>();

		ArrayList<String> tmp = new ArrayList<>();
		for(String s:list1) {
			if(!tmp.contains(s)) {
				tmp.add(s);
			}
		}
		for(String s:list2) {
			if(!tmp.contains(s)) {
				tmp.add(s);
			}
		}
		
		for(int i=0; i<tmp.size(); i++) {
			int count1 = Collections.frequency(list1, tmp.get(i));
			int count2 = Collections.frequency(list2, tmp.get(i));
			int count = Math.min(count1, count2);
			int count_max = Math.max(count1, count2);
			for(int j=0; j<count; j++) {
				intersection.add(tmp.get(i));
			}
			for(int j=0; j<count_max; j++) {
				union.add(tmp.get(i));
			}
		}

		if(union.size()==0) answer = 65536;
		else {
			answer = (int)(65536 * intersection.size() / union.size());
		}
        return answer;
    }
}