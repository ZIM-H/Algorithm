import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        for(int t=0; t<test; t++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[][] value = new int[2][n];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][n];
            dp[0][0] = value[0][0];
            dp[1][0] = value[1][0];
            
            if(n > 1) {
                dp[0][1] = value[0][1] + value[1][0];
                dp[1][1] = value[1][1] + value[0][0];

                for (int i = 2; i < n; i++) {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + value[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + value[1][i];
                }
            }

            System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));

        }

    }
}