package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

//파티를 좋아하는 민호는 끝없이 파티가 열리는 놀이동산 "민호월드"를 세웠다. 처음에는 한개의 파티장만을 가지고 있는 작은 놀이동산이었지만, 
//사람들의 점점 많이 찾아와 파티장을 증축했고 현재는 N개의 파티장을 가진 큰 놀이동산이 되었다. 
//민호는 파티장을 증축할때마다 편의를 위해 새로운 파티장과 기존의 모든 파티장이 직접적으로 연결이 될 수 있는 도로들을 만들었다. 이때 만들어진 도로들은 사용자들의 편의를 위해 일방통행으로 설계가 되었다.
//
//파티장이 적을때는 괜찮았지만 파티장이 많아진 지금 다음과 같은 두 가지 문제점이 발생했다.
//
//1. A 파티장에서 B 파티장으로 빨리 갈 수 있도록 직접 연결이 된 일방통행 도로를 만들었지만 A와 B가 아닌 다른 파티장을 경유해서 더 빨리 갈 수 있는 경우가 있을 수 있다.
//지금으로부터 C만큼의 시간 뒤에 B번 파티장에서 새롭게 파티가 열리는데 1번과 같은 이유때문에 현재 있는 A파티장에서 B번 파티장까지 파티가 열리는 시간까지 맞춰 갈 수 있는지 쉽게 알 수 없다.

//이러한 문제점으로 이용객들의 불만이 점점 커져갔고 민호는 이를 해결하기 위해 빠른 네비게이션 서비스를 실행하기로 하였으나 서비스 요청이 너무 많아 업무가 마비되기에 이르렀다. 
//이에 민호는 천재프로그래머인 당신에게 이 문제를 해결해 달라고 요청하였다. 민호를 도와 한 파티장에서 다른 파티장에까지 시간내에 도착할 수 있는지 없는지 알아봐주는 프로그램을 작성하자.
//
//입력
//입력의 첫 번째 줄에는 파티장의 크기 N(5 ≤ N ≤ 500)과 서비스를 요청한 손님의 수 M(1 ≤ M ≤ 10,000) 이 주어진다. 각각의 파티장은 1번부터 N번까지 번호가 붙여져 있다. 
//다음에는 N개의 줄에 걸쳐 각각 N개의 수가 주어진다. i번째 줄의 j번째 수 T(1 ≤ T ≤ 1,000,000)는 i번 파티장에서 j번 파티장으로 직접적으로 연결된 도로를 통해 이동하는 시간을 의미한다.
//
//다음 M개의 줄에는 세개의 정수 A, B, C가 주어진다. A(1 ≤ A ≤ N) 는 서비스를 요청한 손님이 위치한 파티장의 번호, B(1 ≤ B ≤ N) 다음 파티가 열리는 파티장의 번호, 
//C(1 ≤ C ≤ 1,000,000,000)는 지금으로부터 다음 파티가 열리는데 걸리는 시간을 의미한다.
public class Practice11265 {
	
	static int n; // 파티장의 크기
	static int m; // 서비스 요청한 손님의 수
	static ArrayList<Integer[]> graph = new ArrayList<Integer[]>();
	static int[][] distance;
	
	static class Node{
		int index;
		int dist;
		
		public Node(int index, int dist) {
			this.index = index;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		graph.add(new Integer[] {});
		
		for(int i = 0; i<n; i++) {
			String[] arr = br.readLine().split(" ");
			Integer[] intArr = new Integer[arr.length+1];
			for(int j = 0; j<arr.length; j++) {
				intArr[j+1] = Integer.valueOf(arr[j]);
			}
			graph.add(intArr);
		}
		
		distance = new int[n+1][n+1];
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
//		dijkstra();
		floydWarshall();
		
		for(int i = 0; i<m; i++) {
			String[] abc = br.readLine().split(" ");
			int a = Integer.valueOf(abc[0]);
			int b = Integer.valueOf(abc[1]);
			int c = Integer.valueOf(abc[2]);
			
			if(distance[a][b] <= c) {
				System.out.println("Enjoy other party");
			}else {
				System.out.println("Stay here");
			}
		}
		
	}
	
	static void dijkstra() {
		
		for(int i = 1; i<n+1; i++) {
			PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.dist - o2.dist);
			queue.add(new Node(i, 0));
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				for(int j = 1; j<n+1; j++) {
					int dist = graph.get(node.index)[j]; // 노드 인덱스부터 목적지 까지의 거리
					int cost = dist+node.dist; // +노드 인덱스 까지의 거리
					
					if(cost < distance[i][j]) {
						distance[i][j] = cost;
						queue.add(new Node(j, cost));
					}
				}
			}
		}
	}
	
	static void floydWarshall() {
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				distance[i][j] = graph.get(i)[j];
			}
		}
		
		//중간 노드
		for(int j = 1; j<n+1; j++) {
			//시작 노드
			for(int i = 1; i<n+1; i++) {
				//마지막 노드
				for(int k = 1; k<n+1; k++) {
					distance[i][k] = Math.min(distance[i][k], distance[i][j] + distance[j][k]);
				}
			}
		}
		
	}

}
