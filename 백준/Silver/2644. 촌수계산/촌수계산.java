import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Integer>[] graph;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p].add(c);
            graph[c].add(p);
        }

        visited = new int[n+1];
        int ans = bfs(a,b);
        System.out.println(ans);
    }

    public static int bfs(int start, int end){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == end) {
                return visited[now]-1;
            }

            for(int next : graph[now]){
                if(visited[next] == 0){
                    q.add(next);
                    visited[next] = visited[now]+1;
                }
            }
        }

        return -1;
    }
}