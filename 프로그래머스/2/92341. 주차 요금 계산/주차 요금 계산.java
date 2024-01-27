import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        String[][] r = new String[records.length][];
        for(int i=0; i<records.length; i++){
            r[i] = records[i].split(" ");
        }
        
        Arrays.sort(r, new Comparator<String[]>(){
            public int compare(String[] arr1, String[] arr2){
                int num1 = Integer.parseInt(arr1[1]);
                int num2 = Integer.parseInt(arr2[1]);
                return num1 - num2;
            }
        });
        
        String carNum = r[0][1];
        int total = 0;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<r.length; i++){
            if(r[i][2].equals("IN")){
                
                if(!r[i][1].equals(carNum)){
                    ans.add(feeCal(total, fees));
                    total = 0;
                    carNum = r[i][1];
                }
                
                if( i+1 < records.length && r[i+1][1].equals(carNum)){
                    total += cal(r[i+1][0], r[i][0]);
                }
                else{
                    total += cal("23:59", r[i][0]);
                }
            }
            
            if( i+1 >= records.length ) {
                ans.add(feeCal(total, fees));
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    static int cal(String out, String in){
        int h1 = Integer.parseInt(out.substring(0, 2));
        int m1 = Integer.parseInt(out.substring(3));
        int h2 = Integer.parseInt(in.substring(0, 2));
        int m2 = Integer.parseInt(in.substring(3));
        
        return (h1 - h2) * 60 + m1 - m2;
    }
    
    static int feeCal(int total, int[] fees){
        if(total <= fees[0]) return fees[1];
        
        int tax = (int)Math.ceil((total - fees[0]) / (double)fees[2]) * fees[3]; 
        return tax += fees[1];
    }
}