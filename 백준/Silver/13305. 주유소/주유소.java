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
        cost[n-1] = 1000000001;

        int idx = 0, cnt = 0, tmp = 0;
        long total = 0;

        while(true){
            tmp = idx + 1;
            cnt = dis[idx];
            while(cost[idx] <= cost[tmp]){
                cnt += dis[tmp];
                tmp++;
                if(tmp == n-1) break;
            }

            total += cost[idx] * cnt;
            idx = tmp;
            if(idx == n-1) break;
        }

        System.out.println(total);
    }
}