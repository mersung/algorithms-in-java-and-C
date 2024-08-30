package String;

import java.io.*;
import java.util.*;

public class Practice9342 {
	
	static int t;
	static char[] strArr = new char[] {'A', 'B', 'C', 'D', 'E', 'F'};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<t; i++) {
			
			String str = br.readLine();
			String pattern = "[A-F]?A+F+C+[A-F]?$";
			
			if(str.matches(pattern)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
			
		}
	}

}
