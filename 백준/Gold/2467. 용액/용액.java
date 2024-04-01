import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];
        int start = 0, end = n-1;
        long value = 0;
        int min = Integer.MAX_VALUE;
        while(start < end){
            value = num[end] + num[start];
            if(Math.abs(value) <= min) {
                answer[0] = num[start];
                answer[1] = num[end];
                min = Math.abs(num[start] + num[end]);
            }

            if(value >= 0) end--;
            else start++;
        }
        System.out.println(answer[0]+" "+answer[1]);

    }
}