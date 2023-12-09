

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	static class Node{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
	
	static int n,m,r;
	
	static int[] items;
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmr = br.readLine().split(" ");
		n = Integer.valueOf(nmr[0]); //지역의 개수
		m = Integer.valueOf(nmr[1]); //수색범위
		r = Integer.valueOf(nmr[2]); //길의 개수
		
		items = new int[n+1];
		
		String[] item = br.readLine().split(" ");
		
		for(int i = 1; i<n+1; i++) {
			items[i] = Integer.valueOf(item[i-1]);
		}
		
		for(int i = 0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<r; i++) {
			String[] abl = br.readLine().split(" ");
			graph.get(Integer.valueOf(abl[0])).add(new Node(Integer.valueOf(abl[1]), Integer.valueOf(abl[2])));
			graph.get(Integer.valueOf(abl[1])).add(new Node(Integer.valueOf(abl[0]), Integer.valueOf(abl[2])));
		}
		
		for(int i=1; i<n+1; i++) {
			dijkstra(i);
		}
		System.out.println(answer);
	}
	
	static void dijkstra(int start) {
		
		int sum = 0;
		
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance); // 오름차순, distance를 기준으로
		int[] distance = new int[n+1];
		
		for(int i = 0; i<n+1; i++) {
			if(i==start) {
				distance[i] = 0;
			}else {
				distance[i] = Integer.MAX_VALUE;
			}
		}
		
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int index = node.index;
			
			for(int i = 0; i<graph.get(index).size(); i++) { // 갈 수 있는 곳 다 찾아보기(해당 노드)
				int destination = graph.get(index).get(i).index;
				int dist = graph.get(index).get(i).distance;
				
				int cost = node.distance + dist;
				
				if(cost <= distance[destination]) { //비용이 더 적으므로, 업데이트
					distance[destination] = cost;
					queue.add(new Node(destination, cost));
				}
			}
			
		}
		
		//sum 계산
		for(int i = 1; i<n+1; i++) {
			if(distance[i] <= m) {
				sum += items[i];
			}
		}
		
		answer = Math.max(answer, sum);
	}

}
