package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice11657 {
	
	static class Node {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
	
	static int n;
	static int m;

	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] answer;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		answer = new int[n+1];
		
		for(int i = 0; i<n+1; i++) {
			answer[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i<m; i++) {
			String[] abc = br.readLine().split(" ");
			graph.get(Integer.valueOf(abc[0])).add(new Node(Integer.valueOf(abc[1]), Integer.valueOf(abc[2])));;
		}
		dijkstra(1);
		for(int i = 2; i<n+1; i++) {
			System.out.println(answer[i]);
		}
		
//		System.out.println(Arrays.toString(answer));
	}
	
	static void dijkstra(int index) {
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> o1.distance - o2.distance);
		answer[index] = 0;

		q.add(new Node(index, 0));
		
		while(!q.isEmpty()) {
			Node start = q.poll();
			
			for(Node end : graph.get(start.index)) {
				int dist = start.distance + end.distance;
				
				if(dist < answer[end.index]) {
					answer[end.index] = dist;
					q.add(new Node(end.index, dist));
				}
			}
		}
		
	}

}
