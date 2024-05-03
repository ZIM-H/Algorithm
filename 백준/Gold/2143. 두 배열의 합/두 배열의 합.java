import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] a = new long[n+1];
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] b = new long[m+1];
        for(int i=1; i<=m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Long> mapA = new HashMap<>();
        Map<Long, Long> mapB = new HashMap<>();

        for(int i=1; i<=n; i++){
            long sum = 0;
            for(int j=i; j<=n; j++){
                sum += a[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0L)+1);
            }
        }

        for(int i=1; i<=m; i++){
            long sum = 0;
            for(int j=i; j<=m; j++){
                sum += b[j];
                mapB.put(sum, mapB.getOrDefault(sum, 0L)+1);
            }
        }

        long answer = 0;
        for(Long key : mapA.keySet()){
            if(mapB.containsKey(t - key)) answer += (mapB.get(t-key) * mapA.get(key));
        }

        System.out.println(answer);
    }
}