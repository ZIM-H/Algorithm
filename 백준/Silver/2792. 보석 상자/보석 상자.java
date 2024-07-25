import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jewel = new int[m];
        int start = 1, end = 0;

        for(int i=0; i<m; i++){
            jewel[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, jewel[i]);
        }

        int mid = 0, count = 0, now = 0, result = 0;
        while(start <= end){
            mid = (start + end) / 2;
            count = 0;

            for(int i=0; i<m; i++){
                now = jewel[i];

                while (now > 0){
                    now -= mid;
                    count++;
                }
            }

            if(count > n) start = mid + 1;
            else {
                result = mid;
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}