import java.io.*;
import java.util.*;

public class Main {
    public static long nC2(int num){
        return (long) num * (num - 1) / 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[3];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < 3) count[num]++;
            else count[2]++;
        }

        long answer = nC2(count[0]) + ((long) count[0] * count[1] * 2) + (long) count[0] * count[2];

        System.out.println(answer);
    }
}