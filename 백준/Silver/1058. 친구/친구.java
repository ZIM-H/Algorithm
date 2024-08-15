import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] value = new int[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                if(i == j) value[i][j] = 0;
                else if(s.charAt(j) == 'Y') value[i][j] = 1;
                else value[i][j] = 9999;
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(j == i || j == k || i == k) continue;
                    value[i][j] = Math.min(value[i][j], value[i][k]+value[k][j]);
                }
            }
        }

        int result = 0, cnt = 0;
        for(int i=0; i<n; i++){
            cnt = 0;
            for(int j=0; j<n; j++){
                if(i != j && value[i][j] <= 2) cnt++;
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);

    }
}