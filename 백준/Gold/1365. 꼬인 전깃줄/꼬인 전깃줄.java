import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > memo[len]) memo[++len] = arr[i];
            else memo[binarySearch(0, len, arr[i])] = arr[i];
        }

        System.out.println(n - len);
    }

    public static int binarySearch(int left, int right, int key){
        while(left < right){
            int mid = (left+right)/2;
            if(memo[mid] < key) left = mid+1;
            else right = mid;
        }

        return right;
    }
}