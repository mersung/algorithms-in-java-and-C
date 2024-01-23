package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//문제
//회문(回文) 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열을 말한다. 예를 들어 ‘abba’ ‘kayak’, ‘reviver’, ‘madam’은 모두 회문이다. 
//만일 그 자체는 회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문”(pseudo palindrome)이라고 부른다. 
//예를 들어 ‘summuus’는 5번째나 혹은 6번째 문자 ‘u’를 제거하여 ‘summus’인 회문이 되므로 유사회문이다.
//
//여러분은 제시된 문자열을 분석하여 그것이 그 자체로 회문인지, 또는 한 문자를 삭제하면 회문이 되는 “유사회문”인지, 아니면 회문이나 유사회문도 아닌 일반 문자열인지를 판단해야 한다. 
//만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다. 
//
//입력
//입력의 첫 줄에는 주어지는 문자열의 개수를 나타내는 정수 T(1 ≤ T ≤ 30)가 주어진다. 다음 줄부터 T개의 줄에 걸쳐 한 줄에 하나의 문자열이 입력으로 주어진다. 
//주어지는 문자열의 길이는 3 이상 100,000 이하이고, 영문 알파벳 소문자로만 이루어져 있다.
//
//출력
//각 문자열이 회문인지, 유사 회문인지, 둘 모두 해당되지 않는지를 판단하여 회문이면 0, 유사 회문이면 1, 둘 모두 아니면 2를 순서대로 한 줄에 하나씩 출력한다.

public class Practice17609 {
	
	static int n;
	static String str;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<n; i++) {
			str = br.readLine();
			int answer = checkOne(str, 0, str.length()-1, 0); 
			if(answer == 0) {
				System.out.println('0');
			}else if(answer == 1) {
				System.out.println('1');
			}else {
				System.out.println('2');
			}
		}

	}
	
	static int checkOne(String recStr, int left, int right, int cnt) {
		while(left<right) {
			char leftChar = recStr.charAt(left);
			char rightChar = recStr.charAt(right);
			
			if(leftChar == rightChar) {
				left += 1;
				right -= 1;
				continue;
			}
			
			cnt++;
			if(cnt >= 2) return 2;

			int flag = checkOne(recStr, left, right-1, cnt);
			if(flag == 1) { // right-1 하는게 올바른 값, 유사회문 확정
				right -= 1;
				continue;
			}
					
			flag = checkOne(recStr, left+1, right, cnt);
			if(flag == 1) { // left + 1 하는게 올바른 값, 유사회문 확정
				left += 1;
				continue;
			}
		}
		System.out.println(cnt);
		return cnt;
	}

}
