class Solution {
    static int n,m, answer;
    static int[][] beg, tar;
    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        n = target.length;
        m = target[0].length;
        beg = beginning;
        tar = target;
        
        dfs(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int idx, int cnt){
        if(idx == n){
            int result = cnt;
            
            for(int i=0; i<m; i++){
                if(diffCheck(i) == n) result++;
                else if(diffCheck(i) != 0) return;
            }
            
            answer = Math.min(answer, result);
            return;
        }
        
        flip(idx);
        dfs(idx+1, cnt+1);
        flip(idx);
        dfs(idx+1, cnt);
    }
    
    public int diffCheck(int idx){
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(beg[i][idx] != tar[i][idx]) cnt++;
        }
        
        return cnt;
    }
    
    public void flip(int idx){
        for(int i=0; i<m; i++){
            beg[idx][i] = 1 - beg[idx][i]; 
        }
    }
}