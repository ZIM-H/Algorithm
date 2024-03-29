import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Pos implements Comparable<Pos>{
        int r, c, cnt, check;
        public Pos(int r, int c, int cnt, int check){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.check = check;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(move());
    }

    static int move(){
        PriorityQueue<Pos> q = new PriorityQueue<Pos>();
        boolean[][][] visited = new boolean[n][m][2];
        q.add(new Pos(0,0,1,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Pos now = q.poll();

            if(now.r == n-1 && now.c == m-1){
                return now.cnt;
            }

            for(int d = 0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >= 0 && nc >= 0 && nc < m && nr < n ){
                    // 벽이 아닌 경우
                    if(map[nr][nc] == 0 && !visited[nr][nc][now.check]) {
                        q.add(new Pos(nr, nc, now.cnt+1, now.check));
                        visited[nr][nc][now.check] = true;
                    }
                    // 벽인 경우
                    else{
                        if(!visited[nr][nc][0] && now.check == 0) {
                            q.add(new Pos(nr, nc, now.cnt+1, 1));
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}