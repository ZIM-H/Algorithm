import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int n, cost;
        public Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node>[] graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[e].add(new Node(s, cost));
            }

            int[] dist = new int[n+1];
            Arrays.fill(dist, 987654321);
            dist[c] = 0;

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(c, 0));
            int cnt = 0, max = 0;
            boolean[] visited = new boolean[n+1];

            while (!q.isEmpty()){
                Node now = q.poll();
                if(visited[now.n]) continue;

                visited[now.n] = true;
                max = now.cost;
                cnt++;

                for(Node next : graph[now.n]){
                    if(!visited[next.n]){
                        if(dist[next.n] > dist[now.n]+next.cost){
                            dist[next.n] = dist[now.n]+next.cost;
                            q.add(new Node(next.n, dist[next.n]));
                        }
                    }
                }
            }

            System.out.println(cnt+" "+max);
        }


    }
}