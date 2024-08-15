import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] bench = br.readLine().toCharArray();

        int ans = 0;
        for(int i=0; i<n; i++){
            if(bench[i] == 'P'){
                for(int j = i-k; j<=i+k; j++){
                    if(j>=0 && j<n && bench[j]=='H'){
                        ans++;
                        bench[j] = 'E';
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}