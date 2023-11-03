import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node implements Comparable<Node> {
        int idx = 0;
        int cost = 0;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<Node>[] graph;
    static int n, start;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        dijkstra();

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }

    }

    private static void dijkstra() {
        boolean[] check = new boolean[n+1];
        dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowV = pq.poll().idx;

            if(check[nowV]) continue;
            check[nowV] = true;

            for(Node next : graph[nowV]){
                if(dist[next.idx] > dist[nowV] + next.cost){
                    dist[next.idx] = dist[nowV]+next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

    }
}