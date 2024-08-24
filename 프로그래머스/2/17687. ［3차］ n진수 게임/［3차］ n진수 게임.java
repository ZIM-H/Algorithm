class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(sb.length() >= t*m - (m-p)) break;
            sb.append(Integer.toString(num++, n));
        }
        
        String tmp = sb.toString();
        System.out.println(tmp);
        for(int i=p-1; i<sb.length(); i+=m){
            if(answer.length() == t) break;
            answer += tmp.charAt(i);
        }
        
        return answer.toUpperCase();
    }
    
}