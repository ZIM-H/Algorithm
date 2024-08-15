import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static char[][] map;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static class Pos implements Comparable<Pos>{
        int r,c,cnt;
        public Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o){
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }

        bfs();
    }

    public static void bfs(){
        boolean[][] visisted = new boolean[n][m];
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.add(new Pos(0,0,0));
        visisted[0][0] = true;

        while (!q.isEmpty()){
            Pos now = q.poll();

            if(now.r == n-1 && now.c == m-1){
                System.out.println(now.cnt);
                break;
            }

            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if(nr >=0 && nc >=0 && nr<n && nc<m && !visisted[nr][nc]){
//                    System.out.println("현재 추가되는 위치 "+nr+" "+nc+" "+map[nr][nc]);
                    if(map[nr][nc] == '1') q.add(new Pos(nr,nc,now.cnt+1));
                    else q.add(new Pos(nr,nc,now.cnt));

                    visisted[nr][nc] = true;
                }
            }
        }
    }
}