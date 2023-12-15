import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            ad.addLast(i);
        }

        int[] num = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i=0; i<m; i++){
            int cnt = 0;
            int flag = 0;
            Iterator<Integer> iterator = ad.iterator();
            while (iterator.hasNext()){
                cnt++;
                Integer elem = iterator.next();
                if(elem == num[i]) break;
                if(cnt >= ad.size()/2 + 1) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                while (true){
                    if (ad.peekLast() == num[i]){
                        break;
                    }
                    ad.addFirst(ad.pollLast());
                    ans += 1;
                }
                ad.pollLast();
                ans += 1;
            }

            else {
                while (true){
                    if (ad.peekFirst() == num[i]){
                        break;
                    }
                    ad.addLast(ad.pollFirst());
                    ans += 1;
                }
                ad.pollFirst();
            }
        }


        System.out.println(ans);
    }
}
