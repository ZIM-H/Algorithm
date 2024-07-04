import java.util.*;
class Solution {
    static class Robot {
        int r, c, cnt;
        public Robot(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static char[][] map;
    static Robot end, start;
    static int row, col;
    static int[] dr = {-1,1,0,0}, dc = {0,0,1,-1};
    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        map = new char[row][col];
        start = null;
        end = null;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') start = new Robot(i, j, 0);
                if(map[i][j] == 'G') end = new Robot(i, j, 0);
            }
        }
        
        return bfs();
    }
    
    public int bfs(){
        boolean[][] visited = new boolean[row][col];
        Queue<Robot> q = new ArrayDeque<>();
        
        visited[start.r][start.c] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            Robot now = q.poll();
            
            if(now.r == end.r && now.c == end.c){
                return now.cnt;
            }
            
            for(int d=0; d<4; d++){
                int nr = now.r;
                int nc = now.c;
                
                while(true){
                    int rr = nr + dr[d];
                    int cc = nc + dc[d];
                    
                    if(rr < 0 || cc < 0 || rr >= row || cc >= col || map[rr][cc] == 'D') break;
                    
                    nr = rr;
                    nc = cc;
                }
                
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Robot(nr, nc, now.cnt+1));
                }
            }
        }
        
        return -1;
    }
}