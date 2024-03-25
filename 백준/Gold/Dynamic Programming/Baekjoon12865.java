package DynamicProgramming;

//문제
//이 문제는 아주 평범한 배낭에 관한 문제이다.
//
//한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
//
//준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
//아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
//
//입력
//첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 
//두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
//
//입력으로 주어지는 모든 수는 정수이다.
//
//출력
//한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
//
//예제 입력 1 
//4 7
//6 13
//4 8
//3 6
//5 12
//예제 출력 1 
//14
import java.io.*;
import java.util.*;

public class Practice12865 {
	
	static int n;
	static int k; //최대 무게
//	static ArrayList<Item> bag = new ArrayList();
	
//	static class Item{
//		int weight;
//		int value;
//		
//		public Item(int weight, int value) {
//			this.weight = weight;
//			this.value = value;
//		}
//	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		n = Integer.valueOf(nk[0]);
		k = Integer.valueOf(nk[1]);
		
		int[] weight = new int[n+1];
		int[] value = new int[n+1];
		for(int i = 1; i<n+1; i++) {
			String[] wv = br.readLine().split(" ");
//			bag.add(new Item(Integer.valueOf(wv[0]), Integer.valueOf(wv[1])));
			weight[i] = Integer.valueOf(wv[0]);
			value[i] = Integer.valueOf(wv[1]);
		}
		
		int[][] dp = new int[n+1][k+1]; // 행 : 아이템 개수, 열 : 가방 무게
	
		for(int i = 1; i<n+1; i++) { //아이템 인덱스, i번째 아이템까지 도는 중
			for(int j = 1; j<k+1; j++) { //총 무게 인덱스, 이 무게까지 더해진 아이템 값어치 합계
				if(weight[i] <= j) { //i번째 아이템 무게가 감당 가능한 무게일 경우
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]); //가방에 아이템 담을지 말지
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
