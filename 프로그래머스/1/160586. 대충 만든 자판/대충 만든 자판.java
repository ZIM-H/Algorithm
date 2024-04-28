import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            int idx = 0;
            for(char c : keymap[i].toCharArray()){
                idx++;
                if(!map.containsKey(c)){
                    map.put(c, idx);
                }
                else{
                    if(map.get(c) > idx) map.put(c, idx);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            for(char c : targets[i].toCharArray()){
                if(!map.containsKey(c)) {
                    answer[i] = -1;
                    break;
                }
                else answer[i] += map.get(c);
            }
        }
        return answer;
    }
}