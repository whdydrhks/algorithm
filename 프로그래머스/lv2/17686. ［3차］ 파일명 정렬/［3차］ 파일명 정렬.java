import java.util.*;
class Solution {
    static class File {
        String origin, head;
        int number;
        File(String origin, String head, int number) {
            this.origin=origin;
            this.head=head;
            this.number=number;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] file_arr = new File[files.length];
        
        for(int i=0; i<files.length; i++){
            String[] split = splitFile(files[i]);
            file_arr[i] = new File(files[i], split[0], Integer.parseInt(split[1]));
        }
        
        Arrays.sort(file_arr, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if(f1.head.equals(f2.head)) return f1.number-f2.number;
                else return f1.head.compareTo(f2.head);
            }
        });
        
        for(int i=0; i<file_arr.length; i++){
            answer[i] = file_arr[i].origin;
        }
        
        return answer;
    }
    
    // head, number, tail 나누기
    public static String[] splitFile(String file) {
        String str[] = new String[3];
        str[0]=""; // head
        str[1]=""; // number
        str[2]=""; // tail
        
        int idx=0;
        for(int i=0; i<file.length(); i++){
            char ch = file.charAt(i);
            
            if(idx==0 && !Character.isDigit(ch)) {
                str[idx]+=ch;
                continue;
            }
            
            if(idx==0 && Character.isDigit(ch)) {
                idx++;
            }
            
            if(idx==1 && Character.isDigit(ch)) {
                str[idx]+=ch;
                continue;
            }
            
            if(idx==1 && !Character.isDigit(ch)) {
                idx++;
            }
            str[idx]+=ch;
        }
        
        str[0] = str[0].toLowerCase(); // 소문자로 비교 위해서.
        return str;
    }
}