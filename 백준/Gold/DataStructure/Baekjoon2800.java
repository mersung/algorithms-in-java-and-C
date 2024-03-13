package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

//어떤 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 계산하는 프로그램을 작성하시오.
//
//이 수식은 괄호가 올바르게 쳐져 있다. 예를 들면, 1+2, (3+4), (3+4*(5+6))와 같은 식은 괄호가 서로 쌍이 맞으므로 올바른 식이다.
//
//하지만, 1+(2*3, ((2+3)*4 와 같은 식은 쌍이 맞지 않는 괄호가 있으므로 올바른 식이 아니다.
//
//괄호를 제거할 때는, 항상 쌍이 되는 괄호끼리 제거해야 한다.
//
//예를들어 (2+(2*2)+2)에서 괄호를 제거하면, (2+2*2+2), 2+(2*2)+2, 2+2*2+2를 만들 수 있다. 하지만, (2+2*2)+2와 2+(2*2+2)는 만들 수 없다. 그 이유는 쌍이 되지 않는 괄호를 제거했기 때문이다.
//
//어떤 식을 여러 쌍의 괄호가 감쌀 수 있다.
//
//입력
//첫째 줄에 음이 아닌 정수로 이루어진 수식이 주어진다. 이 수식은 괄호가 올바르게 쳐져있다. 숫자, '+', '*', '-', '/', '(', ')'로만 이루어져 있다. 수식의 길이는 최대 200이고, 괄호 쌍은 적어도 1개, 많아야 10개이다. 
//
//출력
//올바른 괄호 쌍을 제거해서 나올 수 있는 서로 다른 식을 사전 순으로 출력한다.
//
//예제 입력 1 
//(0/(0))
//예제 출력 1 
//(0/0)
//0/(0)
//0/0
//예제 입력 2 
//(2+(2*2)+2)
//예제 출력 2 
//(2+2*2+2)
//2+(2*2)+2
//2+2*2+2
//예제 입력 3 
//(1+(2*(3+4)))
//예제 출력 3 
//(1+(2*3+4))
//(1+2*(3+4))
//(1+2*3+4)
//1+(2*(3+4))
//1+(2*3+4)
//1+2*(3+4)
//1+2*3+4
//출처

public class Practice2800 {
	
	static ArrayList<Node> indexList = new ArrayList<>();
	static Stack<Integer> stack = new Stack();
	static boolean[] visited;
	static TreeSet<String> answer = new TreeSet(); // set인데 자동 정렬
	static char[] c;
	
	static class Node{
		int left;
		int right;
		
		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		c = br.readLine().toCharArray();
		for(int i = 0; i<c.length; i++) {
			if(c[i] == '(') { // (을 먼저 담아놓고, )이 나오면 스택에서 빼면 쌍이 된다.
				stack.add(i);
			}else if(c[i] == ')') {// 스택에서 뽑은것과 담으면 인덱스 쌍이 된다.
				indexList.add(new Node(stack.pop(), i));
			}
		}
		
		visited = new boolean[indexList.size()];
		backtracking(0, 0);
		for(String ans : answer) {
			System.out.println(ans);
		}

	}
	//백트래킹은 visited을 안 쓰고 index를 따로 안 넘긴다면 중복을 허용하는 순열이 된다.
		//visited를 쓰고 index를 따로 넘기지 않으면, 중복을 허용하지 않지만 123, 213 둘 다 나와서 순열이 된다.
		//visited를 쓰고 index를 따로 넘기면 123, 23, 3 이렇게만 나와서 조합이 된다.
	static void backtracking(int depth, int index) { // 인덱스를 안 넣고 visited만 돌리면, 조합이 아님, 즉 132와 123은 다르게 되므로 중복 생김, 이는 조합이 아니라 순열? permutaion
		
		if(depth == indexList.size()) {
			return;
		}
		
		for(int i = index; i<indexList.size(); i++) {
			int left = indexList.get(i).left;
			int right = indexList.get(i).right;
			
			if(visited[i] == true) continue;
//			char[] temp = c; // c는 배열 객체이므로 주소가 복사됨.
//			char[] temp = c.clone();
//			str = str.substring(0,left) + str.substring(left+1, right) + str.substring(right+1, str.length());
//			c[left] = ' ';
//			c[right] = ' ';
//			str = String.valueOf(c).replaceAll(" ", "");
//			StringBuilder sb = new StringBuilder(String.valueOf(c));// StringBuilder는 주소 복사가 아님
//			sb.setCharAt(left, ' ');
//			sb.setCharAt(right, ' ');
			
			c[left] = ' ';
			c[right] = ' ';
			
			visited[i] = true;
			answer.add(String.valueOf(c).replaceAll(" ", ""));
			backtracking(depth+1, index+1);
			
//			sb.setCharAt(left, '(');
//			sb.setCharAt(right, ')');
//			str = sb.toString();
			c[left] = '(';
			c[right] = ')';
			visited[i] = false;
//			c = temp;
			
		}
		
	}
}
