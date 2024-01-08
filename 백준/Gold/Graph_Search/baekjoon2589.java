package Graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Practice2589 {
	
	static int m; //가로
	static int n; //세로
	static String[][] board;
	static int[][] intBoard;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static boolean[][] visited;
	
	static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mn = br.readLine().split(" ");
		m = Integer.valueOf(mn[1]);
		n = Integer.valueOf(mn[0]);
		
		board = new String[n][m];

		
		for(int i=0; i<n; i++) {
			String b = br.readLine();
			for(int j=0; j<b.length(); j++) {
				board[i][j] = String.valueOf(b.charAt(j));
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) { // 각 위치마다 최장거리를 찾아야 한다.
				if(board[i][j].equals("W")) continue;
				bfs(i,j);
			}
		}
		
		
		System.out.println(answer);
	}
	
	static void bfs(int a, int b) {
		visited = new boolean[n][m]; 
		intBoard = new int[n][m];
		visited[a][b] = true;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,b});
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			
			for(int i =0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx >=n || ny<0 || ny>=m || visited[nx][ny] == true || board[nx][ny].equals("W")) continue;
				
				intBoard[nx][ny] = intBoard[x][y] + 1;
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny});
				
				answer = Math.max(answer, intBoard[nx][ny]);
			}
 		}
	}

}
