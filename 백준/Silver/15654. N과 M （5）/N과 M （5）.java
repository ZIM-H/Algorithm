import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] num;
    static String[] str;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = String.valueOf(num[i]);
        }


        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs("", 0, used, result);

        for(String s : result){
            System.out.println(s);
        }

    }

    public static void dfs(String current, int depth, boolean[] used, List<String> result){
        if(depth == m) {
            result.add(current.trim());
            return;
        }

        for(int i=0; i<n; i++){
            if(used[i]) continue;

            used[i] = true;
            dfs(current+" "+str[i], depth+1, used, result);
            used[i] = false;
        }

    }
}