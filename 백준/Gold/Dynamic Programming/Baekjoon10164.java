package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

//행의 수가 N이고 열의 수가 M인 격자의 각 칸에 1부터 N×M까지의 번호가 첫 행부터 시작하여 차례로 부여되어 있다. 격자의 어떤 칸은 ○ 표시가 되어 있다. 
//(단, 1번 칸과 N × M번 칸은 ○ 표시가 되어 있지 않다. 또한, ○ 표시가 되어 있는 칸은 최대 한 개이다. 즉, ○ 표시가 된 칸이 없을 수도 있다.) 
//
//행의 수가 3이고 열의 수가 5인 격자에서 각 칸에 번호가 1부터 차례대로 부여된 예가 아래에 있다. 이 격자에서는 8번 칸에 ○ 표시가 되어 있다.

//격자의 1번 칸에서 출발한 어떤 로봇이 아래의 두 조건을 만족하면서 N×M번 칸으로 가고자 한다. 
//
//조건 1: 로봇은 한 번에 오른쪽에 인접한 칸 또는 아래에 인접한 칸으로만 이동할 수 있다. (즉, 대각선 방향으로는 이동할 수 없다.)
//조건 2: 격자에 ○로 표시된 칸이 있는 경우엔 로봇은 그 칸을 반드시 지나가야 한다. 
//위에서 보인 것과 같은 격자가 주어질 때, 로봇이 이동할 수 있는 서로 다른 경로의 두 가지 예가 아래에 있다.
//
//1 → 2 → 3 → 8 → 9 → 10 → 15
//1 → 2 → 3 → 8 → 13 → 14 → 15
//격자에 관한 정보가 주어질 때 로봇이 앞에서 설명한 두 조건을 만족하면서 이동할 수 있는 서로 다른 경로가 총 몇 개나 되는지 찾는 프로그램을 작성하라. 
//
//입력
//입력의 첫째 줄에는 격자의 행의 수와 열의 수를 나타내는 두 정수 N과 M(1 ≤ N, M ≤ 15), 그리고 ○로 표시된 칸의 번호를 나타내는 정수 K(K=0 또는 1 < K < N×M)가 차례로 주어지며, 
//각 값은 공백으로 구분된다. K의 값이 0인 경우도 있는데, 이는 ○로 표시된 칸이 없음을 의미한다. N과 M이 동시에 1인 경우는 없다.
//
//출력
//주어진 격자의 정보를 이용하여 설명한 조건을 만족하는 서로 다른 경로의 수를 계산하여 출력해야 한다. 

public class Practice10164 {
	
	static int n;
	static int m;
	static int o;
	static int[][] board;
	
	static int[] dx = {-1,0};
	static int[] dy = {0,-1};
	
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmo = br.readLine().split(" ");
		n = Integer.valueOf(nmo[0]);
		m = Integer.valueOf(nmo[1]);
		o = Integer.valueOf(nmo[2]);
		
		if(o > 0) {
			o -= 1;
			int x = o/m; 
			int y = o%m;
			
			answer +=  goDestination(0,0,x,y);
			answer *= goDestination(x,y,n-1,m-1);
		}else {
			answer += goDestination(0,0,n-1,m-1);
		}
		System.out.println(answer);
	}
	
	static int goDestination(int startX, int startY, int destX, int destY) {
		int val = 0;
		
		board = new int[n][m];
		board[startX][startY] = 1;

		for(int i = startX; i<destX+1; i++) {
			for(int j =startY; j<destY+1; j++) {
				for(int k = 0; k<2; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx>=0 && nx<=destX && ny>=0 && ny<=destY) {
						board[i][j] += board[nx][ny];
					}
				}
			}
		}

		return board[destX][destY];
	}

}
