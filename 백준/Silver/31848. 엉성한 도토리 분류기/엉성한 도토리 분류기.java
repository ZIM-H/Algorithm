import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int[] size = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = 0;
        for(int i=0; i<n; i++){
            int s = Integer.parseInt(st.nextToken());
            if(s + i > prev) prev = s + i;
            size[i] = prev;
        }

        int m = Integer.parseInt(br.readLine());
        int[] answer = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int acorn = Integer.parseInt(st.nextToken());

            int start = 0, end = n;

            while(start < end){
                int mid = (start + end)/2;

                if(size[mid] >= acorn) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }

            answer[i] = end+1;
        }


        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}