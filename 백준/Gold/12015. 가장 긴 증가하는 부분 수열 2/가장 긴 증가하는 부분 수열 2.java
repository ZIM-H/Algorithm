import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] memo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        memo = new long[n];
        int len = 0;

        for(int i = 0; i < n; i++) {
            if(len == 0 || num[i] > memo[len - 1]) {
                memo[len++] = num[i];
            } else {
                memo[check(0, len, num[i])] = num[i];
            }
        }

        System.out.println(len); 
    }

    private static int check(int start, int end, long value) {
        while(start < end) {
            int mid = (start + end) / 2;

            if(memo[mid] < value)
                start = mid + 1;
            else
                end = mid;
        }
        return end;
    }
}