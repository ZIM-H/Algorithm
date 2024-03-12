import java.util.*;
class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = 101;
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        
        int count;
        for(int[] wire : wires){
            visited = new boolean[n+1];
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            
            count = dfs(wire[0]);
            answer = Math.min(answer, Math.abs((n-count)-count));
            
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        return answer;
    }
    
    static int dfs(int node){
        visited[node] = true;
        int cnt = 1;
        
        for(int n : graph.get(node)){
            if(!visited[n]) cnt += dfs(n);
        }
        
        return cnt;
    }
    
}