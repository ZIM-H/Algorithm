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
        Arrays.sort(num);

        int start, end, val, answer = 0;
        for(int i=0; i<n; i++){
            start = 0;
            end = n-1;
            while(start < end){
                if(end == i) end--;
                if(start == i) start++;

                if(start == end) break;

                val = num[start] + num[end];

                if(val == num[i]){
                    answer++;
                    break;
                }
                else if(val > num[i]) end--;
                else start++;
            }
        }

        System.out.println(answer);
    }
}