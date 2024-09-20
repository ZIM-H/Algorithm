import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] plan = new int[n];

        int start = 1;
        int end = 10000 * 100000;
        for(int i=0; i<n; i++){
            plan[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, plan[i]);
        }

        while (start < end){
            int mid = (start + end) / 2;
            int use = mid;
            int cnt = 1;

            for(int i=0; i<n; i++){
                if(use - plan[i] < 0){
                    cnt++;
                    use = mid;
                }
                use -= plan[i];
            }
            if(cnt <= m){
                end = mid;
            }
            else {
                start = mid + 1;
            }

        }

        System.out.println(start);
    }
}