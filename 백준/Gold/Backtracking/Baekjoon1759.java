package Backtracking;

import java.io.*;
import java.util.*;
public class Baekjoon1759 {
	
	static int l;
	static int c;
	static String[] str;
	
	static ArrayList<String> answer = new ArrayList();

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] lc = br.readLine().split(" ");
		l = Integer.valueOf(lc[0]);
		c = Integer.valueOf(lc[1]);
		
		str = br.readLine().split(" ");
		
		Arrays.sort(str);
		
//		System.out.println(Arrays.toString(str));
		
		StringBuilder sb = new StringBuilder("");
		backtracking(0, sb);
	}
	
	static void backtracking(int depth, StringBuilder ans) {
		if(ans.length() == l) {
			int m = 0;
			int j = 0;
			for(int i = 0; i<ans.length(); i++) {
				char c = ans.charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					m++;
				}else {
					j++;
				}
			}
			if(m >= 1 && j >= 2) {
				System.out.println(ans.toString());
			}
			return;
		}
		
		for(int i = depth; i<c; i++) {
			ans.append(str[i]);
			backtracking(i+1, ans);
			ans.deleteCharAt(ans.length()-1);
		}
	}

}
