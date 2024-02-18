package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Baekjoon1719 {
	
	static int n;
	static int m;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[][] answer;
	static int[][] distance;
	static boolean[] visited;
	
	static class Node{
		int node;
		int distance;
		int secondNode;
		
		public Node(int node, int dist, int secondNode) {
			this.node = node;
			this.distance = dist;
			this.secondNode = secondNode;
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		distance = new int[n+1][n+1];
		answer = new int[n+1][n+1];
		for(int i = 0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				if(i==j) {
					distance[i][j] = 0;
				}else {
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		//Node 사이의 Edge 시간 입력
		for(int i = 0; i<m; i++) {
			String[] abc = br.readLine().split(" ");
			
			int left = Integer.valueOf(abc[0]);
			int right = Integer.valueOf(abc[1]);
			int dist = Integer.valueOf(abc[2]);
			
			graph.get(left).add(new Node(right, dist, right));
			graph.get(right).add(new Node(left, dist, left));
			
		}
		
		for(int i = 1; i<n+1; i++) {
//			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			dijkstra(i);
			
		}
		
		
		String[][] realAnswer = new String[n][n];
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				realAnswer[i-1][j-1] =  answer[i][j] == 0 ? "-" : String.valueOf(answer[i][j]);
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(realAnswer[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) -> o1.distance - o2.distance);
		for(Node destNode : graph.get(start)) {
			q.add(new Node(destNode.node, destNode.distance, destNode.secondNode));
			distance[start][destNode.node] = destNode.distance;
			answer[start][destNode.node] = destNode.node;
		}
		
		while(!q.isEmpty()) {
			Node startNode = q.poll();

			for(Node destNode : graph.get(startNode.node)) {
				int dist = startNode.distance + destNode.distance;
				
				if(dist < distance[start][destNode.node]) { //기존거리보다 짧으면, 업데이트 해주면서 경로도 없데이트
					
					distance[start][destNode.node] = dist;
					Node nextNode = new Node(destNode.node, dist, startNode.secondNode);
					q.add(nextNode);
					answer[start][destNode.node] = nextNode.secondNode;
				}
				
			}
		}

	}

}
