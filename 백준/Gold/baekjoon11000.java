package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

//수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다. 
//
//김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 
//
//참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
//
//수강신청 대충한 게 찔리면, 선생님을 도와드리자!
//
//입력
//첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
//
//이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)
//
//출력
//강의실의 개수를 출력하라.
public class Practice11000 {
	
	static int n;

	
	static LinkedList<Integer[]> lectures = new LinkedList();//
	static PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine()); 
		
		for(int i = 0; i<n; i++) {
			String[] room = br.readLine().split(" ");
			lectures.add(new Integer[] {Integer.valueOf(room[0]), Integer.valueOf(room[1])});
		}
		
		lectures.sort((o1, o2) -> o1[0] - o2[0]);
		
		while(!lectures.isEmpty()) {
			Integer[] room = lectures.poll();
			int lecStart = room[0];
			int lecEnd = room[1];
			
			if(rooms.isEmpty()) { // 비어있으면
				rooms.add(lecEnd);
			}else { // 방이 하나라도 있는 경우
				int roomEnd = rooms.peek();
				if(lecStart >= roomEnd) { //제일 빨리 끝나는 방 보다 시작 시간이 늦으면
					rooms.poll(); // 그 방 차지
					rooms.add(lecEnd);
				}else { // 제일 빨리 끝나는 방도 시작 시간보다 늦을 경우
					rooms.add(lecEnd);
				}
			}
			
		}
		
		System.out.println(rooms.size());
	}

}
