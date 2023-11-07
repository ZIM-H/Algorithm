
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] box = new long[n+1];
		box[0] = 1;
		box[1] = 1;
		
		for(int i=2; i<=n; i++) {
			box[i] = (box[i-1]%10007 + box[i-2]%10007)%10007;
		}
		System.out.println(box[n]);
	}
}
