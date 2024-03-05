import java.util.*;
class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    static char[][] map;
    static boolean[][] visited;
    static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[] solution(String[] maps) {
        map = new char[maps.length][];
        
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        List<Integer> list = new ArrayList<>();
        visited = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] != 'X' && !visited[i][j]){
                    int n = cal(i,j);
                    if(n != 0) list.add(n);
                }
            }
        }
        
        int[] answer;
        
        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        
        else{
            Collections.sort(list);
            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
    
    static int cal(int i, int j){
        Queue<Pos> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new Pos(i,j));
        int value = 0;
        
        while(!q.isEmpty()){
            Pos now = q.poll();
            value += map[now.r][now.c] - '0';
            
            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length && !visited[nr][nc] && map[nr][nc] != 'X'){
                    visited[nr][nc] = true;
                    q.add(new Pos(nr, nc));
                }
            }
        }
        
        return value;
    }
}