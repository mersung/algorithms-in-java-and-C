class Solution {
    static int answer = 0;
    static int sum = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, numbers.length);
        return answer;
    }
    void dfs(int[] numbers, int idx, int target, int length){
        if(idx == length){
            if(sum == target){
                answer += 1;
            }
            return;
        }
        
        sum += numbers[idx];
        dfs(numbers, idx+1, target, length);
        sum -= numbers[idx];
        
        sum -= numbers[idx];
        dfs(numbers, idx+1, target, length);
        sum += numbers[idx];
        
    }
}