class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dura = new int[n+1][m+1];
        for(int[] s : skill){
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5] * (s[0]==1? -1:1);
            
            dura[r1][c1] += degree;
            dura[r1][c2+1] -= degree;
            dura[r2+1][c1] -= degree;
            dura[r2+1][c2+1] += degree;
            
        }
        // 가로
        for(int i=0; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                dura[i][j] += dura[i][j-1];
            }
        }
        
        // 세로
        for(int i=0; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                dura[j][i] += dura[j-1][i];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] += dura[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}