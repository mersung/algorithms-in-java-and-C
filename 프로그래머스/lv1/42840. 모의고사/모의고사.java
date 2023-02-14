import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0,0};
        int[] one = {1,2,3,4,5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) answer[1]++;
            if(answers[i] == two[i%8]) answer[2]++;
            if(answers[i] == three[i%10]) answer[3]++;
        }
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=3; i++){
            max = Math.max(max, answer[i]);
        }
        System.out.println(max);
        for(int i=1; i<=3; i++){
            
            if(answer[i] == max){
                arr.add(i);
            }
        }
        Collections.sort(arr);
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}