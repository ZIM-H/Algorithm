import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Ice{
        int r, c;
        public Ice(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0}, dc = {0,0,1,-1};
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while(true){
            int cnt = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] > 0 && !visited[i][j]){
                        bfs(i,j, visited);
                        cnt++;
                    }
                }
            }

            if(cnt >= 2) {
                System.out.println(years);
                break;
            }
            else if(cnt == 0) {
                System.out.println(0);
                break;
            }

            melt();
            years++;
        }
    }

    private static void melt() {
        int[][] tmp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] > 0){
                    int sea = 0;

                    for(int d=0; d<4; d++){
                        int nr = i+dr[d];
                        int nc = j+dc[d];
                        if(nr >=0 && nc>=0 && nr<n&& nc<m && map[nr][nc]==0) sea++;
                    }

                    tmp[i][j] = map[i][j]-sea < 0 ? 0 : map[i][j]-sea;
                }
            }
        }

        map = tmp;
    }

    private static void bfs(int i, int j, boolean[][] visited) {
        Queue<Ice> q = new ArrayDeque<>();
        q.add(new Ice(i,j));
        visited[i][j] = true;

        while(!q.isEmpty()){
            Ice now = q.poll();

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr >=0 && nc>=0 && nr<n&& nc<m && !visited[nr][nc] && map[nr][nc] > 0){
                    visited[nr][nc] = true;
                    q.add(new Ice(nr,nc));
                }
            }
        }
    }
}