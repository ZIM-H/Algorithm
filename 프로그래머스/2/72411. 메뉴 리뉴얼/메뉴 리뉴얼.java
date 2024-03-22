import java.util.*;
class Solution {
    static Map<String, Integer> menu;
    static char[] single;
    static int[] max;
    public String[] solution(String[] orders, int[] course) {
        menu = new HashMap<>();
        max = new int[course.length];
        
        for(int i=0; i<orders.length; i++){
            single = orders[i].toCharArray();
            Arrays.sort(single);
            for(int j=0; j<course.length; j++){
                boolean[] checked = new boolean[single.length];
                comb(0, course[j], "", 0, j);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0; i<max.length; i++){
            for(String order : menu.keySet()){
                if(max[i] != 1 && menu.get(order) == max[i] && order.length() == course[i]){
                    ans.add(order);
                }
            }        
        } 
        
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    static void comb(int start, int cnt, String cur, int curLen, int courseIdx){
        if(curLen == cnt){
            menu.put(cur, menu.getOrDefault(cur, 0) + 1);
            max[courseIdx] = Math.max(max[courseIdx], menu.get(cur));
            return;
        }
        
        for(int i=start; i<single.length; i++){
            comb(i + 1, cnt, cur + single[i], curLen + 1, courseIdx);
        }
    }
}