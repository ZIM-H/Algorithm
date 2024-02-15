import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Top{
        int idx;
        int height;
        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Top> d = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            Top now = new Top(i+1, Integer.parseInt(st.nextToken()));
            while (!d.isEmpty() && now.height >= d.peekLast().height) d.pollLast();

            if(d.isEmpty()) sb.append(0).append(" ");
            else sb.append(d.peekLast().idx).append(" ");

            d.add(now);
        }
        System.out.println(sb);
    }
}