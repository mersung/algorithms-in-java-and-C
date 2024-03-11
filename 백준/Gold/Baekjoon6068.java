package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//성실한 농부 존은 시간을 효율적으로 관리해야 한다는 걸 깨달았다. 그는 N개의 해야할 일에 (1<=N<=1000) 숫자를 매겼다. (우유를 짜고, 마굿간을 치우고, 담장을 고치는 등의)
//
//존의 시간을 효율적으로 관리하기 위해, 그는 끝내야만 하는 일 목록을 만들었다. 완성될 때 필요한 시간을 T_i(1<=T_i<=1,000) 라고 하며, 끝내야하는 시간을 S_i(1<=S_i<=1,000,000) 이라 한다. 농부 존은 하루의 시작을 t = 0으로 정했다. 그리고 일 할 때는 그 일을 마칠 때 까지 그 일만 한다. 
//
//존은 늦잠 자는 걸 좋아한다. 따라서 제 시간에 끝낼 수 있게 결정할 수 있는 한도에서 존이 가장 늦게 일어나도 되는 시간을 출력하라.
//
//입력
//첫 줄에는 일의 개수인 N을 받고
//
//두 번째 줄부터 N+1줄까지 T_i와 S_i를 입력받는다. 
//
//출력
//존이 일을 할 수 있는 마지막 시간을 출력 하라. 존이 제시간에 일을 끝낼 수 없다면 -1 을 출력하라.
//
//예제 입력 1 
//4
//3 5
//8 14
//5 20
//1 16
//예제 출력 1 
//2

public class Practice6068 {
	
	static int n;
	static int time;
	static ArrayList<Node> queue = new ArrayList<>();
	static int answer;
	
	static class Node{
		int needTime;
		int startTime;
		int endedTime;
		
		public Node(int needTime, int endedTime) {
			this.needTime = needTime;
			this.startTime = endedTime - needTime;
			this.endedTime = endedTime;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<n; i++) {
			String[] ts = br.readLine().split(" ");
			queue.add(new Node(Integer.valueOf(ts[0]), Integer.valueOf(ts[1])));
		}
		
		Collections.sort(queue, (o1, o2) -> o1.endedTime - o2.endedTime); // 끝내야하는 시간
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i<queue.size(); i++) {
			// 일처리 시작
			time += queue.get(i).needTime;
			
			if(queue.get(i).endedTime < time) { // 시간이 초과된 경우
				System.out.println("-1");
				System.exit(i);
			}
			
			answer = Math.min(answer, queue.get(i).endedTime - time);
		}
		
		System.out.println(answer);
	}

}



