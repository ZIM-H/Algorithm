import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int key : topping){
            m.put(key, m.getOrDefault(key, 0)+1);
        }
        
        Set<Integer> s = new HashSet<>();
        
        for(int i : topping){
            int cnt = m.get(i);
            if(cnt - 1 == 0) m.remove(i);
            else m.put(i, cnt-1);
            
            s.add(i);
            
            if(s.size() == m.size()) answer++;
            if(s.size() > m.size()) break;
        }
        return answer;
    }
}