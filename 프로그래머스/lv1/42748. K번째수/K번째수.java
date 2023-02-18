import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] c : commands){
            int i = c[0];
            int j = c[1];
            int k = c[2];
            List<Integer> temp = new ArrayList<>();
            // 자르기
            for(int a = i-1; a<=j-1; a++){
                temp.add(array[a]);
            }
            Collections.sort(temp);
            answer.add(temp.get(k-1));
        }
        int[] ans = new int[answer.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}