import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String word = br.readLine();
        String[] alpha = word.split("");
        int answer = 0, len = word.length();

        for(int i=0; i<n-1; i++){
            String str = br.readLine();
            if(Math.abs(word.length() - str.length()) > 1) continue;

            int cnt = 0;
            for(String s : alpha){
                if(str.contains(s)) {
                    str = str.replaceFirst(s, "");
                    cnt++;
                }
            }
            if(str.length() <= 1 && cnt >= len-1) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}