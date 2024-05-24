package Implementation;

import java.io.*;
import java.util.*;
public class Practice21278 {

	static int n;
	static int m;
	
	static int MIN_DIST = Integer.MAX_VALUE;
	static ArrayList<Integer[]> answer = new ArrayList();
	
	static boolean[] visited;
	
	static int[][] distance;
	static ArrayList<ArrayList<Node>> graph = new ArrayList();
	
	static class Node{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		visited = new boolean[n+1];
		distance = new int[n+1][n+1];
		
		for(int i = 0; i<n+1; i++) {
			graph.add(new ArrayList());
			for(int j = 0; j<n+1; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<m; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.valueOf(ab[0]);
			int b = Integer.valueOf(ab[1]);
			
			//서로 이어줌
			graph.get(a).add(new Node(b, 1));
			graph.get(b).add(new Node(a, 1));
		}
		
		for(int i = 1; i<n+1; i++) {
			dijkstra(i);
		}
		
		backtracking(0, new int[] {0,0});
		
//		for(int i = 1; i<n+1; i++) {
//			for(int j = 1; j<n+1; j++) {
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		Collections.sort(answer, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		System.out.println(answer.get(0)[0] + " " +answer.get(0)[1] + " " + MIN_DIST);
	}

	static void dijkstra(int index) {
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> o1.distance - o2.distance);
		
		distance[index][index] = 0;
		q.add(new Node(index, 0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for(Node nextNode : graph.get(node.index)) {
				int next = nextNode.index;
				int dist = node.distance + nextNode.distance;
				
				if(distance[index][next] >= dist) {
					distance[index][next] = dist;
					q.add(new Node(next, dist));
				}
			}
		}
	}
	
	static void backtracking(int depth, int[] arr) {
		if(depth == 2) {
//			System.out.println(arr[0] + "/ " + arr[1]);
			int sum = 0;
			
			int first = arr[0];
			int second = arr[1];
			
			for(int i = 1; i<n+1; i++) {
				if(distance[first][i] > distance[second][i]) {
					sum += distance[second][i]*2;
				}else {
					sum += distance[first][i]*2;
				}
			}
			if(MIN_DIST > sum) {
				MIN_DIST = sum;
				answer = new ArrayList<Integer[]>();
				answer.add(new Integer[] {first, second});
			}else if(MIN_DIST == sum) {
				answer.add(new Integer[] {first, second});
			}
			
			return;
		}
		
		for(int i = 1; i<n+1; i++) {
			if(visited[i] == false) {
				arr[depth] = i;
				visited[i] = true;
				backtracking(depth+1, arr);
				visited[i] = false;
			}
		}
	}
	
}
