import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int n;
        int v;
        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return (this.v - o.v);
        }
    }
    static ArrayList<Node>[] graph;
    static int N;
    static int[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, v));
        }

        dis = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            dij(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dis[i][X] + dis[X][i]);
        }

        System.out.println(max);

    }

    private static void dij(int start) {
        boolean[] check = new boolean[N+1];
        Arrays.fill(dis[start], 10000000);

        dis[start][start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            if(check[now.n]) continue;
            check[now.n] = true;

            for(Node next : graph[now.n]){
                if(dis[start][next.n] > dis[start][now.n] + next.v){
                    dis[start][next.n] = dis[start][now.n] + next.v;

                    pq.offer(new Node(next.n, dis[start][next.n]));
                }
            }
        }
    }
}