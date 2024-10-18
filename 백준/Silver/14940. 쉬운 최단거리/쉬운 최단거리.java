import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n,m;
    static int[][] map, answer;
    static class Pos {
        int r , c, cnt;
        public Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        answer = new int[n][m];


        Pos start = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(answer[i], -1);
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    start = new Pos(i,j,0);
                    answer[i][j] = 0;
                }
                else if(map[i][j] == 0) answer[i][j] = 0;
            }
        }

        bfs(start);


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(Pos start){
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new Pos(start.r, start.c, 0));
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Pos now = q.poll();

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1 && !visited[nr][nc]){
                    q.add(new Pos(nr, nc, now.cnt + 1));
                    visited[nr][nc] = true;
                    answer[nr][nc] = now.cnt + 1;
                }
            }
        }
    }
}