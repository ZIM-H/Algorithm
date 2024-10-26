import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class File{
        int value, idx;
        public File(int value, int idx){
            this.value = value;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] seq = new int[n];
            Queue<File> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                seq[i] = Integer.parseInt(st.nextToken());
                q.add(new File(seq[i], i));
            }

            Arrays.sort(seq);
            int idx = n-1, answer = 1;

            while(!q.isEmpty()){
                int check = seq[idx];
                File now = q.poll();
                if(now.value == check){
                    if(now.idx == m) break;
                    else {
                        idx--;
                        answer++;
                    }
                }
                else q.add(now);
            }

            System.out.println(answer);
        }
    }
}