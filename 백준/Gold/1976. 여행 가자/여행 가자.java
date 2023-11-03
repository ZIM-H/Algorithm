import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x > y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x){
        if(x == parent[x]) return x;
        return find(parent[x]);
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=0; i<m-1; i++){
            if(start != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
}