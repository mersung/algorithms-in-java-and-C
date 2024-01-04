package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Practice1956 {

	static class Node {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
	
	static int v; //정점 개수
	static int e; //간선 개수
	static int k; //시작점
	
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] ve = br.readLine().split(" ");
		
		v = Integer.valueOf(ve[0]);
		e = Integer.valueOf(ve[1]);
		k = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<v+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<e; i++) {
			String[] uvw = br.readLine().split(" ");
			
			graph.get(Integer.valueOf(uvw[0])).add(new Node(Integer.valueOf(uvw[1]), Integer.valueOf(uvw[2])));
		}
		
		int[] answer = dijkstra(k);
		
		for(int i=1; i<v+1; i++) {
			if(answer[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(answer[i]);
			}
		}
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[v+1];
		PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.distance - o2.distance); // distance를 기준으로 오름차순 정렬
		
		queue.add(new Node(start, 0));
		
		for(int i = 0; i<v+1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int current = node.index;
			
			for(int i = 0; i<graph.get(current).size(); i++) {
				int dist = node.distance + graph.get(current).get(i).distance;
				int destination = graph.get(current).get(i).index;
				
				if(dist <= distance[destination]) {
					distance[destination] = dist;
					queue.add(new Node(destination, dist));
				}
			}
		}
		
		return distance;
	}

}
