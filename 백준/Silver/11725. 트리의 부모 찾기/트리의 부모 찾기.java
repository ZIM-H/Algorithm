import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
             st = new StringTokenizer(br.readLine());
             int s = Integer.parseInt(st.nextToken());
             int e = Integer.parseInt(st.nextToken());

             list[s].add(e);
             list[e].add(s);
        }

        bfs(1);

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()){
            int now = q.poll();

            for(int node : list[now]){
                if(!visited[node]){
                    parent[node] = now;
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
    }
}