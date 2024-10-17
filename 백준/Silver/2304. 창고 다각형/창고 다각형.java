import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] building = new int[n][2];
        int max = 0;
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            building[i][0] = Integer.parseInt(st.nextToken());
            building[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(max, building[i][1]);
        }

        Arrays.sort(building, (o1, o2) -> o1[0] - o2[0]);

        int ans = 0;
        int preL = 0, idxL = 0;
        for(int i=0; i<n; i++){
            if (building[i][1] > preL) {
                ans += (building[i][0]-idxL) * preL;
                preL = building[i][1];
                idxL = building[i][0];
            }
            if(building[i][1] == max) break;
        }

        int preR = 0, idxR = 0;
        for(int i=n-1; i>=0; i--){
            if (building[i][1] > preR) {
                ans += (idxR - building[i][0]) * preR;
                preR = building[i][1];
                idxR = building[i][0];
            }
            if(building[i][1] == max) break;
        }

        ans += ((idxR - idxL)+1) * max;

        System.out.println(ans);

    }
}