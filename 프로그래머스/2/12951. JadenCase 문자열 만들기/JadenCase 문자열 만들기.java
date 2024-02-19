import java.util.*;
class Solution {
    public String solution(String s) {

    	StringTokenizer st = new StringTokenizer(s, " ", true);
        
        StringBuilder sb = new StringBuilder();
    	while(st.hasMoreTokens()) {
            String word = st.nextToken();
    		if(word.equals(" ")) sb.append(" ");
    		else {
    			sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
    		}	
    	}
        
        return sb.toString();
    }

}