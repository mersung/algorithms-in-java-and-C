package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//노드가 
//N개인 이진 트리가 있다. 트리를 중위 순회와 유사하게 순회하려고 한다. 이를 유사 중위 순회라고 하자.
//
//순회의 시작은 트리의 루트이고 순회의 끝은 중위 순회할 때 마지막 노드이다. 이때 루트 노드는 항상 1번 노드이다.
//
//유사 중위 순회는 루트 노드에서 시작하며, 다음과 같이 진행된다.
//
//현재 위치한 노드의 왼쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 왼쪽 자식 노드로 이동한다.
//그렇지 않고 현재 위치한 노드의 오른쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 오른쪽 자식 노드로 이동한다.
//그렇지 않고 현재 노드가 유사 중위 순회의 끝이라면, 유사 중위 순회를 종료한다.
//그렇지 않고 부모 노드가 존재한다면, 부모 노드로 이동한다.
//유사 중위 순회를 종료할 때까지 1 ~ 4를 반복한다.

public class Practice22856 {
	
	static int n;
	static HashMap<Integer, Integer[]> map = new HashMap<>();
	static int answer = 0;
	static int rightEdge = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<n; i++) {
			String[] abc = br.readLine().split(" ");
			map.put(Integer.valueOf(abc[0]), new Integer[2]);
			map.get(Integer.valueOf(abc[0]))[0] = Integer.valueOf(abc[1]); //왼쪽 자식
			map.get(Integer.valueOf(abc[0]))[1] = Integer.valueOf(abc[2]); //오른쪽 자식
		}
		
		dfs(1);
		getRightEdge(1);
		//answer에서, root부터 오른쪽 말단 노드까지 가지 수를 빼줘야함, 다시 복귀 안 하므로
		answer = answer*2-rightEdge;
		System.out.println(answer);
		
		
	}

	// 중위순회는 left - root - right 임
	static void dfs(int node) {
		
		if(!map.containsKey(node)) return; //키가 없으면 자식 없음
		
		int left = map.get(node)[0];
		int right = map.get(node)[1];
		
		if(left != -1) {
			dfs(left); //왼쪽 자식 있음
			answer += 1;
		}
		
		if(right != -1) {
			dfs(right);// 오른쪽 자식 있으면, 위에서 왼쪽 자식 호출했으므로 오른쪽 호출
			answer += 1;
		}
	}
	
	static void getRightEdge(int node) {
		if(map.containsKey(node)) {
			if(map.get(node)[1] != -1) {
				rightEdge += 1;
				getRightEdge(map.get(node)[1]);
			}
		}
	}
}
