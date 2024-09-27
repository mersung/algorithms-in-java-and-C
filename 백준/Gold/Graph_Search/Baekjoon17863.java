package Graph_traversal;

//문제
//용사는 마왕이 숨겨놓은 공주님을 구하기 위해 (N, M) 크기의 성 입구 (1,1)으로 들어왔다. 
//마왕은 용사가 공주를 찾지 못하도록 성의 여러 군데 마법 벽을 세워놓았다. 용사는 현재의 가지고 있는 무기로는 마법 벽을 통과할 수 없으며, 
//마법 벽을 피해 (N, M) 위치에 있는 공주님을 구출해야만 한다.
//
//마왕은 용사를 괴롭히기 위해 공주에게 저주를 걸었다. 저주에 걸린 공주는 T시간 이내로 용사를 만나지 못한다면 영원히 돌로 변하게 된다. 
//공주님을 구출하고 프러포즈 하고 싶은 용사는 반드시 T시간 내에 공주님이 있는 곳에 도달해야 한다. 용사는 한 칸을 이동하는 데 한 시간이 걸린다. 
//공주님이 있는 곳에 정확히 T시간만에 도달한 경우에도 구출할 수 있다. 용사는 상하좌우로 이동할 수 있다.
//
//
//
//성에는 이전 용사가 사용하던 전설의 명검 "그람"이 숨겨져 있다. 용사가 그람을 구하면 마법의 벽이 있는 칸일지라도, 단숨에 벽을 부수고 그 공간으로 갈 수 있다. 
//"그람"은 성의 어딘가에 반드시 한 개 존재하고, 용사는 그람이 있는 곳에 도착하면 바로 사용할 수 있다. 그람이 부술 수 있는 벽의 개수는 제한이 없다.
//
//우리 모두 용사가 공주님을 안전하게 구출 할 수 있는지, 있다면 얼마나 빨리 구할 수 있는지 알아보자.
//
//입력
//첫 번째 줄에는 성의 크기인 N, M 그리고 공주에게 걸린 저주의 제한 시간인 정수 T가 주어진다. 첫 줄의 세 개의 수는 띄어쓰기로 구분된다. 
//(3 ≤ N, M ≤ 100, 1 ≤ T ≤ 10000)
//
//두 번째 줄부터 N+1번째 줄까지 성의 구조를 나타내는 M개의 수가 띄어쓰기로 구분되어 주어진다. 0은 빈 공간, 1은 마법의 벽, 2는 그람이 놓여있는 공간을 의미한다. 
//(1,1)과 (N,M)은 0이다.
//
//출력
//용사가 제한 시간 T시간 이내에 공주에게 도달할 수 있다면, 공주에게 도달할 수 있는 최단 시간을 출력한다.
//
//만약 용사가 공주를 T시간 이내에 구출할 수 없다면, "Fail"을 출력한다.
//
//예제 입력 1 
//6 6 16
//0 0 0 0 1 1
//0 0 0 0 0 2
//1 1 1 0 1 0
//0 0 0 0 0 0
//0 1 1 1 1 1
//0 0 0 0 0 0
//예제 출력 1 
//10
//
//
//주황색 선을 따라 검을 구하지 않고, 벽을 돌아가면 16시간만에 공주님에게 도착할 수 있다.
//
//반면, 녹색선을 따라 "그람"을 구해, 벽을 부수고 공주님께 가면 10시간만에 도달할 수 있다.
//
//예제 입력 2 
//3 4 100
//0 0 0 0
//1 1 1 1
//0 0 2 0
//예제 출력 2 
//Fail

import java.io.*;
import java.util.*;
public class Practice17863 {
	
	static int n;
	static int m;
	static int t;
	static int[][] graph;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int answer = Integer.MAX_VALUE;
	
	static class Node{
		int x;
		int y;
		boolean gram;
		int cnt;
		
		public Node(int x, int y, boolean gram, int cnt) {
			this.x = x;
			this.y = y;
			this.gram = gram;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmt = br.readLine().split(" ");
		
		n = Integer.valueOf(nmt[0]);
		m = Integer.valueOf(nmt[1]);
		t = Integer.valueOf(nmt[2]);
		graph = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			String[] row = br.readLine().split(" ");
			
			for(int j = 0; j<m; j++) {
				graph[i][j] = Integer.valueOf(row[j]);
			}
		}
		
		bfs(0, 0, false, 0);
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("Fail");
		}else {
			System.out.println(answer);
		}
	}
	
	static void bfs(int x, int y, boolean gram, int cnt) {
		LinkedList<Node> queue = new LinkedList();
		boolean[][][] visited = new boolean[n][m][2];
		visited[x][y][0] = true;
		
		queue.add(new Node(x, y, gram, cnt));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//시간이 넘었을 경우
			if(node.cnt > t) continue;
			
			//공주에게 도달
			if(node.x == n-1 && node.y == m-1) {
				answer = Math.min(answer, node.cnt);
				continue;
			}
			
			for(int i = 0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m ) continue;
				
				//그람이 없으면 벽을 부술 수 없음
				if(node.gram == false) {
					if(graph[nx][ny] == 1) continue;
				}
				
				//그람을 줏으면
                boolean newGram = node.gram;
				if(graph[nx][ny] == 2) {
					newGram = true;
				}
				
				int num = newGram ? 1 : 0;
				
				if(visited[nx][ny][num] == true) continue;
				
				visited[nx][ny][num] = true;
				queue.add(new Node(nx, ny, newGram, node.cnt+1));
			}
		}
	}

}
