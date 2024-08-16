import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int sum = 0, result = Integer.MIN_VALUE;
        while(end < n){
            sum += temp[end++];
            if(end - start == k){
                result = Math.max(result, sum);
                sum -= temp[start++];
            }
        }

        System.out.println(result);
    }
}