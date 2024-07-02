package Graph_traversal;

import java.io.*;
import java.util.*;

//문제
//적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
//
//크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 
//또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
//
//예를 들어, 그림이 아래와 같은 경우에
//
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
//
//그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
//
//둘째 줄부터 N개 줄에는 그림이 주어진다.
//
//출력
//적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
//
//예제 입력 1 
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//예제 출력 1 
//4 3


public class Practice10026 {
	
	static int n;
	static char[][] board;
	static int[] answer = {0,0};
	static boolean[][] visited; //보통
	static boolean[][] visitedTwo; // 적록색약
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		visited = new boolean[n][n];
		visitedTwo = new boolean[n][n];
		board = new char[n][n];
		
		for(int i = 0; i<n; i++) {
			String row = br.readLine();
			for(int j = 0; j<row.length(); j++) {
				board[i][j] = row.charAt(j);
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(visited[i][j] == false) {
					//1. 그냥 보통 사람
					visited[i][j] = true;
					bfs(i, j, 0, board[i][j]);
				}
				
				if(visitedTwo[i][j] == false) {
					//2. 적록색약(R,G는 같으나 B는 다른걸로 봄)
					visitedTwo[i][j] = true;
					bfs(i, j, 1, board[i][j]);
				}
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	static void bfs(int x, int y, int status, char color) {
		
		LinkedList<int[]> queue = new LinkedList();
		queue.add(new int[] {x,y});
		boolean flag = false;
		//적록색약 이면서, color가 R또는 G면
		if(status == 1 && (color == 'R' || color == 'G')) {
			flag = true;
		}
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];
				
				if(status == 0) {
					if(0<=nx && nx<n && 0<=ny && ny<n && visited[nx][ny] == false && board[nx][ny] == color) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}else {
					if(0<=nx && nx<n && 0<=ny && ny<n && visitedTwo[nx][ny] == false) {
						if(flag == false && board[nx][ny] == color) {
							queue.add(new int[] {nx,ny});
							visitedTwo[nx][ny] = true;
						}else if(flag == true && (board[nx][ny] == 'R' || board[nx][ny] == 'G')) {
							queue.add(new int[] {nx,ny});
							visitedTwo[nx][ny] = true;
						}	
					}
				}
				
			}
		}
		
		answer[status] += 1;
	}

}
