
import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int l; //문제 난이도 합 최소
	static int r; //문제 난이도 합 최대
	static int x; //어려운 문제와 쉬운 문제의 난이도 차의 최소
	static int[] levels;
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nlrx = br.readLine().split(" ");
		n = Integer.valueOf(nlrx[0]);
		l = Integer.valueOf(nlrx[1]);
		r = Integer.valueOf(nlrx[2]);
		x = Integer.valueOf(nlrx[3]);
		levels = new int[n];
		
		String[] level = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			levels[i] = Integer.valueOf(level[i]);
		}
		
		backtracking(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

		System.out.println(answer);
		
	}
	
	static void backtracking(int start, int sum, int max, int min, int count) {
		
		if(count >= 2) {
			if(validationCheck(sum, max, min)) answer += 1;
		}

		for(int i = start; i<n; i++) {
			backtracking(i+1, sum+levels[i], Math.max(max, levels[i]), Math.min(min, levels[i]), count+1);
		}
	}
	
	static boolean validationCheck(int sum, int max, int min) {
		
		if(sum < l || sum > r) {
			return false;
		}
		
		if(Math.abs(max - min) < x) {
			return false;
		}
		
		return true;
	}

}
