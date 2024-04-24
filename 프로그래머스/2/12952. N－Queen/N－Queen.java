class Solution {
    static int[] board;
    static int answer;
    public int solution(int n) {
        answer = 0;
        board = new int[n];
        
        dfs(0, n);
        return answer;
    }
    static void dfs(int dep, int n){
        if(dep == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
            board[dep] = i;
            if(check(dep)) dfs(dep+1, n);
        }
    }
    
    static boolean check(int dep){
        for(int i=0; i<dep; i++){
            if(board[i] == board[dep]) return false;
            if(Math.abs(dep - i) == Math.abs(board[dep] - board[i])) return false;
        }
        
        return true;
    }
}