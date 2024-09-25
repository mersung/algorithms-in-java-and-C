package Backtracking;

//문제
//가로, 세로 길이가 
//$N$인 정사각형 격자가 있다. 해당 격자에는 두 곳을 제외한 모든 곳에 체력을 1씩 감소시키는 죽음의 비가 내리고 있다. 
//죽음의 비가 안내리는 곳은 현재 있는 위치와 안전지대라는 곳이다. 현재 있는 위치에도 곧 비가 내릴 예정이라 빨리 이 죽음의 비를 뚫고 안전지대로 이동해야한다.
//
//다행히도 격자에는 죽음의 비를 잠시 막아주는 우산이 
//$K$개 존재한다. 우산에는 내구도 
//$D$라는 개념이 존재한다. 우산에 비를 맞으면 내구도가 1씩 감소하고, 내구도가 0이 되는 순간 우산은 사라진다. 문제에서 주어지는 우산의 내구도는 모두 
//$D$로 동일하다.
//
//격자에서 이동을 할 때 다음과 같이 순서로 진행된다.
//
//상하좌우로 이동한다. 만약 이동할 곳이 격자 밖이라면 이동할 수 없다. 
//이동한 곳이 안전지대라면 반복을 종료한다.
//이동한 곳에 우산이 있다면 우산을 든다. 만약, 이동할 때부터 우산을 가지고 있다면 가지고 있는 우산을 버리고 새로운 우산으로 바꾼다.
//버린 우산은 더 이상 사용할 수 없다.
//죽음의 비를 맞았을 때, 우산을 가지고 있다면 우산의 내구도가 1이 감소하고 만약 우산을 가지고 있지 않는다면 체력이 1 감소한다.
//만약 우산의 내구도가 0이 되면 들고 있는 우산이 사라진다.
//만약 체력이 0이 되면 죽는다...
//아직 체력이 남았다면 안전지대까지 위 과정을 반복한다.
//현재 있는 위치에서 안전지대로 얼마나 빠르게 이동할 수 있는지 구해주자.
//
//입력
//첫 번째 줄에 정사각형 격자의 한변의 길이인 
//$N$와 현재 체력 
//$H$, 우산의 내구도 
//$D$가 공백으로 구분되어 주어진다.
//
//다음 
//$N$개의 줄에는 정사각형 격자의 정보가 
//$N$개의 문자로 붙어서 주어진다. 이때 주어지는 문자는 우산은 "U", 현재 있는 위치 "S", 안전지대 "E", 빈 칸 "."만 존재한다. 
//현재 있는 위치 "S"와 안전지대 "E"는 반드시 1개 존재한다.
//
//출력
//안전지대로 이동할 때 최소 이동 횟수를 출력한다. 만약 안전지대로 이동하지 못하는 경우에는 -1을 출력한다.
//
//제한
// 
//$4 ≤ N ≤ 500$ 
// 
//$0 ≤ K ≤ 10$ 
// 
//$1 ≤ H ≤ 10,000$ 
// 
//$1 ≤ D ≤ 5,000$ 
//주어지는 모든 수는 정수이다.
//예제 입력 1 
//4 10 4
//S..U
//....
//....
//...E
//예제 출력 1 
//6
//예제 입력 2 
//4 2 6
//S..U
//....
//....
//...E
//예제 출력 2 
//-1
//예제 입력 3 
//4 3 3
//S..U
//....
//....
//...E
//예제 출력 3 
//6
//최상단 맨 왼쪽을 (0, 0)이라 하고 최하단 맨 오른쪽을 (3, 3)이라 하자.
//
//안전지대로 이동하는 방법은 (0, 0)에서 출발하여 우산이 있는 (0, 3)에 가고 (3, 3)으로 이동할 수 있다.
//
//이 방식으로 이동한다면 안전지대에 도착했을때 체력이 1이 남는다.
import java.io.*;
import java.util.*;
public class Practice22944 {
	
	static int n; //정사각형 한 
	static int h; //현재 체력
	static int d; //우산 내구도
	static char[][] graph;
	static int[] start;
	static int[] end;
	static int[][] visited;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int answer = Integer.MAX_VALUE;
	
	static class Node{
		int x;
		int y;
		int hp; //체력
		int mp; //내구도
		int cnt;
		
		public Node(int x, int y, int hp, int mp, int cnt) {
			this.x = x;
			this.y = y;
			this.hp = hp;
			this.mp = mp;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nhd = br.readLine().split(" ");
		n = Integer.valueOf(nhd[0]);
		h = Integer.valueOf(nhd[1]);
		d = Integer.valueOf(nhd[2]);
		
		graph = new char[n][n];
		visited = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			String row = br.readLine();
			
			for(int j = 0; j<row.length(); j++) {
				graph[i][j] = row.charAt(j);
				
				if(graph[i][j] == 'S') start = new int[] {i, j};
			}
		}
		
		bfs(start[0], start[1]);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	static void bfs(int x, int y) {
		LinkedList<Node> queue = new LinkedList();
		
		queue.add(new Node(x, y, h, 0, 0));
		visited[x][y] = h;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i = 0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					int mp = node.mp;
					int hp = node.hp;
					
					if(graph[nx][ny] == 'E') {
						answer = Math.min(answer, node.cnt+1);
						continue;
					}
					
					//우산 줍고 내구도 초기화
					if(graph[nx][ny] == 'U') {
						mp = d;
					}
					
					//내구도 감소
					if(mp > 0) {
						mp -= 1;
					}else { //내구도 0 이하
						if(hp > 0) {
							hp -= 1;
						}
						if(hp <= 0) {
							//체력 없음, 다음 노드 진행
							continue; 
						}
					}
					
					if(visited[nx][ny] < hp + mp) {
						visited[nx][ny] = hp + mp;
						queue.add(new Node(nx, ny, hp, mp, node.cnt+1));
					}
				}
			}
		}
	}

}
