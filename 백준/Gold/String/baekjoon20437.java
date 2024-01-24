package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

//작년에 이어 새로운 문자열 게임이 있다. 게임의 진행 방식은 아래와 같다.
//
//1. 알파벳 소문자로 이루어진 문자열 W가 주어진다.
//2. 양의 정수 K가 주어진다.
//3. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다.
//4. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다.
//위와 같은 방식으로 게임을 T회 진행한다.
//
//입력
//문자열 게임의 수 T가 주어진다. (1 ≤ T ≤ 100)
//
//다음 줄부터 2개의 줄 동안 문자열 W와 정수 K가 주어진다. (1 ≤ K ≤ |W| ≤ 10,000) 
//
//출력
//T개의 줄 동안 문자열 게임의 3번과 4번에서 구한 연속 문자열의 길이를 공백을 사이에 두고 출력한다.
//
//만약 만족하는 연속 문자열이 없을 시 -1을 출력한다.

public class Practice20437 {
	
	static int t;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<t; i++) {
			int[] answer = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
			
			String w = br.readLine();
			int k = Integer.valueOf(br.readLine());
			
			if(k == 1) {
				System.out.println("1 1");
				continue;
			}
			
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(int j = 0; j<w.length(); j++) {
				char c = w.charAt(j);
				if(map.containsKey(c)) { // 문자를 HashMap에 삽입, 개수 파악
					map.put(c, map.get(c)+1);
				}else {
					map.put(c, 1);
				}

			}
			
			for(int j = 0; j<w.length(); j++) {
				char c = w.charAt(j);
				
				if(map.get(c) >= k) { // k개 이상인 것들만 돌려보기
					
					HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
					tempMap.put(c, 1);
					
					for(int l = j+1; l<w.length(); l++) {
						char s = w.charAt(l);
						if(tempMap.containsKey(s)) {
							tempMap.put(s, tempMap.get(s)+1);
						}else {
							tempMap.put(s, 1);
						}
						if(c == s && tempMap.get(s) == k) {
							String ans = w.substring(j, l+1);

							answer[0] = Math.min(answer[0], ans.length());
							answer[1] = Math.max(answer[1], ans.length());

							break;
						}
					}
				}
			}
			if(answer[0] == Integer.MAX_VALUE) {
				System.out.println("-1");
			}else {
				System.out.println(answer[0] + " " + answer[1]);
			}
		}
	}

}
