package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Practice20164 {
	
	static int maxVal = Integer.MIN_VALUE;
	static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int num = Integer.valueOf(number);
		
		cutNumber(num, 0);
		
		System.out.println(minVal + " " + maxVal);
	}
	
	static void cutNumber(int n, int cnt) {
		cnt += getOddNumber(n); // 각 숫자 중에서 홀수의 개수 더하기
		
		if(n<10) { //한 자릿수이면 아무것도 하지 않고 종료
			maxVal = Math.max(maxVal, cnt);
			minVal = Math.min(minVal, cnt);
			return;
		}
		
		else if(n>=10 && n<=99) { //두 자릿수이면 서로 더해서 새로운 수
			String num = String.valueOf(n);
			String a = num.substring(0,1);
			String b = num.substring(1,2);
			int val = Integer.valueOf(a) + Integer.valueOf(b);
			cutNumber(val, cnt);
		}
		
		else { //세 자리 이상일경우 임의 위치에서 끊어서 더한다.
			String num = String.valueOf(n);
			for(int i = 0; i<num.length()-2; i++) {
				String a = num.substring(0,i+1);
				for(int j = i+1; j<num.length()-1; j++) {
					String b = num.substring(i+1, j+1);
					String c = num.substring(j+1, num.length());
					
					int sum = Integer.valueOf(a) + Integer.valueOf(b) + Integer.valueOf(c);
					cutNumber(sum, cnt);
				}
			}
		}
	}
	
	static int getOddNumber(int num) {
		int ans = 0;
		String strNum = String.valueOf(num);
		
		for(int i=0; i<strNum.length(); i++) {
			char chr = strNum.charAt(i);
			int n = Integer.valueOf(chr);
			
			if(n%2 == 1) ans+=1;
		}
		return ans;
	}
}
