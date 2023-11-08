import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] relation = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(relation[i], 999999);
            for (int j = 1; j <= n; j++) {
                if (i == j) relation[i][j] = 0;
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = 1;
            relation[b][a] = 1;
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if( i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if(i == j || k == j) continue;
//                    System.out.println("현재 출발지 "+i + " 경유지 "+k + " 도착지 "+j);
                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
//                    System.out.println("결정 "+relation[i][j]);
                }
            }
        }

        ArrayList<Integer> minPeople = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=1; j<=n; j++){
                if(i != j) {
                    sum += relation[i][j];
                }
            }
            if(sum < min) {
                min = sum;
            }
            numList.add(sum);
        }


        for(int i=0; i<numList.size(); i++){
            if(numList.get(i) == min){
                minPeople.add(numList.indexOf(min));
            }
        }




        System.out.println(Collections.min(minPeople)+1);
    }
}