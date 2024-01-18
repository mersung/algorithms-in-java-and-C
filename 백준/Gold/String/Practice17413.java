package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Practice17413 {
	
	static String s;
	static ArrayList<String> answer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		
		boolean check = false; // 꺽새 체크용
		
		Stack<Character> stack = new Stack<>();
		String str = "";
		
		for(int i = 0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			
			if(c == '<') { // 꺽새 시작
				while(!stack.isEmpty()) {
					str += stack.pop();
				}
				check = true;
				str += c;
				continue;
			}
			
			if(c == '>') { // 꺽새 마무리
				check = false;
				str += '>';
				continue;
			}
			
			if(check == false) {
				if(c == ' ' || i == s.length()-1) {
					if(c!=' ') stack.add(c);
					while(!stack.isEmpty()) {
						str += stack.pop();
					}
					if(str.length() >= 1) answer.add(str);
					str = "";
				}else {
					stack.add(c);
				}
			}else {
				str += c;
			}
			
		}
		if(str.length()>=1) answer.add(str);

		for(String st : answer) {
			System.out.print(st + " ");
		}
		
	}

}
