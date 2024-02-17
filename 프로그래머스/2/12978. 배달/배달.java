import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int answer = N;

        List<Node>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<road.length; i++){
            graph[road[i][0]].add(new Node(road[i][1], road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, 556789);
        dist[1] = 0;
        boolean[] visited = new boolean[N+1];
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visited[now.v]) continue;
            visited[now.v] = true;
            
            for(Node i : graph[now.v]){
                if(dist[i.v] > dist[now.v] + i.cost){
                    dist[i.v] = dist[now.v] + i.cost;
                    q.add(new Node(i.v, dist[i.v]));
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dist[i] > K) answer--;
        }

        return answer;
    }
}