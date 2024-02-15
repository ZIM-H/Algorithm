import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> l = new ArrayList<>();
        for(int i : ingredient){
            l.add(i);
            if(l.size() >= 4){
                int len = l.size();
                
                if(l.get(len-1) == 1 && l.get(len-2) == 3 && l.get(len-3) == 2 && l.get(len-4)==1) {
                    answer++;
                    for(int j=0; j<4; j++){
                        l.remove(l.size()-1);
                    }
                    continue;
                }
            }
        }
        
        return answer;
    }
}