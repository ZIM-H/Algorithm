import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][][] map = new int[n][3][2];
        int num;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                num = Integer.parseInt(st.nextToken());
                map[i][j][0] = num;
                map[i][j][1] = num;
            }
        }

        // 0:최소, 1:최대
        for(int i=1; i<n; i++){
            map[i][0][0] += Math.min(map[i-1][0][0], map[i-1][1][0]);
            map[i][1][0] += Math.min(map[i-1][0][0], Math.min(map[i-1][1][0], map[i-1][2][0]));
            map[i][2][0] += Math.min(map[i-1][1][0], map[i-1][2][0]);

            map[i][0][1] += Math.max(map[i-1][0][1], map[i-1][1][1]);
            map[i][1][1] += Math.max(map[i-1][0][1], Math.max(map[i-1][1][1], map[i-1][2][1]));
            map[i][2][1] += Math.max(map[i-1][1][1], map[i-1][2][1]);
        }

        int max = map[n-1][0][1], min = map[n-1][0][0];
        for(int i=1; i<3; i++){
            max = Math.max(map[n-1][i][1], max);
            min = Math.min(map[n-1][i][0], min);
        }
        System.out.println(max+" "+min);
    }
}