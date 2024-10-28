import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        
        int max = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int node : graph[now]){
                if(!visited[node]){
                    visited[node] = true;
                    q.add(node);
                    dist[node] = dist[now] + 1;
                    max = Math.max(max, dist[node]);
                }
            }
        }
        
        
        for(int i : dist){
            if(i == max) answer++;
        }
        return answer;
    }
}