package Simulation;

//부동산 투자로 억대의 돈을 번 상도는 최근 N×N 크기의 땅을 구매했다. 상도는 손쉬운 땅 관리를 위해 땅을 1×1 크기의 칸으로 나누어 놓았다. 
//각각의 칸은 (r, c)로 나타내며, r은 가장 위에서부터 떨어진 칸의 개수, c는 가장 왼쪽으로부터 떨어진 칸의 개수이다. r과 c는 1부터 시작한다.
//
//상도는 전자통신공학과 출신답게 땅의 양분을 조사하는 로봇 S2D2를 만들었다. S2D2는 1×1 크기의 칸에 들어있는 양분을 조사해 상도에게 전송하고, 
//모든 칸에 대해서 조사를 한다. 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
//
//매일 매일 넓은 땅을 보면서 뿌듯한 하루를 보내고 있던 어느 날 이런 생각이 들었다.
//
//나무 재테크를 하자!
//
//나무 재테크란 작은 묘목을 구매해 어느정도 키운 후 팔아서 수익을 얻는 재테크이다. 상도는 나무 재테크로 더 큰 돈을 벌기 위해 M개의 나무를 구매해 땅에 심었다. 
//같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
//
//이 나무는 사계절을 보내며, 아래와 같은 과정을 반복한다.
//
//봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다. 하나의 칸에 여러 개의 나무가 있다면, 
//나이가 어린 나무부터 양분을 먹는다. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
//
//여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
//
//가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 
//어떤 칸 (r, c)와 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다. 
//상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
//
//겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
//
//K년이 지난 후 상도의 땅에 살아있는 나무의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N, M, K가 주어진다.
//
//둘째 줄부터 N개의 줄에 A배열의 값이 주어진다. r번째 줄의 c번째 값은 A[r][c]이다.
//
//다음 M개의 줄에는 상도가 심은 나무의 정보를 나타내는 세 정수 x, y, z가 주어진다. 처음 두 개의 정수는 나무의 위치 (x, y)를 의미하고, 마지막 정수는 그 나무의 나이를 의미한다.
//
//출력
//첫째 줄에 K년이 지난 후 살아남은 나무의 수를 출력한다.
//
//제한
//1 ≤ N ≤ 10
//1 ≤ M ≤ N2
//1 ≤ K ≤ 1,000
//1 ≤ A[r][c] ≤ 100
//1 ≤ 입력으로 주어지는 나무의 나이 ≤ 10
//입력으로 주어지는 나무의 위치는 모두 서로 다름
//예제 입력 1 
//1 1 1
//1
//1 1 1
//예제 출력 1 
//1
//예제 입력 2 
//1 1 4
//1
//1 1 1
//예제 출력 2 
//0
//예제 입력 3 
//5 2 1
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 3 
//2
//예제 입력 4 
//5 2 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 4 
//15
//예제 입력 5 
//5 2 3
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 5 
//13
//예제 입력 6 
//5 2 4
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 6 
//13
//예제 입력 7 
//5 2 5
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 7 
//13
//예제 입력 8 
//5 2 6
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 3 2 3 2
//2 1 3
//3 2 3
//예제 출력 8 
//85
//노트
//나무 재테크와 관련된 내용은 이 링크를 참고했다.
//
//출처
import java.io.*;
import java.util.*;
public class Practice16235 {
	
	static int n;
	static int m;
	static int k;
	static int[][] added; //더해져야할 양분
	static int[][] food;
	static ArrayList<Tree> tree = new ArrayList();
	static ArrayDeque<Integer> deadTree = new ArrayDeque();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	
	static class Tree{
		int x;
		int y;
		int age;
		boolean dead;
		public Tree(int x, int y, int age, boolean dead) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.dead = dead;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmk = br.readLine().split(" ");
		n = Integer.valueOf(nmk[0]);
		m = Integer.valueOf(nmk[1]);
		k = Integer.valueOf(nmk[2]);
		added = new int[n+1][n+1];
		food = new int[n+1][n+1];
		
		for(int i = 1; i<n+1; i++) {
			String[] row = br.readLine().split(" ");
			for(int j = 1; j<n+1; j++) {
				added[i][j] = Integer.valueOf(row[j-1]);
				food[i][j] = 5;
			}
		}
		
		for (int i = 0; i < m; i++) {
            String[] xyz = br.readLine().split(" ");
            int x = Integer.valueOf(xyz[0]);
            int y = Integer.valueOf(xyz[1]);
            int z = Integer.valueOf(xyz[2]);
            tree.add(new Tree(x,y,z,false));
        }
		Collections.sort(tree, (o1,o2) -> o1.age-o2.age);
		for(int i = 0; i<k; i++) {//k년동안
			spring();
			
			fall();
		}
		int answer = tree.size();

		System.out.println(answer);
	}
	
	static void spring() {
		int size = tree.size();
		ArrayList<Tree> newTreeIndex = new ArrayList();//새로운 트리
		ArrayList<Tree> deadTreeList = new ArrayList();
		for(int i = 0; i<size; i++) {//트리가 있는 곳들 인덱스 가져옴
			Tree t = tree.get(i);
			 //그 좌표에 들어있는 나무 개수만큼
			if(food[t.x][t.y] >= t.age) {
				food[t.x][t.y] -= t.age;
				t.age += 1;
				newTreeIndex.add(t);
			}else {//양분 부족한 경우, 죽음, 양분 증가
				deadTreeList.add(t);
			}
		}
		
		for(Tree t : deadTreeList) {
			food[t.x][t.y] += t.age/2;
		}
		tree = newTreeIndex;
	}
	
	static void fall() {
		int size = tree.size();
		for(int i = 0; i<size; i++) {
			Tree t = tree.get(i); //트리가 있는 곳들 인덱스 가져옴
			
			if(t.age%5 != 0)continue; //5의 배수가 아니면 넘어감
			
			for(int j = 0; j<8; j++) {
				int nx = t.x+dx[j];
				int ny = t.y+dy[j];
				if(nx >= 1 && nx<=n && ny>=1 && ny<=n) {
					tree.add(new Tree(nx, ny, 1, false));
				}
			}
		}
		Collections.sort(tree, (o1,o2) -> o1.age-o2.age);
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				food[i][j] += added[i][j];
			}
		}
	}

}
