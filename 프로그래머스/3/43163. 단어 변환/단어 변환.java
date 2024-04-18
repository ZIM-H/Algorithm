import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.add(begin);
        boolean[] used = new boolean[words.length];
        
        int flag = 0;
        while(!q.isEmpty()){
            int size = q.size();              
            for(int i=0; i<size; i++){
                String now = q.poll();
                if(now.equals(target)){
                    flag = 1;
                    break; 
                }
                
                for(int j=0; j<words.length; j++){
                    if(check(now, words[j]) && !used[j]){
                        q.add(words[j]);
                        used[j] = true;
                    }
                }
            }
            if(flag == 1) break;
            answer++;
        }
        
        return flag == 0 ? 0 : answer;
    }
    
    public boolean check(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        
        return cnt == 0 ? false : true;
    }
}