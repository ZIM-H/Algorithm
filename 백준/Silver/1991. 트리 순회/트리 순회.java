import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Character, char[]> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char[] c = {st.nextToken().charAt(0), st.nextToken().charAt(0)};
            tree.put(node, c);
        }
        System.out.println(pre('A'));
        System.out.println(in('A'));
        System.out.print(post('A'));
    }

    private static String post(char node) {
        StringBuilder result = new StringBuilder();
        for(char n : tree.get(node)){
            if(n == '.') continue;
            result.append(post(n));
        }
        result.append(node);
        return result.toString();
    }

    public static String in(char node){
        StringBuilder result = new StringBuilder();
        if(tree.get(node)[0] != '.') result.append(in(tree.get(node)[0]));
        result.append(node);
        if(tree.get(node)[1] != '.') result.append(in(tree.get(node)[1]));
        return result.toString();
    }

    public static String pre(char node){
        StringBuilder result = new StringBuilder();
        result.append(node);
        for(char n : tree.get(node)){
            if(n == '.') continue;
            result.append(pre(n));
        }
        return result.toString();
    }
}