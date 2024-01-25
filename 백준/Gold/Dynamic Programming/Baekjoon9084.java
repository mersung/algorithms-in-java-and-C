package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//우리나라 화폐단위, 특히 동전에는 1원, 5원, 10원, 50원, 100원, 500원이 있다. 이 동전들로는 정수의 금액을 만들 수 있으며 그 방법도 여러 가지가 있을 수 있다. 
//예를 들어, 30원을 만들기 위해서는 1원짜리 30개 또는 10원짜리 2개와 5원짜리 2개 등의 방법이 가능하다.
//
//동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하시오.
//
//입력
//입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고 
//두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다. 각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다. 
//세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.
//
//편의를 위해 방법의 수는 231 - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.
//
//출력
//각 테스트 케이스에 대해 입력으로 주어지는 N가지 동전으로 금액 M을 만드는 모든 방법의 수를 한 줄에 하나씩 출력한다.

public class Practice9084 {
	
	static int t;
	static int cnt;
	static int m;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<t; i++) {
			int n = Integer.valueOf(br.readLine()); // 동전의 가지 수
			String[] arr = br.readLine().split(" "); // N가지 동전의 각 금액
			int[] coins = new int[arr.length];
			
			for(int j = 0; j<arr.length; j++) {
				coins[j] = Integer.valueOf(arr[j]);
			}
			
			m = Integer.valueOf(br.readLine()); // 만들어야 할 금액
			
			int[] dp = new int[m+1];
			
			for(int coin : coins) {
				for(int j = 1; j<m+1; j++) {
					int money = j-coin;
					if(money < 0) {
						continue;
					}else if(money == 0) { //코인 새로씀
						dp[j]++;
					}else {
						dp[j] += dp[money]; //이 전 코인으로 만들 수 있는 경우의 수 다 더하기
					}
					
				}
			}
			
			System.out.println(dp[m]);
			
		}
	}
	

}
//501 121 1
