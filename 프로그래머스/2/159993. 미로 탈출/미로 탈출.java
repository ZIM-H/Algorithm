import java.util.*;
class Solution {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static char[][] map;
    static int answer, flag;
    static Pos now;
    static class Pos implements Comparable<Pos>{
        int r;
        int c;
        int time;
        public Pos(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
        @Override
        public int compareTo(Pos o){
            return this.time - o.time;
        }
    }
    public int solution(String[] maps) {
        answer = -1;
        flag = 0;
        
        map = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    now = new Pos(i,j,0);
                }
            }
        }
        
        move('L');
        if(flag == 1) {
            answer = -1;
            move('E');
        }
        
        
        return answer;
    }
    static void move(char point){
        boolean[][] visited = new boolean[map.length][map[0].length];
        PriorityQueue<Pos> q = new PriorityQueue<>();
        
        q.add(now);
        visited[now.r][now.c] = true;
        
        while(!q.isEmpty()){
            now = q.poll();
            
            if(map[now.r][now.c] == point){
                flag = 1;
                answer = now.time;
                break;
            }
            
            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length && !visited[nr][nc] && map[nr][nc] != 'X'){
                    q.add(new Pos(nr, nc, now.time+1));
                    visited[nr][nc] = true;
                }
            }
            
        }
    }
}