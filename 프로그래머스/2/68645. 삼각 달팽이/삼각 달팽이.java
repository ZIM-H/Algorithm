import java.util.*;
class Solution {
    public int[] solution(int n) {
        int max = (n*n)/2 + n/2;
        if(n % 2 == 1) max+=1;
        
        int[][] map = new int[n][n];
        map[0][0] = 1;
        
        int[] answer = new int[max];
        int[] dr = {1,0,-1};
        int[] dc = {0,1,-1};
        
        int idx = 2;
        int dir = 0;
        int r = 0, c = 0;
        int nr = 0, nc = 0;
        while(idx <= max){
            nr = r + dr[dir];
            nc = c + dc[dir];
            if(nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] == 0){
                map[nr][nc] = idx;
                r += dr[dir];
                c += dc[dir];
                idx++;
            }
            else {
                dir = (dir + 1) % 3;
            }
        }
        
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[index] = map[i][j];
                index++;
            }
        }
        
        
        return answer;
    }
}