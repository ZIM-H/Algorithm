import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashSet<String> hs = new HashSet<>();
        
        hs.add(words[0]);
        int length = hs.size();
        
        for(int i=1; i<words.length; i++){
            length = hs.size();
            hs.add(words[i]);
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || length == hs.size()) {
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }
        }

        return answer;
    }
}