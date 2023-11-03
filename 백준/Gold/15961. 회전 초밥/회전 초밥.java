import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 주어진 초밥
		int d = Integer.parseInt(st.nextToken()); // 초밥 종류
		int k = Integer.parseInt(st.nextToken()); //연속으로 먹을 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰
		
		int[] susi = new int[n];
		int[] kind = new int[d+1]; 
		
		//초밥 입력 받기
		for(int i=0; i<n; i++) {
			susi[i] = Integer.parseInt(br.readLine());
		}
		
		//먹은 종류 처음 초기화
		int len = 1; // 먹은 초밥의 가짓수, 쿠폰은 항상 먹으니까 1로 초기화
		kind[c] = 1; // 쿠폰으로 먹은 초밥 항상 고정
		for(int i=0; i<k; i++) {
			if(kind[susi[i]]==0) {
				len++;
			}
			kind[susi[i]]++;
		}
		
		
		// i는 연속 첫번째 초밥, end는 연속 마지막 초밥
		int end = k; 
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			//초밥 변경 생기기 전에 max 값 갱신
			max = Math.max(max, len);
			
			//맨 앞 초밥 빼기
			kind[susi[i]]--;
			if(kind[susi[i]]==0) { // 초밥이 먹은 개수가 0이라면 가짓수 감소
				len--;
			}
			
			//맨 뒤 초밥 추가하기
			if(kind[susi[end%n]] == 0) { //새로운 초밥 종류라면 가짓수 증가
				len++;
			}
			kind[susi[end%n]]++;
			end++;
		}
		
		System.out.println(max);
	}
}
