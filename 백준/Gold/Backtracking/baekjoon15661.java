package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Practice15661 {
	
	static int n;
	
	static int[][] board;
	
	static int answer = Integer.MAX_VALUE;
	
	static boolean[] team;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
	
		board = new int[n+1][n+1];
		
		for(int i = 1; i<n+1; i++) {
			String[] list = br.readLine().split(" ");
			for(int j = 1; j<n+1; j++) {
				board[i][j] = Integer.valueOf(list[j-1]);
			}
		}
		
		team = new boolean[n+1];
		
		for(int i = 1; i<n+1; i++) {
			backtracking(i,  0);
		}

		
		System.out.println(answer);
	}
	
	public static void backtracking(int start, int k) {
		if(k == n) return;
		
		if(k>=1 && k<n) {
			answer = Math.min(answer, getDiff(team));
		}

		for(int i = start; i<n+1; i++) { //나머지 남은 사람들 한 명씩 팀에 추가
			if(team[i] == false) {
				team[i] = true;
				k += 1;
				backtracking(i+1, k);
				team[i] = false;
				k -= 1;
			}
		}
		
	}
	
	public static int getDiff(boolean[] team) {
		int startSum = 0;
		int linkSum = 0;
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n + 1; j++) {
				if(i == j) continue;
				if(team[i] == true && team[j] == true) {
					startSum += board[i][j];
				}else if(team[i] == false && team[j] == false) {
					linkSum += board[i][j];
				}
			}
		}
		
		return Math.abs(startSum - linkSum);
	}

}
