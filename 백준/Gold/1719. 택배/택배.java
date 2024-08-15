import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int idx, val;
        public Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
        @Override
        public int compareTo(Node n){
            return this.val - n.val;
        }
    }
    static int n;
    static List<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, val));
            graph[end].add(new Node(start, val));
        }

        int[][] fast = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            dijkstra(i, fast);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(fast[i][j]==0) System.out.print('-'+" ");
                else System.out.print(fast[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void dijkstra(int start, int[][] fast){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, 999999);
        dist[start] = 0;


        q.add(new Node(start, 0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(visited[now.idx]) continue;
            visited[now.idx] = true;

            for(Node next : graph[now.idx]){
                if(dist[next.idx] > dist[now.idx] + next.val){
                    dist[next.idx] = dist[now.idx] + next.val;

                    if(now.idx == start) fast[start][next.idx] = next.idx;
                    else fast[start][next.idx] = fast[start][now.idx];

                    q.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

    }
}