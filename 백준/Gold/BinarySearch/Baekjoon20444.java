package BinarySearch;

//오늘도 역시 준성이는 어김없이 색종이와 쿼리를 푸는 데 실패하였다!!
//
//색종이에 열등감을 느낀 준성이는 가위로 눈에 보이는 색종이를 모두 잘라 버리려고 한다!!
//
//색종이를 자를 때는 다음과 같은 규칙을 따른다.
//
//색종이는 직사각형이며, 색종이를 자를 때는 한 변에 평행하게 자른다.
//자르기 시작했으면, 경로 상의 모든 색종이를 자를 때까지 멈추지 않는다.
//이미 자른 곳을 또 자를 수 없다.
//분노에 찬 가위질을 하던 준성이는 갑자기 하나의 색종이를 정확히 n번의 가위질로 k개의 색종이 조각으로 만들 수 있는지 궁금해졌다.
//궁금하지만 화가 나서 코딩에 집중할 수 없는 준성이 대신 코드를 작성해주도록 하자.
//
//입력
//첫 줄에 정수 n, k가 주어진다. (1 ≤ n ≤ 231-1, 1 ≤ k ≤ 263-1)
//
//출력
//첫 줄에 정확히 n번의 가위질로 k개의 색종이 조각을 만들 수 있다면 YES, 아니라면 NO를 출력한다.
//
//예제 입력 1 
//4 9
//예제 출력 1 
//YES
//
//
//예제 입력 2 
//4 6
//예제 출력 2 
//NO
//4번의 가위질을 하는 모든 경우에 대해서 하나의 색종이를 6개의 색종이 조각으로는 만들 수 없다.
//
//출처

import java.io.*;
import java.util.*;
public class Practice20444 {

	static Long n;
	static Long k;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		n = Long.valueOf(nk[0]);
		k = Long.valueOf(nk[1]);
		
		long left = 0; // 가로 자른 횟수, 0 ~ n/2
		long right = n; // 세로 자른 횟수, n - left
		long paper; // 현재 색종이 개수
		
		while(left <= right) {
			long row = (left+right)/2; //가로 횟수를 n/2부터 시작
			paper = (row+1) * (n-row+1); //가로 자른 횟수+1 x 세로 자른 횟수+1 == 종이 나뉜 갯수
			if(paper == k) {
				System.out.println("YES");
				System.exit(0);
			}
			if(paper < k) { //갯수가 더 적으므로, 늘려야함. left(가로 횟수)를 늘리면 갯수가 줄어듦.
				left = row+1;
			}else { //갯수가 더 크므로, 적게 만들어야함. 가로를 줄여야함
				right = row-1;
			}
		}
		System.out.println("NO");
	}

}
