import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] value = new int[board.length+1][board[0].length+1];
        
        if(board.length > 0){
            for(int i=1; i<value.length; i++){
                for(int j=1; j<value[0].length; j++){
                    if(board[i-1][j-1] == 0) value[i][j] = 0;
                    else {
                        value[i][j] = Math.min(value[i-1][j], Math.min(value[i][j-1], value[i-1][j-1])) + 1;
                        answer = Math.max(answer, value[i][j]);
                    }
                }
            }
        }

        return answer * answer;
    }
}