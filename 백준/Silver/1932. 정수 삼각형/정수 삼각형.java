import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] value = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        value[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    value[i][j] = value[i - 1][j] + arr[i][j];
                } else if (i == j) {
                    value[i][j] = value[i - 1][j - 1] + arr[i][j];
                }
                else{
                    value[i][j] = Math.max(value[i - 1][j - 1] + arr[i][j], value[i - 1][j] + arr[i][j]);
                }
            }
        }

        Arrays.sort(value[n-1]);
        System.out.println(value[n-1][n-1]);
    }
}