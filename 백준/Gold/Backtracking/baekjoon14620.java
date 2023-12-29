
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class Main {
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int n;
	
	//씨앗 있는 곳
	static boolean[][] visited;
	
	static int answer = Integer.MAX_VALUE;
	
	static ArrayList<Integer[]> list = new ArrayList<Integer[]>();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i<n; i++) {
			String[] tempMap = br.readLine().split(" ");
			for(int j = 0; j<tempMap.length; j++) {
				map[i][j] = Integer.parseInt(tempMap[j]);
			}
		}
		
		backtracking(0,0);
		
		System.out.println(answer);
		
	}
	
	public static int getSum(int x, int y) {
		int sum = map[x][y];
		
		for(int i =0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if( 0<=nx && nx<n && 0<=ny && ny<n ) {
				sum += map[nx][ny];
			}
		}
		
		return sum;
	}
	
	public static void backtracking(int depth, int count) {
		if(depth == 3) {
			answer = Math.min(answer, count);
//			for(Integer[] arr : list) {
//				System.out.print(Arrays.toString(arr) + " ");
//			}
//			System.out.println(answer);
			return;
		}

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(check(i,j) == false) {
					continue;
				}
				//심을 수 있다면
				put(i,j);
				count += getSum(i,j);
				backtracking(depth+1, count);
				count -= getSum(i,j);
				remove(i,j);
			}
		}
	}
	
	//씨앗 심을 수 있는지 확인
	public static boolean check(int x,int y) {
		
		//이미 심어져있는지
		if(visited[x][y] == true) {
			return false;
		}
		//범위가 되는지
		if(isRange(x,y) == false) {
			return false;
		}
		//범위내에 꽃이 있는지
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(visited[nx][ny] == true) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isRange(int x, int y) {
		
		for(int i =0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!(0<=nx && nx<n && 0<=ny && ny<n)) {
				return false;
			}
		}
		
		return true;
	}
	
	//꽃 심기
	public static void put(int x, int y) {
		if(isRange(x,y) == false) {
			return;
		}
		visited[x][y] = true;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			visited[nx][ny] = true;
		}
		
	}
	
	//꽃 제거
	public static void remove(int x, int y) {
		if(isRange(x,y) == false) {
			return;
		}
		visited[x][y] = false;
		for(int i = 0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			visited[nx][ny] = false;
		}
		
	}
}
