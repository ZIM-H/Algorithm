import java.io.*;
import java.util.*;

public class Main {
    public static long nC2(int num){
        return (long) num * (num - 1) / 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] expect = new int[n+1];
        for(int i=1; i<=n; i++){
            expect[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expect);

        long answer = 0;
        for(int i=n; i>=1; i--){
            answer += Math.abs(expect[i] - i);
        }
        System.out.println(answer);
    }
}