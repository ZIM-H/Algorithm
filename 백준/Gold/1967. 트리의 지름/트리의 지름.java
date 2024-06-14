import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int vertex, value;
        public Node(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
    }
    static List<Node>[] graph;
    static int n, answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new List[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,w));
            graph[e].add(new Node(s,w));
        }


        answer = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    public static void dfs(int node, int sum){
        answer = Math.max(answer, sum);
        for(Node n : graph[node]){
            if(visited[n.vertex]) continue;
            visited[n.vertex] = true;
            dfs(n.vertex, n.value + sum);
            visited[n.vertex] = false;
        }
    }
}