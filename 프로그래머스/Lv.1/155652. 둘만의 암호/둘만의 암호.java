import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] skips = skip.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char c : skips) list.add(c);
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            while(cnt < index){
                c++;
                if(c > 'z') c = 'a';
                if(list.contains(c)) continue;
                cnt++;
            }
            
            answer += c;
        }
        return answer;
    }
}
