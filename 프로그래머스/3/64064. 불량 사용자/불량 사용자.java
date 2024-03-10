import java.util.*;
class Solution {
    static List<List<Integer>> arr;
    static Set<Set<Integer>> total;
    public int solution(String[] user_id, String[] banned_id) {
        total = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        arr = new ArrayList<>();
        
        for(int i=0; i<banned_id.length; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<banned_id.length; i++){
            for(int j=0; j<user_id.length; j++){
                if(banned_id[i].length() == user_id[j].length()){
                    int flag = 0;
                    for(int k=0; k<banned_id[i].length(); k++){
                        if(banned_id[i].charAt(k) == '*') continue;
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag == 0) arr.get(i).add(j);
                }
            }
        }
       
        
        make(s, 0, banned_id);
        
        return total.size();
    }
    
    static void make(Set<Integer> s , int depth, String[] banned_id){
        int size = s.size();
        if(depth == banned_id.length){
            Set<Integer> set = new HashSet<>(s);
            total.add(set);
            return;
        }
        
        
        for(int i=0; i<arr.get(depth).size(); i++){
            s.add(arr.get(depth).get(i));
            if(s.size() == size) continue;
            make(s, depth + 1, banned_id);
            s.remove(arr.get(depth).get(i));
        }
    }
}