package DisjointSet;

//문제
//초기에 
//$n+1$개의 집합 
//$\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
//
//집합을 표현하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 
//$n$, 
//$m$이 주어진다. 
//$m$은 입력으로 주어지는 연산의 개수이다. 다음 
//$m$개의 줄에는 각각의 연산이 주어진다. 합집합은 
//$0$ 
//$a$ 
//$b$의 형태로 입력이 주어진다. 이는 
//$a$가 포함되어 있는 집합과, 
//$b$가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 
//$1$ 
//$a$ 
//$b$의 형태로 입력이 주어진다. 이는 
//$a$와 
//$b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
//
//출력
//1로 시작하는 입력에 대해서 
//$a$와 
//$b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
//
//제한
// 
//$1 ≤ n ≤ 1\,000\,000$ 
// 
//$1 ≤ m ≤ 100\,000$ 
// 
//$0 ≤ a, b ≤ n$ 
// 
//$a$, 
//$b$는 정수
// 
//$a$와 
//$b$는 같을 수도 있다.
//예제 입력 1 
//7 8
//0 1 3
//1 1 7
//0 7 6
//1 7 1
//0 3 7
//0 4 2
//0 1 1
//1 1 1
//예제 출력 1 
//NO
//NO
//YES
import java.io.*;
import java.util.*;
public class Practice1717 {
	
	static int n;
	static int m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		parent = new int[n+1];
		
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m; i++) {
			String[] abc = br.readLine().split(" ");
			if(Integer.valueOf(abc[0]) == 0) { 
				//합침
				union(Integer.valueOf(abc[1]), Integer.valueOf(abc[2]));
			}else if(Integer.valueOf(abc[0]) == 1){
				int a = find(Integer.valueOf(abc[1]));
				int b = find(Integer.valueOf(abc[2]));
				if(a==b) {
					System.out.println("yes");
				}else {
					System.out.println("no");
				}
			}
		}
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return find(parent[x]);
		
	}
	
	static void union(int x, int y) {
		if(x == y) return;
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX > parentY) {
			parent[parentY] = parentX;
		}else if(parentY > parentX){
			parent[parentX] = parentY;
		}
	}

}
