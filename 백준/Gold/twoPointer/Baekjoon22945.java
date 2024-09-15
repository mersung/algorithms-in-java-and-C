package TwoPointer;


//문제
//개발자 
//$N$명이 팀 빌딩을 위해 한 줄로 서있다.
//
//하나의 팀을 만들기 위해서는 개발자 2명이 반드시 모여야 한다.
//
//개발자 A와 개발자 B가 팀을 만들 때 팀의 능력치는 아래와 같이 계산이 된다.
//
//(개발자 A와 개발자 B 사이에 존재하는 다른 개발자 수) × min(개발자 A의 능력치, 개발자 B의 능력치)
//예를 들어, 4명의 개발자가 존재할 때, 각 개발자의 능력치를 1 4 2 5라고 하자. 이때 능력치가 1인 개발자와 능력치가 5인 개발자가 한 팀을 이뤘다고 가정하자. 그러면 이 팀의 능력치는 
//$2×min(1, 5) = 2$가 된다.
//
//팀 빌딩에서 나올 수 있는 팀 중 능력치의 최대값을 구해보자.
//
//입력
//첫 번째 줄에 개발자의 수 
//$N$이 주어진다.
//
//두 번째 줄에는 
//$N$의 개발자의 각 능력치 
//$x_{i}$가 공백으로 구분되어 주어진다.
//
//출력
//팀의 능력치 최댓값을 출력한다.
//
//제한
// 
//$2 ≤ N ≤ 100,000$ 
// 
//$1 ≤ x_i ≤ 10,000$, 
//$x_i$는 정수
//예제 입력 1 
//4
//1 4 2 5
//예제 출력 1 
//4
import java.io.*;
import java.util.*;
public class Baekjoon22945 {
	
	static int n;
	static int[] arr;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		arr = new int[n];
		
		String[] strArr = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.valueOf(strArr[i]);
		}
		
		// 왼쪽부터 오른쪽으로
		int right = n-1;
		int left = 0;
		while(right > left) {
			int value = (right - left - 1) * Math.min(arr[right], arr[left]);
			answer = Math.max(value, answer);
			
			if(arr[left] > arr[right]) {
				right--;
			}else {
				left++;
			}
		}
		
		System.out.println(answer);
	}

}
