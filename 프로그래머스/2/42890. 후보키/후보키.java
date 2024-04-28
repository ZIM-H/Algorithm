import java.util.*;
class Solution {
    static int max_idx, answer;
    static String[][] copyRelation;
    static List<String> ans;
    public int solution(String[][] relation) {
        answer = 0;
        max_idx = relation[0].length;
        copyRelation = relation;
        ans = new ArrayList<>();
        
        for(int i=1; i<=max_idx; i++){
            boolean[] used = new boolean[max_idx];
            comb(0, 0, i, new int[i], used);
        }
        return answer==0? 1 : answer;
    }
    
    public void comb(int cnt, int start, int idx, int[] pick, boolean[] used){
        if(cnt == idx){
            check(pick);
            return;
        }
        
        for(int i=start; i<max_idx; i++){
            pick[cnt] = i;
            comb(cnt+1, i+1, idx, pick, used);
        }
    }
    public boolean minimalityCheck(int[] pick, String tmp){
        for(String s : ans){
            int cnt = 0;
            for(char c : s.toCharArray()){
                if(tmp.contains(String.valueOf(c))) cnt++;
            }
            
            if(cnt == s.length()) return false;
        }
        
        return true;
        
    }
    
    public void check(int[] pick){
        String tmp = "";
        for(int i : pick){
            tmp += i;
        }
        
        if(!minimalityCheck(pick, tmp)) return;
        
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        
        for(int j=0; j<copyRelation.length; j++){
            sb = new StringBuilder();
            for(int i=0; i<pick.length; i++){
                sb.append(copyRelation[j][pick[i]]);
            }
            set.add(sb.toString());
        }
        
        if(set.size() == copyRelation.length) {
            answer++;
            ans.add(tmp);
        }
    }
}