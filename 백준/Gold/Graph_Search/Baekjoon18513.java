package Graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;


//일직선 상의 공간에 N개의 샘터가 존재하며, K채의 집을 짓고자 한다. 모든 샘터 및 집이 존재하는 위치는 항상 정수 형태이다. 
//이때 일직선 상의 공간에서 N개의 샘터 및 K채의 집들은 모두 서로 다른 위치에 존재한다. 다시 말해 하나의 위치에는 샘터가 있거나, 집이 있거나, 혹은 아무것도 없다.
//
//K채의 집을 지을 때, 가능하면 샘터의 주변에 집들을 지어서 K채의 모든 집에 대한 불행도의 합이 최소가 되도록 짓고자 한다. 이때 특정한 집에 대한 불행도란, 
//가장 가까운 샘터까지의 거리(Distance)로 정의된다. 예를 들어 특정한 집이 1에 위치하고, 그 집과 가장 가까운 샘터가 -5에 위치한다고 하면, 이 집의 불행도는 6이다.
//
//N=2, K=5일 때, 모든 집에 대한 불행도의 합이 최소가 되도록 집을 짓는 경우를 고려해보자. 아래 그림과 같이 두 개의 샘터가 0, 3의 위치에 존재한다고 가정하자.
//
//
//
//이때 다음과 같이 5채의 집을 설치하면, 각 집의 불행도의 합이 2+1+1+1+1=6로 최소가 된다. 집을 짓는 가능한 경우의 수는 여러 가지가 될 수 있지만, 불행도의 합을 6보다 작게 만드는 방법은 없다.
//
//
//
//입력
//첫째 줄에 자연수 N과 K가 공백을 기준으로 구분되어 주어진다. (1 ≤ N, K ≤ 100,000) 둘째 줄에 N개의 샘터의 위치가 공백을 기준으로 구분되어 정수 형태로 주어진다. 
//(-100,000,000 ≤ 샘터의 위치 ≤ 100,000,000) 단, 모든 N개의 샘터의 위치들은 서로 다르게 주어진다.

//첫째 줄에 모든 집에 대한 불행도의 합의 최솟값을 출력한다.
//
//예제 입력 1 
//2 5
//0 3
//예제 출력 1 
//6


public class Practice18513 {
	
	static int n;
	static int k;
	static int[] samter;
	static HashSet<Integer> set = new HashSet<>();
//	static PriorityQueue<Node> queue = new PriorityQueue<Node>((o1,o2) -> o1.distance - o2.distance);
	static LinkedList<Node> queue = new LinkedList<>();
	static long answer = 0;
	
	static class Node{
		int node;
		int distance;
		
		public Node(int node, int dist) {
			this.node = node;
			this.distance = dist;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		n = Integer.valueOf(nk[0]);
		k = Integer.valueOf(nk[1]);
		samter = new int[n];
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i<s.length; i++) {
			samter[i] = Integer.valueOf(s[i]);
		}
		
		Arrays.sort(s);
		
		for(int i = 0; i<samter.length; i++) {
			queue.add(new Node(samter[i], 0));
			set.add(samter[i]);
		}
		
		bfs();
		
		System.out.println(answer);
		
	}
	
	static void bfs() {
		int[] dx = {-1, 1};
		
		while(!queue.isEmpty()) {
			Node samterNode = queue.poll();
			for(int i = 0; i<2; i++) {
				int nx = samterNode.node + dx[i];
				int ndist = samterNode.distance + 1; // 처음 샘터 노드와의 거리
				if(!set.contains(nx)) { //방문하지 않았을 경우
					set.add(nx); //방문처리
					answer += ndist; // 처음 샘터 노드와의 거리 더함 
					queue.add(new Node(nx, ndist));
					k -= 1;
				}
				if(k == 0) return;
			}
			
			
		}
		
	}

}
