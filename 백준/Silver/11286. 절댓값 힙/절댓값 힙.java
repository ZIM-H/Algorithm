import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static class Num implements Comparable<Num>{
        int v;
        public Num(int v){
            this.v = v;
        }

        @Override
        public int compareTo(Num o) {
            return Math.abs(this.v) == Math.abs(o.v) ? this.v - o.v : Math.abs(this.v) - Math.abs(o.v);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Num> q = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if(q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll().v);
            }
            else {
                q.add(new Num(x));
            }
        }
    }
}