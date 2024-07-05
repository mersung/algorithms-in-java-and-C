//문제
//준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//
//동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
//
//둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
//
//출력
//첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
//
//예제 입력 1 
//10 4200
//1
//5
//10
//50
//100
//500
//1000
//5000
//10000
//50000
//예제 출력 1 
//6
import java.io.*;
import java.util.*;
public class Main {
	
	static int n;
	static int k;
	static Integer[] coins;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		n = Integer.valueOf(nk[0]);
		k = Integer.valueOf(nk[1]);
		coins = new Integer[n];
		for(int i = 0; i<n; i++) {
			int coin = Integer.valueOf(br.readLine());
			coins[i] = coin;
			
		}
		
//		Collections.sort(coins, Collections.reverseOrder());
//		Collections.sort(coins, (o1,o2) -> o2 - o1);
		Arrays.sort(coins, Collections.reverseOrder());
		//Arrays.sort(coins, (o1, o2) -> o2 - o1);
		
//		System.out.println(Arrays.toString(coins.toArray()));
		int index = 0;
		int count = 0;
		
		while(k != 0) {
			
			for(int i = index; i<coins.length; i++) {
				
				int c = coins[i];
				if(c <= k) {
					// 시작점 교체
					index = i;
					//개수 올리기, 개수 곱한 만큼 빼기
					count += k/c;
					k = k%c;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
