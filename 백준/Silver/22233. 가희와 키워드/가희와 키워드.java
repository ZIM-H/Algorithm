import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> words = new HashSet<>();
        for(int i=0; i<n; i++){
            words.add(br.readLine());
        }

        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(",");
            int cnt = words.size();
            for(String s : str){
                if(words.contains(s)) {
                    words.remove(s);
                    cnt--;
                }
            }
            System.out.println(cnt);
        }


    }
}