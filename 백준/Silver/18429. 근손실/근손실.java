

import java.util.*;
import java.io.*;
public class Main {
	
	static int n; //8
	static int k; //50
	static int[] kit;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		n = Integer.valueOf(nk[0]);
		k = Integer.valueOf(nk[1]);
		kit = new int[n];
		visited = new boolean[n];
		
		String[] k = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			kit[i] = Integer.valueOf(k[i]);
		}
		
		backtracking(0, 500);
		System.out.println(answer);
		
	}
	
	static void backtracking(int depth, int power) {
		if(power < 500) {
			return;
		}
		if(depth == n) {
			answer += 1;
		}
		
		for(int i = 0; i<n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				power = power + kit[i] - k;
				backtracking(depth + 1, power);
				power = power - kit[i] + k;
				visited[i] = false;
			}
		}
	}

}
