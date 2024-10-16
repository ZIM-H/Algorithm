import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Word implements Comparable<Word>{
        String w;
        int cnt;
        public Word(String w, int cnt){
            this.w = w;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o){
            if(this.cnt != o.cnt) return o.cnt - this.cnt;
            if(this.w.length() != o.w.length()) return o.w.length() - this.w.length();
            return this.w.compareTo(o.w);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String s = br.readLine();
            if (s.length() >= m) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> e : map.entrySet()){
            pq.add(new Word(e.getKey(), e.getValue()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!pq.isEmpty()){
            bw.write(pq.poll().w + "\n");
        }

        bw.flush();
        bw.close();
    }
}