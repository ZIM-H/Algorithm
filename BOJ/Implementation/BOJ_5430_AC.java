package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class BOJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int T=0; T<tc; T++) {
			String order = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			String s1 = s.substring(1, s.length()-1);
			String[] num = s1.split(",");
			
			Deque<Integer> deque = new ArrayDeque<>();
			for(int j=0; j<num.length; j++) {
				if(!num[j].equals("")) {
					deque.add(Integer.parseInt(num[j]));
				}
			}
			
			int flag = 0;
			boolean dir = true;
			
			
			for(int i=0; i<order.length(); i++) {
				if(order.charAt(i) == 'R') {
					dir = !dir;
				}
				else{
					if(dir && deque.size()>0) {
						deque.removeFirst();
					}
					else if(!dir && deque.size()>0){
						deque.removeLast();
					}
					else {
						flag = 1;
						break;
					}
				}
			}
			
			if(flag == 1) System.out.println("error");
			else {
				if(dir) System.out.println(deque);
				else {
					StringBuilder sb = new StringBuilder();
					sb.append("[");
					while(!deque.isEmpty()) {
						sb.append(deque.removeLast());
						if(deque.size() != 0) sb.append(",");
					}
					sb.append("]");
					System.out.println(sb);
				}
			}
		}
	}
}
