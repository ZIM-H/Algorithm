import java.io.*;
import java.util.*;

public class Main {
    static int[] spot;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        spot = new int[n+2];
        spot[n+1] = 1000000000;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            spot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(spot);


        int min = 0;
        int max = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int lineStart = Integer.parseInt(st.nextToken());
            int lineEnd = Integer.parseInt(st.nextToken());

            min = findMin(lineStart);
            max = findMax(lineEnd);

            int answer = max - min;
            System.out.println(answer);
        }
    }

    private static int findMin(int value) {
        int left = 1, right = n+1;

        while(left < right){
            int mid = (left + right) / 2;

            if(spot[mid] >= value){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int findMax(int value) {
        int left = 1, right = n+1;

        while(left < right){
            int mid = (left + right) / 2;

            if(spot[mid] > value){
                right = mid;
            }
            else left = mid + 1;
        }

        return left;
    }
}