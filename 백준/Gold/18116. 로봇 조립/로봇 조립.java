
import java.io.*;
import java.util.*;
public class Main {
	
	static int n;
	static int[] parent;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		parent = new int[1000001];
		cnt = new int[1000001];
		
		for(int i = 0; i<1000001; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
		
		for(int i = 0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			
			String qi = command[0];
			
			//I는 두 부품이 서로 같은 로봇의 부품이다라는 것을 알려줌
			if(qi.equals("I")) {
				int a = Integer.valueOf(command[1]);
				int b = Integer.valueOf(command[2]);
				
				union(a, b);
				
			}else if(qi.equals("Q")) {//Q는 해당 로봇의 부품이 몇 개인지 
				System.out.println(cnt[getParent(Integer.valueOf(command[1]))]);
			}
		}

	}
	
	static int getParent(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		parent[x] = getParent(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int parentX = getParent(x);
		int parentY = getParent(y);
		
		if(parentX > parentY) {
			parent[parentX] = parentY;
			cnt[parentY] += cnt[parentX];
			cnt[parentX] = 0;

		}else if(parentY > parentX) {
			parent[parentY] = parentX;
			cnt[parentX] += cnt[parentY];
			cnt[parentY] = 0;
		}else {
			return;
		}
	}
}
