import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static class Node{
        int v, w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    static List<Node>[] tree;
    static boolean[] visited;
    static int value, node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new List[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true){
                int v = Integer.parseInt(st.nextToken());
                if(v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(v,w));
            }
        }

        node = 1;
        for(int i=0; i<2; i++){
            value = Integer.MIN_VALUE;
            visited = new boolean[n+1];
            visited[node] = true;
            dfs(node, 0);
        }

        System.out.println(value);
    }

    public static void dfs(int next, int weight){
        if(value < weight){
            value = weight;
            node = next;
        }

        for(Node n : tree[next]){
            if(visited[n.v]) continue;
            visited[n.v] = true;
            dfs(n.v, n.w + weight);
            visited[n.v] = false;
        }
    }
}