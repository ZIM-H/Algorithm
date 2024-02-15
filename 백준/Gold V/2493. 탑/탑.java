import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Tower> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            Tower now = new Tower(i, Integer.parseInt(st.nextToken()));

            // 스택이 비어있지않고, 현재 탑보다 작은 경우 다 지움
            while(!s.isEmpty() && s.peek().height < now.height){
                s.pop();
            }

            // 스택 비어있는 경우 비교 대상이 없으므로 0
            if(s.isEmpty()) sb.append("0 ");

            // 현재보다 큰 탑의 인덱스 번호
            else sb.append(s.peek().idx+" ");

            // 현재 탑 스택에 넣기
            s.push(now);
        }

        System.out.println(sb.toString());

    }

    static class Tower {
        int idx, height;

        public Tower(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
}
