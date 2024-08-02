import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] fruit = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            fruit[i] = Integer.parseInt(st.nextToken());
            m.put(fruit[i], m.getOrDefault(fruit[i], 0)+1);
        }

        if(m.size() == 2 || m.size() == 1) {
            System.out.println(n);
            return;
        }

        int start = 0, end = 0, count = 0;
        int answer = Integer.MIN_VALUE;
        m = new HashMap<>();

        while(end < n){
            m.put(fruit[end], m.getOrDefault(fruit[end], 0)+1);
            end++;
            count++;

            if(m.size() == 2) answer = Math.max(answer, count);

            while(m.size() > 2){
                int f = fruit[start++];
                if(m.get(f) == 1) m.remove(f);
                else m.put(f, m.get(f)-1);

                count--;
            }
        }

        System.out.println(answer);
    }
}