class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++) {
            String target = babbling[i];
            char flag = 'z';
            System.out.println("****** "+target+" *******");
            for(int j=0; j<babbling[i].length(); j++) {
                if(target.charAt(0)=='a') {
                    if(flag=='a') break;
                    flag='a';
                    target=func_aya(target);
                     System.out.println("!!! "+target);
                    if(target.equals("No")) break;
                } 
                else if(target.charAt(0)=='y') {
                    if(flag=='y') break;
                    flag='y';
                    target = func_ye(target);
                     System.out.println("@@@ "+target);
                    if(target.equals("No")) break;
                } 
                else if(target.charAt(0)=='w') {
                    if(flag=='w') break;
                    flag='w';
                    target = func_woo(target);
                    if(target.equals("No")) break;
                } 
                else if(target.charAt(0)=='m') {
                    if(flag=='m') break;
                    flag='m';
                    target = func_ma(target);
                    if(target.equals("No")) break;
                } 
                else break;
                
                if(target.equals("")) {
                    answer++;
                    break;
                }
            }      
            System.out.println("After : "+target);
            System.out.println("answer : "+answer);
        }
        
        return answer;
    }
    
    public static String func_aya(String target) {
        String result="";
        if(target.length()<3) return "No";
        for(int i=0; i<target.length(); i++){
            String temp = target.substring(0,3);
            if(temp.equals("aya")) 
                return target.substring(3, target.length());
        }
        return "No";
    }
    
    public static String func_woo(String target) {
        String result="";
        if(target.length()<3) return "No";
        for(int i=0; i<target.length(); i++){
            String temp = target.substring(0,3);
            if(temp.equals("woo")) 
                return target.substring(3, target.length());
        }
        return "No";
    }
    
    public static String func_ye(String target) {
        String result="";
        if(target.length()<2) return "No";
        for(int i=0; i<target.length(); i++){
            String temp = target.substring(0,2);
            if(temp.equals("ye")) 
                return target.substring(2, target.length());
        }
        return "No";
    }
    
    public static String func_ma(String target) {
        String result="";
        if(target.length()<2) return "No";
        for(int i=0; i<target.length(); i++){
            String temp = target.substring(0,2);
            if(temp.equals("ma")) 
                return target.substring(2, target.length());
        }
        return "No";
    }
    
}