import java.util.*;

class Solution {
    static List<String> route;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        route= new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(route);
        
        return route.get(0).split(" ");
    }
    
    public void dfs(String start, String way, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            route.add(way);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], way+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}