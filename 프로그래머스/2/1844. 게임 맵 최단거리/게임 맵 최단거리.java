import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static class Pos{
        int x;
        int y;
        int cnt;
        public Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] check = new boolean[maps.length][maps[0].length];
        
        q.add(new Pos(0,0,1));
        check[0][0] = true;
        
        int flag = 0;
        while(!q.isEmpty()){
            Pos now = q.poll();
            if(now.x == maps.length-1 && now.y == maps[0].length-1){
                answer = Math.min(now.cnt, answer);
                flag = 1;
                continue;
            }
            
            for(int d = 0; d<4; d++){
                int nr = now.x + dr[d];
                int nc = now.y + dc[d];
                if(nr >= 0 && nr < maps.length && nc >=0 && nc < maps[0].length && maps[nr][nc] != 0 && !check[nr][nc]){
                    q.add(new Pos(nr, nc, now.cnt + 1));
                    check[nr][nc] = true;
                }
            }
        }
        if(flag == 0) return -1;
        
        return answer;
    }
}