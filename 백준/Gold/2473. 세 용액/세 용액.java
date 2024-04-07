import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] num = new long[n];
        for(int i=0; i<n; i++){
            num[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(num);

        long min = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0, ans3 = 0;
        for(int i=0; i<n-2; i++){
            int left = i+1, right = n-1;

            while (left < right){
                long val = (long) num[i] + num[left] + num[right];
                if(min > Math.abs(val)){
                    min = Math.abs(val);
                    ans1 = num[i];
                    ans2 = num[left];
                    ans3 = num[right];
                }
                if(val == 0) break;
                else if (val > 0) right--;
                else left++;
            }
        }

        System.out.println(ans1 + " "+ans2 + " "+ans3 + " ");
    }
}