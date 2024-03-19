import java.util.*;
class Solution {
    static class Info implements Comparable<Info>{
        int idx, cnt;
        public Info(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Info o){
            return o.cnt == this.cnt ? this.idx - o.idx : o.cnt - this.cnt;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playCnt = new HashMap<>();
        Map<String, PriorityQueue<Info>> songCnt = new HashMap<>();
        
        for(int i=0; i<plays.length; i++){
            if(!songCnt.containsKey(genres[i])){
                songCnt.put(genres[i], new PriorityQueue<>());
            }
            songCnt.get(genres[i]).add(new Info(i, plays[i]));
            playCnt.put(genres[i] , playCnt.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(playCnt.keySet());
        Collections.sort(keySet, (o1, o2) -> playCnt.get(o2) - playCnt.get(o1));
        
        List<Integer> rank = new ArrayList<>();
        
        for(String genre : keySet){
            if(songCnt.get(genre).size() > 1){
                rank.add(songCnt.get(genre).poll().idx);
            }
            rank.add(songCnt.get(genre).poll().idx);
        }
        
        int[] answer = new int[rank.size()];
        for(int i=0; i<rank.size(); i++){
            answer[i] = rank.get(i);
        }
        
        return answer;
    }
}