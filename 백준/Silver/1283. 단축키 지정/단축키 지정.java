import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[26];
        for(int i=0; i<n; i++){
            String option = br.readLine();
            String tmp = option.toLowerCase();
            char[] alpha = tmp.toCharArray();

            boolean isSave = false;
            if(!used[alpha[0] - 97]){
                isSave = true;
                used[alpha[0] - 97] = true;
                option = make(option, 0);
            }

            if(isSave) {
                System.out.println(option);
                continue;
            }

            for(int j=1; j<alpha.length; j++){
                if(alpha[j-1] == ' '){
                    if(!used[alpha[j] - 97]){
                        isSave = true;
                        used[alpha[j] - 97] = true;
                        option = make(option, j);
                        break;
                    }
                }
            }
            if(isSave) {
                System.out.println(option);
                continue;
            }
            for(int j=1; j<alpha.length; j++){
                if(alpha[j-1] == ' ' || alpha[j] == ' ') continue;
                    if(!used[alpha[j] - 97]) {
                        isSave = true;
                        used[alpha[j] - 97] = true;
                        option = make(option, j);
                        break;
                    }
            }
            if(isSave) {
                System.out.println(option);
                continue;
            }
            else System.out.println(option);

        }


    }

    public static String make(String opt, int idx){
        StringBuilder sb = new StringBuilder();
        if(idx == 0){
            sb.append('[').append(opt.charAt(idx)).append(']');
            sb.append(opt.substring(1));
        }
        else{
            sb.append(opt.substring(0, idx));
            sb.append('[').append(opt.charAt(idx)).append(']');
            sb.append(opt.substring(idx+1));
        }

        return sb.toString();

    }
}