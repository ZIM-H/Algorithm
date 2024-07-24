import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;

        int[] lec = new int[n];
        st =  new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            lec[i] = Integer.parseInt(st.nextToken());   
            start = Math.max(start, lec[i]);
            end += lec[i];
        }

        int mid = 0, count = 0, sum = 0;
        while(start <= end){
            mid = (start + end) / 2;
            count = 0;
            sum = 0;

            for(int i=0; i<n; i++){
                if(sum + lec[i] > mid){
                    sum = 0;
                    count++;
                }

                sum += lec[i];
            }

            // 남아있는 강의 count에 추가
            if(count > 0) count++;

            if(count > m) start = mid + 1;
            else end = mid - 1;

        }

        System.out.println(start);
    }
}