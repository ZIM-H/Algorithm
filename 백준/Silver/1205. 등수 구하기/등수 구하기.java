import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        if(n == p && t <= num[n-1]){
            System.out.println(-1);
        }
        else{
            int rank = 1;
            for(int i=0; i<n; i++){
                if(t < num[i]) rank++;
                else break;
            }
            System.out.println(rank);
        }

    }
}