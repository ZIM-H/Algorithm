import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int v, c;
        public Node(int v, int c){
            this.v = v;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node o){
            return this.c - o.c;
        }
    }
    static List<Node>[] graph;
    static int nodeCnt;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        nodeCnt = n;
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++){
            graph[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            graph[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] total = new int[n+1], aDis = new int[n+1], bDis = new int[n+1];
        Arrays.fill(total, 98765432);
        Arrays.fill(aDis, 98765432);
        Arrays.fill(bDis, 98765432);
        
        total = dijk(s, total);
        aDis = dijk(a, aDis);
        bDis = dijk(b, bDis);
        
        for(int i=1; i<=n; i++){
            answer = Math.min(total[i]+aDis[i]+bDis[i], answer);
        }
        
        return answer;
    }
    
    public int[] dijk(int start, int[] dis){
        // 여러 경로가 최단 경로를 결정할 수 있는 경우, 방문 체크 제외!
        dis[start] = 0;
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(Node next : graph[now.v]){
                if(dis[next.v] > dis[now.v] + next.c){
                    dis[next.v] = dis[now.v] + next.c;
                    q.add(new Node(next.v, dis[next.v]));
                }
            }
        }
        return dis;
    }
}