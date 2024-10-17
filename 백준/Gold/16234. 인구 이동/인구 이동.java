import java.io.*;
import java.util.*;

public class Main {
    static class Country{
        int r, c;
        public Country(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int N, L, R, change;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static Set<Integer> first, second, answer, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true){
            visited = new boolean[N][N];
            change = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            if(change == 0) break;
            answer++;
        }

        System.out.println(answer);
    }

    private static void bfs(int i, int j) {
        Queue<Country> q = new ArrayDeque<>();
        Queue<Country> list = new ArrayDeque<>();
        q.add(new Country(i,j));
        list.add(new Country(i,j));
        visited[i][j] = true;
        int avg = map[i][j], cnt = 1;

        while (!q.isEmpty()){
            Country now = q.poll();

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(isConn(nr, nc, now)){
                    avg += map[nr][nc];
                    cnt++;
                    Country c = new Country(nr,nc);
                    q.add(c);
                    list.add(c);
                    visited[nr][nc] = true;
                }
            }
        }


        if(cnt > 1) {
            avg /= cnt;
            for(Country c : list){
                map[c.r][c.c] = avg;
            }
            change += 1;
        }


    }

    private static boolean isConn(int nr, int nc, Country now) {
        if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
            int diff = Math.abs(map[now.r][now.c] - map[nr][nc]);
            if(diff >= L && diff <= R) return true;
        }
        return false;
    }
}