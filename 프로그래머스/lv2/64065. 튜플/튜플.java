import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int count=0;
        String[] strArr;
        for(int i=1; i<=s.length()-2; i++){
            if(s.charAt(i)=='{') count++;
        }
        answer = new int[count];
        strArr = new String[count];

        // s = "4,2,3},{3},{2,3,4,1},{2,3";
        s = s.substring(2, s.length()-2);
        
        // s = "4,2,3-3-2,3,4,1-2,3";
        s = s.replace("},{","-");
        
        // strArr = ["4,2,3", "3", "2,3,4,1", "2,3"]
        strArr = s.split("-");
        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        
        // strArr = ["3", "2,3", "4,2,3", "2,3,4,1"]
        // strArr = ["22", "111,22"]
        ArrayList<Integer> list = new ArrayList<>();
        int idx=0;
        for(String str : strArr) {
            String[] tmpArr = str.split(",");
            for(int i=0; i<tmpArr.length; i++){
                int num = Integer.parseInt(tmpArr[i]);
                if(!list.contains(num)) {
                    list.add(num);
                    answer[idx]=num;
                }
            }
            idx++;
        }
        return answer;
    }
}

/*
s : "{{22},{22,111},{22,111,,3},{22,111,3,4}}"	 

1) 필요없는 문자를 제거한다.
s : "22},{22,111},{22,111,,3},{22,111,3,4"

2) 구분을 위해 },{ 를 -로 대체한다.
s : "22-22,111-22,111,3-22,111,3,4"

3) "-"를 기준으로 String[] 에 담아준다. (strArr=s.split("-") )
4) String의 길이를 기준으로 정렬한다.
strArr : ["22", "22,111", "22,111,3", "22,111,3,4"]

5) 하나씩 String을 꺼내고, ","를 기준으로 split() 한다.
6) ArrayList<Integer>에 없으면 넣고 answer에 담는다.

*/