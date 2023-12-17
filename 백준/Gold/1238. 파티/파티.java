import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] value = new int[N+1][N+1];
        int INF = 10000000;
        for(int i=1; i<=N; i++){
            Arrays.fill(value[i], INF);
            value[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            value[s][e] = v;
        }


//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(value[i][j] + "           ");
//            }
//            System.out.println();
//        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(k == i || k == j || i == j) continue;
                    value[i][j] = Math.min(value[i][j], value[i][k]+ value[k][j]);

                }
            }
        }

//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=N; j++){
//                System.out.print(value[i][j] + "           ");
//            }
//            System.out.println();
//        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, value[i][X]+value[X][i]);
        }

        System.out.println(max);

    }
}