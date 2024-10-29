import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int v, cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new LinkedList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        int[] dis = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dis, 98765432);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        dis[1] = 0;

        while (!q.isEmpty()){
            Node now = q.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Node next : graph[now.v]){
                if(dis[next.v] > dis[now.v] + next.cost){
                    dis[next.v] = dis[now.v] + next.cost;
                    q.add(new Node(next.v, dis[next.v]));
                }
            }
        }
        System.out.println(dis[n]);
    }
}