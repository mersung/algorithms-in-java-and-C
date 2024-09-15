package Implementation;


//2018년 12월, 처음 시작하게 된 ZOAC의 오프닝을 맡은 성우는 누구보다 화려하게 ZOAC를 알리려 한다.
//
//앞 글자부터 하나씩 보여주는 방식은 너무 식상하다고 생각한 성우는 문자열을 보여주는 새로운 규칙을 고안해냈다!
//
//규칙은 이러하다. 아직 보여주지 않은 문자 중 추가했을 때의 문자열이 사전 순으로 가장 앞에 오도록 하는 문자를 보여주는 것이다.
//
//예를 들어 ZOAC를 보여주고 싶다면, A → AC → OAC → ZOAC 순으로 보여주면 된다.
//
//바쁜 성우를 위하여 이 규칙대로 출력해주는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 알파벳 대문자로 구성된 문자열이 주어진다. 문자열의 길이는 최대 100자이다.
//
//출력
//규칙에 맞게 순서대로 문자열을 출력한다.
//
//예제 입력 1 
//ZOAC
//예제 출력 1 
//A
//AC
//OAC
//ZOAC
//예제 입력 2 
//BAC
//예제 출력 2 
//A
//AC
//BAC
//예제 입력 3 
//STARTLINK
//예제 출력 3 
//A
//AI
//AIK
//AINK
//ALINK
//ARLINK
//ARTLINK
//SARTLINK
//STARTLINK
import java.io.*;
import java.util.*;
public class Baekjoon16719 {
	
	static int length;
	static boolean[] visited;
	static String str;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		length = str.length();
		visited = new boolean[length];
		
		dfs(0, length-1);

	}

	static void dfs(int left, int right) {
		
//		System.out.println(right);
		
		if(left > right) return;
		
		int minIndex = -1;
		for(int i = left; i <= right; i++) {
			
			if(visited[i] == true) continue;
			if(minIndex == -1 || str.charAt(minIndex) > str.charAt(i)) {
				minIndex = i;
			}
		}
//		System.out.println(minIndex);
		visited[minIndex] = true;
		print();
		
		dfs(minIndex + 1, right);
		dfs(left, minIndex - 1);
		
	}
	
	static void print() {
		
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i<length; i++) {
			if(visited[i] == true) {
				sb.append(str.charAt(i));
			}
		}
		
		System.out.println(sb.toString());
	}
}
