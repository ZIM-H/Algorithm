import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m, x;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
//        도착지 0 부터 시작
        x = Integer.parseInt(st.nextToken()) - 1;
        int[][] revAdj = new int[n][n];
        int[][] adj = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(adj[i], 0);
            Arrays.fill(revAdj[i], 0);
        }

        int[] costArr = new int[n];
        int[] retCostArr = new int[n];
        Arrays.fill(costArr, 987654321);
        Arrays.fill(retCostArr, 987654321);


//        0부터 시작
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            revAdj[end-1][start-1] = value;
            adj[start - 1][end - 1] = value;
        }

//        1. x -> n개의 노드로(그래프 뒤집어서)
        visited = new boolean[n];
        costArr = dstr(revAdj, costArr, x, n);
//        2. x -> n개의 노드로(정방향 그래프로
        visited = new boolean[n];
        retCostArr = dstr(adj, retCostArr, x, n);


        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            ans = Math.max(ans, costArr[i] + retCostArr[i]);
        }
        System.out.println(ans);
    }

    static public int[] dstr(int[][] adj, int[] dist, int x, int n){
        PriorityQueue<Node> ep = new PriorityQueue<>();

        ep.offer(new Node(x, 0));
        dist[x] = 0;
        while (!ep.isEmpty()){
            Node current = ep.poll();
            if(visited[current.nodeNum]){
                continue;
            }
            visited[current.nodeNum] = true;
            for (int next = 0; next<n; next++){
                if(adj[current.nodeNum][next] == 0 || next == x){
                    continue;
                }

//                if(costArr[next] < costArr[current.nodeNum] + adj[current.nodeNum][next])
//                    System.out.println((current.nodeNum+1) + " " + (next+1) + " " + costArr[current.nodeNum] + " " + adj[current.nodeNum][next]);
                dist[next] = Math.min(dist[next], dist[current.nodeNum] + adj[current.nodeNum][next]);
                ep.offer(new Node(next, dist[next]));
            }
//            System.out.println(current);
        }
        return dist;
    }

    static class Node implements Comparable<Node>{

        int nodeNum;
        int weight;
        Node(int n, int w){
            this.nodeNum = n;
            this.weight = w;
        }
        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }
}