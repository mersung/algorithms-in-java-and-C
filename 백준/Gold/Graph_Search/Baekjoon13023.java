package Graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
//
//오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
//
//A는 B와 친구다.
//B는 C와 친구다.
//C는 D와 친구다.
//D는 E와 친구다.
//위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
//
//둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
//
//출력
//문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.

//5 4
//0 1
//1 2
//2 3
//3 4
//예제 출력 1 
//1

//예제 입력 2 
//5 5
//0 1
//1 2
//2 3
//3 0
//1 4
//예제 출력 2 
//1

//예제 입력 3 
//6 5
//0 1
//0 2
//0 3
//0 4
//0 5
//예제 출력 3 
//0

//예제 입력 4 
//8 8
//1 7
//3 7
//4 7
//3 4
//4 6
//3 5
//0 4
//2 7
//예제 출력 4 
//1
public class Practice13023 {

	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		for(int i = 0; i<n; i++) {
			graph.add(new ArrayList<>());
		}
		
		visited = new boolean[n];
		
		for(int i = 0; i<m; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.valueOf(ab[0]);
			int b = Integer.valueOf(ab[1]);
			// a와 b는 친구인데, a->b->c->d->e 처럼 한 번에 바로 도는 관계로 전부가 다 이어져 있어야 한다. 즉 끊기지 않고 DFS를 돌면서 모두가 친구여야 함.
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i = 0; i<n; i++) {
			visited[i] = true;
			backtracking(i);
			visited[i] = false;
		}
		System.out.println(answer);

	}
	
	static void backtracking(int index) {
		
		if(check(visited, true) == 5) {
			System.out.println('1');
			System.exit(0);
		}
		
		for(Integer node : graph.get(index)) {
			if(visited[node] == false) {
				visited[node] = true;
				backtracking(node);
				visited[node] = false;
			}
		}
	}
	
	static int check(boolean[] arr, boolean tf) {
		int cnt = 0;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == tf) {
				cnt ++;
				if(cnt >= 5) {
					return cnt;
				}
			}
		}
		return cnt;
	}

}
