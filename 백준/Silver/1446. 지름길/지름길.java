import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dp = new int[d+1];
        for(int i=1; i<=d; i++){
            dp[i] = i;
        }

        List<int[]> road = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            if(end <= d) road.add(new int[] {start, end, dis});
        }

        for(int i=1; i<=d; i++){
            dp[i] = Math.min(dp[i-1]+1, dp[i]);

            for(int[] r : road){
                int start = r[0];
                int end = r[1];
                int dis = r[2];

                if(end == i){
                    dp[i] = Math.min(dp[i], dp[start]+dis);
                }
            }
        }

        System.out.println(dp[d]);
    }
}