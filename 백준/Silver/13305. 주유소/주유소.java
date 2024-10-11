import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dis = new int[n];
        int[] cost = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = cost[0];
        long total = 0;
        
        for(int i=0; i<n-1; i++){
            minCost = Math.min(minCost, cost[i]);
            total += minCost * dis[i];
        }

        System.out.println(total);
    }
}