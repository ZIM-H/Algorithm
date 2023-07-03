package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] words = new char[5][];
		int maxLen = Integer.MIN_VALUE;
		
		for(int i=0; i<5; i++) {
			words[i] = br.readLine().toCharArray();
			if(words[i].length > maxLen) maxLen = words[i].length;
		}
		
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<maxLen; i++) {
			for(int j=0; j<5; j++) {
				if(words[j].length <= i) {
					result.append("");
					continue;
				}
				
				result.append(words[j][i]);
			}
		}
		System.out.println(result);
		
	}
}
