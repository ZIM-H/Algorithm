class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dir = {-1,1,0,0};
        for(int i=0; i<4; i++){
            int nr = h+dir[i];
            int nc = w+dir[3-i];
            if( nr >=0 && nc>=0 && nr<board.length && nc<board[0].length && board[nr][nc].equals(board[h][w])){
                answer++;
            }
        }
        return answer;
    }
}