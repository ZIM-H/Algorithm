import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Beer implements Comparable<Beer>{
        int v, c;
        public Beer(int v, int c){
            this.v = v;
            this.c = c;
        }
        @Override
        public int compareTo(Beer o){
            return this.c == o.c ? o.v - this.v : this.c - o.c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Beer> arr = new ArrayList<>();
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            arr.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arr);

        Queue<Integer> q = new PriorityQueue<>();
        int sum = 0, result = -1;
        for(Beer b : arr){
            q.add(b.v);
            sum += b.v;

            if(q.size() > n) sum -= q.poll();

            if(q.size() == n && sum >= m) {
                result = b.c;
                break;
            }
        }

        System.out.println(result);


    }
}