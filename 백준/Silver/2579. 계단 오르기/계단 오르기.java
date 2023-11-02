import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 1) {
            dp[0][0] = stair[0];
            dp[0][1] = stair[0];
        }

        if (n >= 2) {
            dp[1][0] = stair[1];
            dp[1][1] = stair[0] + stair[1];
        }

        if (n >= 3) {
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stair[i];
                dp[i][1] = dp[i - 1][0] + stair[i];
            }
        }

        int max = Math.max(dp[n - 1][0], dp[n - 1][1]);
        System.out.println(max);
    }
}