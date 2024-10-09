import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Pos {
        int r, c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] display = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                display[i][j] = (R + G + B) / 3;
            }
        }
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                display[i][j] = display[i][j] >= t ? 255 : 0;
            }
        }

        int answer = 0;
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(display[i][j] == 255 && !visited[i][j]){
                    bfs(i, j, display);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int i, int j, int[][] display){
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(i, j));
        visited[i][j] = true;

        while(!q.isEmpty()){
            Pos now = q.poll();

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && display[nr][nc] == 255){
                    q.add(new Pos(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}