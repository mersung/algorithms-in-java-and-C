package Graph_traversal;

//스타크래프트와 같은 게임을 하다 보면 어떤 유닛을 목적지까지 이동시켜야 하는 경우가 종종 발생한다. 편의상 맵을 N×M 크기의 2차원 행렬로 생각하자. 
//또한 각각의 유닛은 크기를 가질 수 있는데, 이를 A×B 크기의 2차원 행렬로 생각하자. 아래는 5×5 크기의 맵과 2×2 크기의 유닛에 대한 한 예이다. S는 시작점을 나타내며 E는 끝점을 나타낸다.
//
//
//
//유닛은 상하좌우의 네 방향으로만 움직일 수 있다. 단, 유닛의 일부분이 장애물이 설치된 부분(위의 예에서 색이 칠해진 부분)을 지날 경우, 
//위의 예에서는 시작 위치에서 위로 이동하는 경우는 허용되지 않는다. 위의 예는 유닛을 오른쪽으로 세 칸, 위쪽으로 세 칸 움직이면 목적지에 도달할 수 있고, 
//이 경우가 가장 적은 이동 회수를 거치는 경우이다. 이동하는 도중에 유닛이 맵 밖으로 나가는 경우는 허용되지 않는다.
//
//맵의 정보와 유닛의 정보가 주어졌을 때, 유닛을 목적지까지 움직이기 위해 필요한 최소의 이동 회수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 다섯 개의 정수 N, M(1 ≤ N, M ≤ 500), A, B(1 ≤ A, B ≤ 10), K(0 ≤ K ≤ 100,000)가 주어진다. 
//다음 K개의 줄에는 장애물이 설치된 위치(행 번호, 열 번호)가 주어진다. 그 다음 줄에는 시작점의 위치와 도착점의 위치가 주어진다. 
//시작점의 위치와 도착점의 위치는 제일 왼쪽 제일 위의 한 점만 주어진다. 시작점의 위치와 도착점의 위치는 같지 않다.
//
//유닛의 시작점에는 장애물이 존재하지 않으며, 시작점과 도착점이 행렬의 범위를 벗어나는 경우는 없다.
//
//출력
//첫째 줄에 답을 출력한다. 이동이 불가능한 경우에는 -1을 출력한다.
//
//예제 입력 1 
//5 5 2 2 3
//2 2
//3 2
//3 3
//4 1
//1 4
//예제 출력 1 
//6
//출처

import java.io.*;
import java.util.*;

public class Practice2194 {
	
	static int n;
	static int m;
	static int a;
	static int b;
	static int k;
	static int[][] board;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int[][] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmabk = br.readLine().split(" "); // 스플릿은, 최소 1크기 이상의 배열 리턴. [""] 라도 리턴 됨, length 사용시 주의
		n = Integer.valueOf(nmabk[0]);
		m = Integer.valueOf(nmabk[1]);
		a = Integer.valueOf(nmabk[2]);
		b = Integer.valueOf(nmabk[3]);
		k = Integer.valueOf(nmabk[4]);
		
		board = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		for(int i = 0; i<k; i++) {
			String[] ab = br.readLine().split(" ");
			board[Integer.valueOf(ab[0])][Integer.valueOf(ab[1])] = 1;
		}
		
		String[] st = br.readLine().split(" ");
		String[] ed = br.readLine().split(" ");
		
		startX = Integer.valueOf(st[0]);
		startY = Integer.valueOf(st[1]);
		endX = Integer.valueOf(ed[0]);
		endY = Integer.valueOf(ed[1]);
		
		bfs();
		
		System.out.println(-1);
		
	}
	
	static void bfs() {
		LinkedList<int[]> queue = new LinkedList();
		
		queue.add(new int[] {startX, startY, 0});
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			if(xy[0] == endX && xy[1] == endY) {
				System.out.println(xy[2]);
				System.exit(0);
			}
			for(int i = 0; i<4; i++) {
				int nx = Integer.valueOf(xy[0]) + dx[i];
				int ny = Integer.valueOf(xy[1]) + dy[i];
				if(check(nx, ny, i)) {
					visited[nx][ny] = 1;
					queue.add(new int[] {nx, ny, xy[2]+1});
				}
				
			}
		}
	}
	
	//이동 후 범위 내 장애물 있는지 확인 및 범위 벗어났는지 확인
	static boolean check(int x, int y, int cnt) {
		
		
		
		int nextX = x+a-1;
		int nextY = y+b-1;
		
		// 첫 번째로, 현재 xy가 범위 내인지, 다음 xy가 범위 내인지
		if(checkArrange(x, y) == false || checkArrange(nextX, nextY) == false) return false;
		if(visited[x][y] == 1) return false;
		// 두 번째로, 옮겨진 부분 장애물 확인 
//		x가 1작아짐 (위로 올라감) : [x-1, y] ~ [x-1, y+b-1]
//				--> [nextX][y ~ y+b-1]
//				x가 1커짐(아래로 내려감) : [x+a, y] ~ [x+a, y+b-1]
//				--> [nextX + a-1 ][y ~ y+b-1]
//				y가 1작아짐(왼쪽으로) : [x, y-1] ~ [x+a-1, y-1]
//				--> [x ~ x+a-1][y-1]
//				y가 1커짐(오른쪽): [x, y+1] ~ [x+a-1, y+1]
//				--> [x ~ x+a-1][nextY + b - 1]
		if(cnt == 0) { //x가 1감소한 경우
			for(int i = 0; i<b; i++) {
				if(board[x][y+i] == 1) return false;
			}
		}else if(cnt == 1) { //x가 1 증가
			for(int i = 0; i<b; i++) {
				if(board[nextX][y+i] == 1) return false;
			}
		}else if(cnt == 2) { //y가 1 작아짐
			for(int i = 0; i<a; i++) {
				if(board[x+i][y] == 1) return false;
			}
		}else if(cnt == 3) { //y가 1 커짐
			for(int i = 0; i<a; i++) {
				if(board[x+i][nextY] == 1) return false;
			}
		}
		
		
		return true;
	}
	
	static boolean checkArrange(int x, int y) {
		if(x<1 || x>n || y<1 || y>m) {
			return false;
		}
		
		return true;
	}

}
