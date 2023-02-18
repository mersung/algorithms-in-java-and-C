import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            if(map.containsKey(t)){
                map.put(t, map.get(t)+1);
            }else{
                map.put(t, 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        // System.out.println(list);
        for(Map.Entry<Integer, Integer> e : list){
            int value = e.getValue();
            k -= value; // 1이상이면 한번 더
            answer++;
            if(k < 1){
                break;
            }
        }
        
        return answer;
    }
}