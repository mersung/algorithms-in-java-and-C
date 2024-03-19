package DynamicProgramming;

import java.io.*;
import java.util.*;

//두 전봇대 A와 B 사이에 하나 둘씩 전깃줄을 추가하다 보니 전깃줄이 서로 교차하는 경우가 발생하였다. 합선의 위험이 있어 이들 중 몇 개의 전깃줄을 없애 전깃줄이 교차하지 않도록 만들려고 한다.
//
//예를 들어, < 그림 1 >과 같이 전깃줄이 연결되어 있는 경우 A의 1번 위치와 B의 8번 위치를 잇는 전깃줄, A의 3번 위치와 B의 9번 위치를 잇는 전깃줄, 
//A의 4번 위치와 B의 1번 위치를 잇는 전깃줄을 없애면 남아있는 모든 전깃줄이 서로 교차하지 않게 된다.
//
//
//
//< 그림 1 >
//
//전깃줄이 전봇대에 연결되는 위치는 전봇대 위에서부터 차례대로 번호가 매겨진다. 전깃줄의 개수와 전깃줄들이 두 전봇대에 연결되는 위치의 번호가 주어질 때, 
//남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 두 전봇대 사이의 전깃줄의 개수가 주어진다. 전깃줄의 개수는 100 이하의 자연수이다. 둘째 줄부터 한 줄에 하나씩 전깃줄이 A전봇대와 연결되는 위치의 번호와 
//B전봇대와 연결되는 위치의 번호가 차례로 주어진다. 위치의 번호는 500 이하의 자연수이고, 같은 위치에 두 개 이상의 전깃줄이 연결될 수 없다.
//
//출력
//첫째 줄에 남아있는 모든 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수를 출력한다.
//
//예제 입력 1 
//8
//1 8
//3 9
//2 2
//4 1
//6 4
//10 10
//9 7
//7 6
//예제 출력 1 
//3

public class Practice2565 {
	
	static int n;
	static int[][] ab;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		ab = new int[n][2]; 
		
		// 아이디어 : A전봇대인덱스와 B전봇대 인덱스 매칭되므로, A전봇대 인덱스로 정렬
		// --> A전봇대 인덱스 순서대로, B와 매칭된 기준이 나옴. 여기서 증가를 해줘야 전깃줄이 겹치지 않는다. A인덱스는 올라가는데, B인덱스가 낮아질 경우 전깃줄이 꼬인다.
		// --> 똑같이 올라가줘야함 = 최장 증가수열. 즉 최장 증가수열은 설치할 수 있는 전깃줄 수 이므로, 전체에서 최대 설치할 수 있는 전깃줄 수를 빼면 제거해야 할 수가 나온다.
		for(int i = 0; i<n; i++) {
			String[] c = br.readLine().split(" ");
			ab[i][0] = Integer.valueOf(c[0]);
			ab[i][1] = Integer.valueOf(c[1]);
		}
		
		Arrays.sort(ab, (o1,o2) -> o1[0] - o2[0]); 
		
		int[] dp = new int[n];
		
		for(int i = 0; i<n; i++) { //최장 증가 수열, 현재 인덱스 전까지 돌면서, 내가 더 크면 그 숫자의 최장 증가 수열 수에 +1 해주면 됨
			dp[i] = 1;
			for(int j = 0; j<i; j++) {
				if(ab[i][1] > ab[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			max = Math.max(dp[i], max);
		}
		
		System.out.println(n-max);
		
	}

}
