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
        int m = Integer.parseInt(br.readLine());

        int[][] value = new int[n][n];

        int INF = 10000003;
        for(int i=0; i<n; i++){
            Arrays.fill(value[i], INF);
            for(int j=0; j<n; j++){
                if(i == j) {
                    value[i][j] = 0;
                    break;
                }
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken());

            value[s][e] = Math.min(value[s][e], v);
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    value[i][j] = Math.min(value[i][j] , value[i][k] + value[k][j]);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(value[i][j] == INF) {
                    value[i][j] = 0;
                }
                System.out.print(value[i][j]+" ");
            }
            System.out.println();
        }

    }
}