import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] i : roads){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        
        int[] result = bfs(graph, destination, n);
        int[] answer = new int[sources.length];
        
        for(int i=0; i<sources.length; i++){
            answer[i] = result[sources[i]];
        }
        
        return answer;
    }
    
    public int[] bfs(List<Integer>[] graph, int destination, int n){
        int[] des = new int[n+1];
        Arrays.fill(des, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(destination);
        des[destination] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i : graph[now]){
                if(des[i] == -1){
                    des[i] = des[now]+1;
                    q.add(i);
                }
            }
            
        }
        return des;
    }
}