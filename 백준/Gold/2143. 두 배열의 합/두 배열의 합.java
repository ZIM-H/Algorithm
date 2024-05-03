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

        List<Long> listA = new ArrayList<>();
        List<Long> listB = new ArrayList<>();

        for(int i=1; i<=n; i++){
            long sum = 0;
            for(int j=i; j<=n; j++){
                sum += a[j];
                listA.add(sum);
            }
        }

        for(int i=1; i<=m; i++){
            long sum = 0;
            for(int j=i; j<=m; j++){
                sum += b[j];
                listB.add(sum);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int left = 0, right = listB.size()-1;
        long answer = 0;
        while (left < listA.size() && right >= 0){
            long sum = listA.get(left) + listB.get(right);
            if(sum == t) {
                long cntA = 0;
                long cntB = 0;
                long valueA = listA.get(left);
                long valueB = listB.get(right);
                while (left < listA.size() && listA.get(left) == valueA) {
                    left++;
                    cntA++;
                }
                while (right >= 0 && listB.get(right) == valueB) {
                    right--;
                    cntB++;
                }
                answer += cntA * cntB;
            }
            else if(sum < t){
                left++;
            }
            else if(sum > t){
                right--;
            }
        }

        System.out.println(answer);

    }
}