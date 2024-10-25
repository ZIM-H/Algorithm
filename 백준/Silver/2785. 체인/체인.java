import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] chain = new int[n];
        for(int i=0; i<n; i++){
            chain[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chain);

        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            q.add(chain[i]);
        }

        int result = 0;
        while(q.size() > 1){
            result++;
            int n1 = q.pollLast();
            int n2 = q.pollLast();
            q.addLast(n1+n2);

            if(q.size() >= 2){
                int n3 = q.pollFirst();
                if(n3 > 1) q.addFirst(n3-1);
            }
        }

        System.out.println(result);

    }
}