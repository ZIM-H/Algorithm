import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char[] ch = str.toCharArray();

        int aCnt = 0, bCnt = 0;
        for(char c : ch){
            if(c == 'a') aCnt++;
        }

        int answer = 1001;
        for(int i=0; i<len; i++){
            bCnt = 0;
            for(int j=i; j<i+aCnt; j++){
                if(ch[j%len] == 'b') bCnt++;
            }

            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);
    }
}