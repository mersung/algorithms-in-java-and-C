package BinarySearch;

import java.io.*;
import java.util.*;
//서강 백화점이 블랙 프라이데이를 맞아서 특별 이벤트를 진행한다. 백화점에서 제시하는 양의 정수의 무게 C에 딱 맞게 물건들을 가져오면 전부 만 원에 판매하는 이벤트이다.
//
//선택할 수 있는 물건은 최대 3개까지이고, 같은 물건을 중복 선택하는 것은 불가능하다. 그리고 백화점에서 판매하는 물건들의 무게는 모두 다르다.
//
//예를 들어, 백화점에서 판매하고 있는 물건 5개의 무게가 각각 1, 2, 3, 4, 5일 때, C가 5라면 {2, 3} 또는 {5}에 해당하는 물건의 조합을 만 원에 구매할 수 있다.
//
//판매하는 물건 N개의 양의 정수의 무게가 각각 주어질 때, 만 원에 구매할 수 있는 조합이 있는지 출력하라.
//
//입력
//첫 번째 줄에 물건의 개수 N과 제시하는 무게 C가 공백으로 구분되어 주어진다. (1 ≤ N ≤ 5,000, 1 ≤ C ≤ 108, N과 C는 양의 정수)
//
//다음 줄에는 N개의 물건 각각의 무게 w가 공백으로 구분되어 주어진다. (1 ≤ w ≤ 108, w는 양의 정수)
//
//출력
//문제의 조건을 만족하는 조합이 있으면 1, 그렇지 않으면 0을 출력한다.
//
//예제 입력 1 
//5 5
//1 2 3 4 5
//예제 출력 1 
//1
//예제 입력 2 
//3 13
//3 7 8
//예제 출력 2 
//0

public class Practice18114 {

	static int n;
	static int c;
	static int[] weight;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nc = br.readLine().split(" ");
		n = Integer.valueOf(nc[0]);
		c = Integer.valueOf(nc[1]);
		
		String[] w = br.readLine().split(" ");
		weight = new int[n];
		for(int i = 0; i<w.length; i++) {
			weight[i] = Integer.valueOf(w[i]);
		}
		
		Arrays.sort(weight);
		
		int left = 0;
		int right = weight.length-1;
		
		//1개일때,
		for(int i = 0; i<weight.length; i++) {
			if(weight[i] == c) {
				System.out.println(1);
				System.exit(0);
			}
		}
		
		//2개일때, 한 개를 정해둔다
		for(int i = 0; i<weight.length-1; i++) {
			int first = weight[i];
			if(first > c) break;
			left = i+1;
			right = weight.length-1;
			while(left <= right) {
				int mid = (left+right)/2;
				int target = c-first;
				
				if(weight[mid] > target) {
					right = mid-1;
				}else if(weight[mid] < target) {
					left = mid+1;
				}else {
					System.out.println(1);
					System.exit(0);
				}
			}
		}
		
		//3개일때, 두 개를 정해두고 이분탐색
		for(int i = 0; i<weight.length-1; i++) {
			for(int j = i+1; j<weight.length; j++) {
				int first = weight[i] + weight[j];
				left = j+1;
				right = weight.length-1;
				if(first > c) break;
				
				while(left<=right) {
					int mid = (left+right)/2;
					
					int target = c - first;
					
					if(weight[mid] > target) {
						right = mid-1;
					}else if(weight[mid] < target) {
						left = mid+1;
					}else {
						System.out.println(1);
						System.exit(0);
					}
				}
				
			}
		}
		
		System.out.println(0);
				
	}

}
