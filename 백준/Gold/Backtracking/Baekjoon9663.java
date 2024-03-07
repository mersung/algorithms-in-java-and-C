package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//문제
//N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
//
//N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다. (1 ≤ N < 15)
//
//출력
//첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
//
//예제 입력 1 
//8
//예제 출력 1 
//92

public class Practice9663 {
	
	static int n;
	static int[] board;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		
		board = new int[n]; //각 행(index)마다 체스가 있는 열 저장
		
		backtracking(0);
		
		System.out.println(answer);

	}
	
	static void backtracking(int depth) {
		if(depth == n) {
			answer += 1;
			return;
		}
		//보드 전체 돌면서 퀸 놓기
		for(int i = 0; i<n; i++) {
			if(check(depth, i) == true) {
				board[depth] = i;
				backtracking(depth + 1);
				board[depth] = 0;
			}
		}
	}

	static boolean check(int depth, int col) {
		for(int i = 0; i<depth; i++) {
			//같은 열이 있는지 확인
			if(board[i] == col) {
				return false;
			}
			//대각선 방향이 있는 경우
			if(Math.abs(depth - i) == Math.abs(col - board[i])) {
				return false;
			}
		}
		return true;
	}
	
}
