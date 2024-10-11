import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dis = new int[n+1];
        int[] cost = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n-1; i++){
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        cost[0] = 1000000001;

        int idx = n-1, cnt = 1;
        long total = 0, tmpDis = 0;

        while(true){
            if(cost[idx] >= cost[idx-1]) {
                cnt++;
                tmpDis += dis[idx];
            }
            else{
                tmpDis += dis[idx];
                total += cost[idx] * tmpDis;
                cnt = 1;
                tmpDis = 0;
            }
            idx--;
            if(idx == 0) break;
        }

        System.out.println(total);
    }
}