package Graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
//수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

public class Practice13549 {

	static int answer = Integer.MAX_VALUE;
	static int n;
	static int k;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		
		n = Integer.valueOf(nk[0]);
		k = Integer.valueOf(nk[1]);
		
		visited = new boolean[100000+1];
		
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		LinkedList<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {n, 0});
		
		while(!queue.isEmpty()) {

			Integer[] cc = queue.poll();
			Integer current = cc[0];
			Integer cnt = cc[1];
			visited[current] = true;
			
			if(current == k) {
				answer = Math.min(answer, cnt);
			}
			
			if(2*current <= 100000 && visited[2*current] == false) {
				queue.add(new Integer[] {2*current, cnt});
			}
			
			if(current-1 >= 0 && visited[current-1] == false) {
				queue.add(new Integer[] {current-1, cnt+1});
			}
			
			if(current+1 <= 100000 && visited[current+1] == false) {
				queue.add(new Integer[] {current+1, cnt+1});
			}
		}
	}
	
}
