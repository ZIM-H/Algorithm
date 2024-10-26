import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long[] audit = new long[n];
        long start = 1, end = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            audit[i] = Integer.parseInt(br.readLine());
            end = Math.min(end, audit[i]);
        }

        end *= m;

        while(start < end){
            long mid = (start + end) / 2;

            if(isPoss(mid, audit)){
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static boolean isPoss(long mid, long[] audit) {
        int total = 0;
        for(long a : audit){
            total += mid / a;
            if(total >= m) return true;
        }

        return total >= m;
    }
}