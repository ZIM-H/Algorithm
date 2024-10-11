import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] num = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            int max = num[n-1];
            long total = 0;
            for(int i=n-2; i>=0; i--){
                max = Math.max(max, num[i]);

                if(num[i] < max){
                    total += max - num[i];
                }
            }

            System.out.println(total);
        }
        
    }
}