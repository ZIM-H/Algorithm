import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos implements Comparable<Pos> {
        int x;
        int time;

        public Pos(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        boolean[] check = new boolean[140000];
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.add(new Pos(n, 0));

        int ans = 0;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            if(check[now.x]) continue;
            check[now.x] = true;

            if (now.x == k) {
                ans = now.time;
                break;
            }

            // x-1
            if (now.x - 1 >= 0 ) {
                q.add(new Pos(now.x - 1, now.time + 1));
            }

            // x+1
            if (now.x + 1 <= 100000 ) {
                q.add(new Pos(now.x + 1, now.time + 1));
            }

            // x*2
            if (now.x * 2 <= 100000 ) {
                q.add(new Pos(now.x * 2, now.time));
            }
        }

        System.out.println(ans);
    }
}