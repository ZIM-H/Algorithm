import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] doll = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            doll[i] = Integer.parseInt(st.nextToken());
        }

        int lioncnt = 0;
        int start = 0, end = 0;
        int answer = Integer.MAX_VALUE;

        while(end < n){
            if(doll[end++] == 1) lioncnt++;

            while(lioncnt >= k){
                answer = Math.min(answer, end - start);
                if(doll[start++] == 1) lioncnt--;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}