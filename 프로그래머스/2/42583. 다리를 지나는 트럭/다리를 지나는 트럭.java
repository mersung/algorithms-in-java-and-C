import java.util.*;
class Solution {
    static ArrayDeque<Integer> waitedQueue = new ArrayDeque();
    static ArrayDeque<int[]> runningQueue = new ArrayDeque();
    static ArrayDeque<Integer> endedQueue = new ArrayDeque();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        for(int i = 0; i<truck_weights.length; i++){
            waitedQueue.add(truck_weights[i]);
        }

        while(!waitedQueue.isEmpty() || !runningQueue.isEmpty()){
            
            if(!runningQueue.isEmpty()){
                if(answer >= runningQueue.peekFirst()[1] + bridge_length) runningQueue.pollFirst();
            }
            
            //다리에 트럭 올릴 수 있으면 올림. 무게와 현재 시각
            if(!waitedQueue.isEmpty() && getSum(runningQueue) + waitedQueue.peekFirst() <= weight && runningQueue.size()+1 <= bridge_length ){
                answer += 1;
                    runningQueue.add(new int[] {waitedQueue.pollFirst(), answer});
        }else{//못 올리면, 다리를 지날때 까지 대기
                if(!runningQueue.isEmpty()) {
                int[] node = runningQueue.pollFirst();
                endedQueue.add(node[0]);
                answer = node[1] + bridge_length; // 들어온 시간 + 걸리는 시간
            }
                if(!waitedQueue.isEmpty() && getSum(runningQueue) + waitedQueue.peekFirst() <= weight && runningQueue.size()+1 <= bridge_length ){
                    runningQueue.add(new int[] {waitedQueue.pollFirst(), answer});
        }
            }     
            
        }
        return answer;
    }

    static int getSum(ArrayDeque<int[]> queue){
        int s = 0;
        for(int[] i : queue){
            s += i[0];
        }
        return s;
    }
}
    