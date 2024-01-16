import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        ArrayList<String> list = new ArrayList<>(Arrays.asList(players));
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String s : callings){
            int idx = map.get(s);
            String change = list.get(idx - 1);
            list.set(idx-1, s);
            list.set(idx, change);
            
            map.put(s, idx - 1);
            map.put(change, idx);
        }
        
        int idx = 0;
        for(String s : list){
            answer[idx] = s;
            idx++;
        }
        
        return answer;
    }
}
