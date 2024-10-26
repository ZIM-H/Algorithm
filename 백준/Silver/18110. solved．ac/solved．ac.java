import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            System.out.println(0);
            return;
        }

        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int limit = (int)Math.round(n * 0.15);
        int start = limit;
        int end = n - start;

        double sum = 0;
        for(int i=start; i<end; i++){
            sum += nums[i];
        }

        double avg = end - start > 0 ? sum / (end - start) : 0;

        System.out.println(Math.round(avg));
    }
}