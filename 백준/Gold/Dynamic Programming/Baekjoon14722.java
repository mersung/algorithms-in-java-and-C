package DynamicProgramming;


//영학이는 딸기우유, 초코우유, 바나나우유를 좋아한다.
//
//입맛이 매우 까다로운 영학이는 자신만의 우유를 마시는 규칙이 있다. 
//
//맨 처음에는 딸기우유를 한 팩 마신다.
//딸기우유를 한 팩 마신 후에는 초코우유를 한 팩 마신다.
//초코우유를 한 팩 마신 후에는 바나나우유를 한 팩 마신다.
//바나나우유를 한 팩 마신 후에는 딸기우유를 한 팩 마신다. 
//저번 축제에서 수많은 우유를 마셨지만 더욱 우유에 갈증을 느낀 영학이는 우유 여행을 떠났다.
//
//맛있는 우유를 찾아 떠난 영학이는 수많은 우유 가게로 둘러 쌓인 어느 도시에 도착했다.
//
//이 도시는 정사각형 형태의 2차원 격자 모양으로 남북으로 N개, 동서로 N개, 총 N*N개의 우유 가게들이 있다.
//
//영학이는 도시의 서북쪽 끝 (1, 1)에서 출발해서 동남쪽 아래 (N, N)까지 까지 가면서 우유를 사 마신다. 
//
//각각의 우유 가게는 딸기, 초코, 바나나 중 한 종류의 우유만을 취급한다.
//
//각각의 우유 가게 앞에서, 영학이는 우유를 사 마시거나, 사 마시지 않는다.
//
//So cooooool~한 영학이는 오직 동쪽 또는 남쪽으로만 움직이기 때문에 한 번 지나친 우유 가게에는 다시 가지 않는다.
//
//영학이가 마실 수 있는 우유의 최대 개수를 구하여라.
//
//입력
//첫 번째 줄에는 우유 도시의 영역 크기 N이 주어진다. (1 ≤ N ≤ 1000)
//
//두 번째 줄부터 N+1 번째 줄까지 우유 도시의 정보가 주어진다.
//
//0은 딸기우유만을 파는 가게, 1은 초코우유만을 파는 가게, 2는 바나나우유만을 파는 가게를 뜻하며, 0, 1, 2 외의 정수는 주어지지 않는다.
//
//출력
//영학이가 마실 수 있는 우유의 최대 개수를 출력하시오.
//
//예제 입력 1 
//4
//0 1 2 2
//1 1 1 1
//2 2 2 2
//0 0 1 0
//예제 출력 1 
//5
//예제 입력 2 
//5
//0 1 0 0 0
//1 2 1 1 1
//2 0 1 2 0
//0 0 0 0 1
//1 1 1 1 2
//예제 출력 2 
//9
import java.io.*;
import java.util.*;
public class Practice14722 {
	
	static int n;
	static int[][] graph;
	static int[][][] dp;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		graph = new int[n+1][n+1];
		dp = new int[n+1][n+1][3]; //3번째는, 마지막으로 먹은 우유 종류와 개수
		
		for(int i = 1; i<n+1; i++) {
			String[] row = br.readLine().split(" ");
			for(int j = 1; j<n+1; j++) {
				graph[i][j] = Integer.valueOf(row[j-1]);
			}
		}

		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {

				
//				1. 지금 0 (먹을경우)
				if(graph[i][j] == 0) {
					dp[i][j][0] = Math.max(dp[i-1][j][2]+1, dp[i][j-1][2]+1);
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j-1][1]);
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i][j-1][2]);
				}
//				1) 1,1 이어야함 1;
//				2) 서or북쪽에서 dp[i][j][0] = [i][j][2]+1; --> 
//				1-1 나머지 (안 먹을경우) --> dp[i][j][k] = dp[i][j][k]
				//지금 1 (먹을경우)
				else if(graph[i][j] == 1) {
					if(dp[i-1][j][0] > 0 || dp[i][j-1][0] >0 )dp[i][j][1] = Math.max(dp[i-1][j][0]+1, dp[i][j-1][0]+1);
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]);
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i][j-1][2]);
				}
//				1) 서or북쪽에서 dp[i][j][1] = [i][j][0]+1;
//				2) 나머지(안 먹을경우) --> dp[i][j][k] = dp[i][j][k]
				else {
					if(dp[i-1][j][1] > 0 || dp[i][j-1][1] >0 )dp[i][j][2] = Math.max(dp[i-1][j][1]+1, dp[i][j-1][1]+1);
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]);
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i][j-1][1]);
				}
				
//				3. 지금 2 (먹음)
//				1) 서or북쪽에서 dp[i][j][2] = [i][j][1]+1;
//				2) 나머지(안 먹을경우) --> dp[i][j][k] = dp[i][j][k]


			}
		}
		
		answer = Math.max(Math.max(dp[n][n][0], dp[n][n][1]), dp[n][n][2]);
		System.out.println(answer);
		
		
	}

}
