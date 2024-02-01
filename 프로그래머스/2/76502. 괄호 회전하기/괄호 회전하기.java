import java.util.*;
class Solution {
    static int answer;
    public int solution(String s) {
        answer = 0;
        char[] ch = s.toCharArray();
        
        for(int i=0; i<ch.length; i++){
            check(i, ch);
        }
        
        return answer;
    }
    
    static void check(int start, char[] ch){
        Stack<Character> st = new Stack<>();
        
        for(int i=start; i<ch.length + start; i++){
            char c = ch[i%ch.length];
            if(!st.isEmpty()){
                char s = st.peek();
                if((s=='(' && c==')') || (s=='[' && c==']') || (s=='{' && c=='}')){
                    st.pop();
                    continue;
                } 
            }
            st.push(c);
        }   
        
        if(st.size() == 0) answer++;
    }
}