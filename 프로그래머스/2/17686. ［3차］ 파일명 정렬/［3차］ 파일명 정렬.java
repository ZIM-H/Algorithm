import java.util.*;
class Solution {
    public class File{
        String head;
        int number;
        int idx;
        public File(String head, int number, int idx){
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
    }
    public String[] solution(String[] files) {
        
        File[] result = new File[files.length];
        String[] answer = new String[result.length];
        for(int i=0; i<files.length; i++){
            result[i] = new File(makeHead(files[i]), makeNumber(files[i]), i);
        }
        
        Arrays.sort(result, new Comparator<File>(){
            @Override
            public int compare(File o1, File o2){
                if(o1.head.equals(o2.head)) return o1.number - o2.number;
                else return o1.head.compareTo(o2.head);
            }
        });
            
        for(int i=0; i<result.length; i++){
            answer[i] = files[result[i].idx];
        }    
        return answer;
    }
    
    public String makeHead(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') break;
            sb.append(s.charAt(i));
        }
        
        return sb.toString().toLowerCase();
    }
    
    public int makeNumber(String s){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) >= '0' && s.charAt(idx) <= '9') break;
            idx++;
        }
        
        for(int i=idx; i<s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9') break;
            sb.append(s.charAt(i));
        }
             
        return Integer.parseInt(sb.toString());
    }
}