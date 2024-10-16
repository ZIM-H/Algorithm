import java.io.*;
import java.util.*;

public class Main {
    static int[][] num;
    static boolean[] visited;
    static Set<Integer> first, second, answer, tmp;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n+1][2];
        tmp = new HashSet<>();
        for(int i=1; i<=n; i++){
            num[i][0] = i;
            num[i][1] = Integer.parseInt(br.readLine());
            if(num[i][0] == num[i][1]) tmp.add(num[i][1]);
        }

        visited = new boolean[n+1];
        answer = new TreeSet<>();
        int flag = 0;
        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            cnt = 0;
            flag = 0;
            first = new HashSet<>();
            second = new HashSet<>();
            dfs(i, 0);
            for(int f : first){
                if(!second.contains(f)) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) continue;
            answer.addAll(second);
        }

        answer.addAll(tmp);

        System.out.println(answer.size());
        for(int i : answer){
            System.out.println(i);
        }
    }

    private static void dfs(int i, int dep) {
        if(visited[i]) {
            cnt = dep;
            return;
        }
        first.add(i);
        second.add(num[i][1]);
//        System.out.println(first);
//        System.out.println(second);
        visited[i] = true;
        dfs(num[i][1], dep + 1);
    }
}