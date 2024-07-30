import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1299710];
        prime[0] = prime[1] = true;
        for(int i=2; i<=Math.sqrt(1299709); i++){
            if(prime[i]) continue;
            for(int j=i*i; j<prime.length; j = j+i){
                prime[j] = true;
            }
        }

        for(int i=0; i<n; i++){
            int k = Integer.parseInt(br.readLine());
            if(!prime[k]) {
                System.out.println(0);
                continue;
            }
            int start = k;
            int end = k;
            while(prime[start]) start--;

            while(prime[end]) end++;

            System.out.println(end - start);
        }
    }
}