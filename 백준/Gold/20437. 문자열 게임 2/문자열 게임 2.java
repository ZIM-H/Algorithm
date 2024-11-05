import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            Map<Character, List<Integer>> map = new HashMap<>();

            for(int i=0; i<w.length(); i++){
                char c = w.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c, new LinkedList<>());
                }

                map.get(c).add(i);
            }

            int min = 98765, max = -1;
            for(List<Integer> li : map.values()){
                if(li.size() < k) continue;
                for(int i=0; i<=li.size() - k; i++){
                    int len = li.get(i + k -1) - li.get(i) + 1;
                    min = Math.min(min, len);
                    max = Math.max(max, len);
                }
            }

            StringBuilder sb = new StringBuilder();
            if(max == -1) sb.append(-1);
            else sb.append(min).append(" ").append(max);

            System.out.println(sb.toString());
        }
    }
}