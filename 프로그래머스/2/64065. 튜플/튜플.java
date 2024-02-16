import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] num = s.split(",|\\{|\\}");
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<num.length; i++){
            if(num[i].equals("")) continue;
            hm.put(num[i], hm.getOrDefault(num[i], 0)+1);
        }
        List<String> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (v1, v2) -> hm.get(v2)-hm.get(v1));
        
        int[] answer = new int[hm.size()];
        int idx = 0;
        for(String str : list){
            answer[idx] = Integer.parseInt(str);
            idx++;
        }
        
        return answer;
    }
}