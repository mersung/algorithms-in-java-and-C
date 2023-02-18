import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashSet<Character> check = new HashSet<>();
        for(int i = 0; i<s.length(); i++){
            char now = s.charAt(i);
            if(!check.contains(now)){
                answer[i] = -1;
                check.add(now);
                continue;
            }
            for(int j = i-1; j >= 0; j--){
                if(s.charAt(i)==(s.charAt(j))){
                    answer[i] = i-j;
                    break;
                }
            }
        }
        return answer;
    }
}