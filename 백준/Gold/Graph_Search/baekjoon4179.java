package Graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//문제
//지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!
//
//미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
//
//지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다) 이동한다.
//
//불은 각 지점에서 네 방향으로 확산된다.
//
//지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
//
//지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
//
//입력
//입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.
//
//다음 입력으로 R줄동안 각각의 미로 행이 주어진다.
//
//각각의 문자들은 다음을 뜻한다.
//
//#: 벽
//.: 지나갈 수 있는 공간
//J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
//F: 불이 난 공간
//J는 입력에서 하나만 주어진다.
//
//출력
//지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
//
//지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.
//
//예제 입력 1 
//4 4
//####
//#JF#
//#..#
//#..#
//예제 출력 1 
//3

public class Practice4179 {
	
	static int n;
	static int m;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] graph;
	static LinkedList<int[]> fire = new LinkedList();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		graph = new char[n][m];
		int x = 0;
		int y = 0;
		for(int i = 0; i<n; i++) {
			String row = br.readLine();
			for(int j = 0; j<row.length(); j++) {
				graph[i][j] = row.charAt(j);
				if(graph[i][j] == 'J') {
					x = i;
					y = j;
				}else if(graph[i][j] == 'F') {
					fire.add(new int[] {i,j});
				}
			}
		}
		
		bfs(x, y);
		System.out.println("IMPOSSIBLE");
	}

	static void spreadFire() {
		int size = fire.size();
		for(int j = 0; j<size; j++) {
//			System.out.println(j + " 사이즈 : " + fire.size());
			int[] f = fire.poll();
			for(int i = 0; i<4; i++) {
				int nx = f[0]+dx[i];
				int ny = f[1]+dy[i];
				
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(graph[nx][ny] != '#' && graph[nx][ny] != 'F') {
						graph[nx][ny] = 'F';
						fire.add(new int[] {nx, ny});
					}
				}
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		LinkedList<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {x,y,0});

		while(!queue.isEmpty()) {
			spreadFire();
			int size = queue.size();
			for(int i = 0; i<size; i++) { // 한 페이즈 돌림

				int[] xy = queue.poll();
				for(int j = 0; j<4; j++) {
					int nx = xy[0]+dx[j];
					int ny = xy[1]+dy[j];
					
					if(0<=nx && nx<n && 0<=ny && ny<m) {
						
						if(graph[nx][ny] == '#' || graph[nx][ny] == 'F' || graph[nx][ny] == 'J') {// 이동 불가능하면
							continue;
						}else { //이동 가능

							graph[nx][ny] = 'J';
							queue.add(new int[] {nx, ny, xy[2]+1});
						}
					}else{
						System.out.println(xy[2]+1);
						System.exit(0);
					}
				}
			}
//			spreadFire();
		}
	}
}
