import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        
        arr1 = makeSet(str1, arr1);
        arr2 = makeSet(str2, arr2);
        
        if(arr1.size() == 0 && arr2.size() == 0) return 65536;
        
        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>(arr1);
        
        for(String s : arr1){
            if(arr2.remove(s)) inter.add(s);
        }
        
        for (String s : arr2) {
            union.add(s); 
        }

        double a = inter.size();
        double b = union.size();

        if (b == 0) {
            return 65536;
        } else {
            return (int) ((a / b) * 65536);
        }
    }
    
    public static List<String> makeSet(String str, List<String> arr){
        str = str.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                String s = Character.toString(c1) + Character.toString(c2);
                arr.add(s);
            }
        }
        return arr;
    }
}