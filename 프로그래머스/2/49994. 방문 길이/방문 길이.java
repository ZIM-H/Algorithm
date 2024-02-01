import java.util.*;
class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,1,-1};
    public int solution(String dirs) {
        int answer = 0;
        
        char[] dir = dirs.toCharArray();
        int r = 5, c = 5;
        
        boolean[][][] visited = new boolean[11][11][4];
        int d;
        for(int i=0; i<dir.length; i++){
            d = 0;
            switch (dir[i]) {
                case 'U':
                    d = 0;
                    break;
                case 'D':
                    d = 1;
                    break;
                case 'R':
                    d = 2;
                    break;
                case 'L':
                    d = 3;
                    break;
            }
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nc >= 0 && nr < 11 && nc < 11){
                if(!visited[nr][nc][d]) {
                    answer++;
                    visited[nr][nc][d] = true;
                    visited[r][c][change(d)] = true;
                }
                r += dr[d];
                c += dc[d];
            }
            
        }
        
        return answer;
    }
    static int change(int d){
        switch (d){
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return 0;
    }
}