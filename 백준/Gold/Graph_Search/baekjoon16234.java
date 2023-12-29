package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//문제
//N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다. 각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다. 
//인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
//
//오늘부터 인구 이동이 시작되는 날이다.
//
//인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
//
//국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//연합을 해체하고, 모든 국경선을 닫는다.
//각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
//
//둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
//
//인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.
//
//출력
//인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다.
public class Practice16234 {
	
	static int n;
	static int l;
	static int r;
	
	static int[][] board;
	static boolean[][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nlr = br.readLine().split(" ");
		n = Integer.valueOf(nlr[0]);
		l = Integer.valueOf(nlr[1]);
		r = Integer.valueOf(nlr[2]);
		
		board = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] b = br.readLine().split(" ");
			for(int j = 0; j<b.length; j++) {
				board[i][j] = Integer.valueOf(b[j]);
			}
		}
		
		while (true) {
			visited = new boolean[n][n];
			if (!checkLinked()) break;
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					if (visited[i][j] == false) {
						bfs(new int[] {i,j});
					}
				}
			}
			
			answer += 1;
		}
		
		System.out.println(answer);
	}
	
	static boolean checkLinked() {

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k = 0; k<4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx>=0 && nx<n && ny>=0 && ny<n) {
						int diff = Math.abs(board[nx][ny] - board[i][j]);
						if(diff>=l && diff<=r) return true;
					}
				}
			}
		}
		
		return false;
	}
	
	static void bfs(int[] ij) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		ArrayList<int[]> path = new ArrayList<int[]>();
		int sum = 0;
		
		queue.add(ij);
		visited[ij[0]][ij[1]] = true;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			sum += board[x][y];
			path.add(new int[] {x,y});
			
			for(int i =0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && visited[nx][ny] == false) {
					int diff = Math.abs(board[nx][ny] - board[x][y]);
					if(diff >= l && diff <= r) {
						visited[nx][ny] = true;
						queue.add(new int[] {nx,ny});
					}
				}
			}
		}
		int newVal = sum/path.size();
		for(int[] xy : path) {
			board[xy[0]][xy[1]] = newVal;
		}
	}
}
