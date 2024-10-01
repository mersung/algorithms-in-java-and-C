
import java.io.*;
import java.util.*;
public class Main {

	static int n;
	static int m;
	static ArrayList<ArrayList<Node>> queue = new ArrayList();
	static int[][] distance;
	static int[][] answer;
	
	static class Node{
		int index;
		int distance;
		int secondNode;
		
		public Node(int index, int secondNode, int distance) {
			this.index = index;
			this.distance = distance;
			this.secondNode = secondNode;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		distance = new int[n+1][n+1];
		answer = new int[n+1][n+1];
		
		for(int i = 0; i<n+1; i++) {
			queue.add(new ArrayList());
			
			for(int j = 0; j<n+1; j++) {
				if(i == j) {
					distance[i][j] = 0;
					continue;
				}
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<m; i++) {
			String[] abc = br.readLine().split(" ");
			
			int a = Integer.valueOf(abc[0]);
			int b = Integer.valueOf(abc[1]);
			int c = Integer.valueOf(abc[2]);
			
			queue.get(a).add(new Node(b, b, c));
			queue.get(b).add(new Node(a, a, c));
		}
		
		for(int i = 1; i<n+1; i++) {
			dijkstra(i);
		}
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				if(answer[i][j] == 0) {
					System.out.print('-' +  " ");
				}else {
					System.out.print(answer[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	static void dijkstra(int x) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.distance - o2.distance);
		
		for(Node nextNode : queue.get(x)) {
			pq.add(new Node(nextNode.index, nextNode.index, nextNode.distance));
			distance[x][nextNode.index] = nextNode.distance;
			answer[x][nextNode.index] = nextNode.index;
		}
		
		while(!pq.isEmpty()) {
			Node startNode = pq.poll();
			
			for(Node nextNode : queue.get(startNode.index)) {
				int dist = startNode.distance + nextNode.distance;
				
				if(dist < distance[x][nextNode.index]) {
					distance[x][nextNode.index] = dist;
					answer[x][nextNode.index] = startNode.secondNode;
					pq.add(new Node(nextNode.index, startNode.secondNode, dist));
				}
			}
		}
	}

}
