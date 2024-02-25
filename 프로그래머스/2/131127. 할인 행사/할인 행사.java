import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<9; i++){
            hm.put(discount[i], hm.getOrDefault(discount[i], 0)+1);
        }
        
        for(int i=9; i<discount.length; i++){
            hm.put(discount[i], hm.getOrDefault(discount[i], 0)+1);
            if(check(want, number, hm)) answer++;
            
            if(hm.get(discount[i-9]) == 1) hm.remove(discount[i-9]);
            else hm.put(discount[i-9], hm.get(discount[i-9])-1);
        }
        return answer;
    }
    
    static boolean check(String[] want, int[] number, HashMap<String, Integer> hm){
        for(int i=0; i<want.length; i++){
            if(!hm.containsKey(want[i]) || hm.get(want[i]) != number[i]) return false;
        }
        
        return true;
    }
}