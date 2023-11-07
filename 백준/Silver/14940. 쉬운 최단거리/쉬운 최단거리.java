import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, desR, desC;
    static int[][] map, tmp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;

    public static class Pos {
        int r = 0;
        int c = 0;
        int value = 0;

        public Pos(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        tmp = new int[n][m];

        desR = 0;
        desC = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    desR = i;
                    desC = j;
                }
                else if (map[i][j] == 1) tmp[i][j] = -1;
            }
        }
        visited = new boolean[n][m];
        bfs(desR, desC);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
    }



    private static void bfs(int i, int j) {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(i, j, 0));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && map[nr][nc] == 1) {
                    q.add(new Pos(nr, nc, now.value + 1));
                    visited[nr][nc] = true;
                    tmp[nr][nc] = now.value + 1;
                }
            }
        }

    }
}