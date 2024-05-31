import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    answer[0]++;
                    answer[1] = Math.max(answer[1], bfs(i, j, picture));
                }
            }
        }
        return answer;
    }
    
    public int bfs(int n, int r, int[][] picture){
        int cnt = 1;
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(n, r));
        visited[n][r] = true;
        
        while(!q.isEmpty()){
            Pos now = q.poll();
            
            for(int d = 0; d<4; d++){
                int nr = now.x + dr[d];
                int nc = now.y + dc[d];
                if(nr >= 0 && nc >= 0 && nr < picture.length  && nc < picture[0].length && !visited[nr][nc] && picture[nr][nc] == picture[n][r]){
                    q.add(new Pos(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
                        
            }
        }
        return cnt;
    }
}