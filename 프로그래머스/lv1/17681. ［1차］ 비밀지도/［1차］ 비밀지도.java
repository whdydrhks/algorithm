class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[] str_arr1 = new String[n];
        String[] str_arr2 = new String[n];
        for(int i=0; i<arr1.length; i++){
            String tmp = Integer.toString(arr1[i], 2);
            int len = tmp.length();
            if(tmp.length()<n) {
                for(int j=0; j<n-len; j++) tmp = "0"+tmp;
            }
            str_arr1[i]=tmp;
        }
        for(int i=0; i<arr2.length; i++){
            String tmp = Integer.toString(arr2[i], 2);
            int len = tmp.length();
            if(tmp.length()<n) {
                for(int j=0; j<n-len; j++) tmp = "0"+tmp;
            }
            str_arr2[i]=tmp;
        }
        
        for(int i=0; i<n; i++){
            String tmp="";
            for(int j=0; j<n; j++){
                if(str_arr1[i].charAt(j)=='0' && str_arr2[i].charAt(j)=='0') tmp=tmp+" ";
                else tmp=tmp+"#";
            }
            answer[i]=tmp;
        }
        
        return answer;
    }
}