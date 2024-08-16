import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, result;
    static int[] people;
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        people = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        graph = new int[n][];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            graph[i] = new int[cnt];
            for(int j=0; j<cnt; j++){
                graph[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }

        result = Integer.MAX_VALUE;
        boolean[] check = new boolean[n];
        subSet(0, check);

        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
    }

    private static void subSet(int dep, boolean[] check) {
        if(dep == n){
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(check[i]) a.add(i);
                else b.add(i);
            }

            if(isPos(a) && isPos(b)){
                result = Math.min(Math.abs(count(a)-count(b)), result);
            }

            return;
        }

        check[dep] = true;
        subSet(dep + 1, check);
        check[dep] = false;
        subSet(dep + 1, check);

    }

    private static int count(List<Integer> list) {
        int cnt = 0;
        for(int i : list){
            cnt += people[i];
        }
        return cnt;
    }

    private static boolean isPos(List<Integer> list) {
        if(list.size()==0) return false;
        if(list.size()==1) return true;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(list.get(0));
        boolean[] visited = new boolean[n];
        visited[list.get(0)] = true;

        while (!q.isEmpty()){
            int now = q.poll();
            for(int next : graph[now]){
                if(list.contains(next) && !visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        for(int i : list){
            if(!visited[i]) return false;
        }

        return true;
    }
}