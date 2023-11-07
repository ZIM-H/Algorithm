import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt;
    static char[][] map;
    static class Pos {
        int r=0;
        int c = 0;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        int x = 0;
        int y =0;
        cnt = 0;

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'I'){
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        if(cnt == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(cnt);

    }

    static void bfs(int r, int c){
        boolean[][] visited = new boolean[n][m];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(r, c));
        visited[r][c] = true;


        while (!q.isEmpty()){
            Pos now = q.poll();

            if(map[now.r][now.c] == 'P'){
                cnt++;
            }

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr >=0 && nc>=0 && nr <n && nc <m && !visited[nr][nc] && map[nr][nc] != 'X'){
                    q.add(new Pos(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}