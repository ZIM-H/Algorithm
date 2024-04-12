import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> dictionary = new HashMap<>();
        int dicIdx = 27;
        for(int i=0; i<26; i++){
            dictionary.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        int wordIdx = 0;
        List<Integer> ans = new ArrayList<>();
        
        while(wordIdx + 1 < msg.length()){
            String cur = "";
            String pre = String.valueOf(msg.charAt(wordIdx));
            
            for(int i=1; wordIdx+i<=msg.length(); i++){
                cur = msg.substring(wordIdx, wordIdx+i);
                if(!dictionary.containsKey(cur)){
                    dictionary.put(cur, dictionary.size()+1);
                    break;
                }
                pre = cur;
            }
            
            ans.add(dictionary.get(pre));
            wordIdx += pre.length();
            
        }
        
        if(wordIdx == msg.length() - 1) ans.add(dictionary.get(String.valueOf(msg.charAt(wordIdx))));
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}