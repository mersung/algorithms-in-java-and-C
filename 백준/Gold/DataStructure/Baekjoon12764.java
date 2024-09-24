package DataStructure;

//문제
//현재 대한민국 해군에 소속되어있는 준하는 문제를 풀기 위해 매일같이 사이버 지식 정보방 통칭 싸지방에 다닌다. 
//그러나 최근 문제가 생겼다. 싸지방에 사람이 몰려 컴퓨터 수가 모자라게 된 것이다. 이런 사태를 도저히 용납할 수 없었던 준하는 
//곧 전역하는 선임을 설득해 민원을 넣도록 하는 데 성공했다.
//
//마침내 부대에서는 민원을 받아들이기로 하였고, 컴퓨터를 증설하기로 했다. 또한, 컴퓨터 간의 사용률에 따라 다른 성능의 컴퓨터를 설치하고자 한다.
//
//하지만 예산이 부족해 사람 수 만큼 컴퓨터를 살 수가 없었다. 고심에 고심을 거듭한 준하는 모든 사람이 항상 정해진 시간에 싸지방을 이용한다는 사실을 발견했다.
//
//컴퓨터가 있는 자리에는 1번부터 순서대로 번호가 매겨져 있다. 모든 사람은 싸지방에 들어왔을 때 비어있는 자리 중에서 번호가 가장 작은 자리에 앉는 것이 규칙이다.
//
//준하가 발견한 사실과 이용 규칙을 가지고, 모든 사람이 기다리지 않고 싸지방을 이용할 수 있는 컴퓨터의 최소 개수와 자리별로 몇 명의 사람이 사용했는가를 구하시오.
//
//입력
//첫째 줄에 사람의 수를 나타내는 
//\(N\)이 주어진다. 
//\((1 \le N \le 100,000)\) 둘째 줄부터 
//\(N\)개의 줄에 걸쳐서 각 사람의 컴퓨터 이용 시작 시각 
//\(P\)와 종료 시각 
//\(Q\)가 주어진다. 
//\((0 \le P \lt Q \le 1,000,000)\) 
//
//시작 시각이나 종료 시각이 다른 사람과 겹치는 경우는 없다.
//
//출력
//첫째 줄에 사람이 모든 사람이 기다리지 않아도 되는 컴퓨터의 최소 개수 
//\(X\)를 출력한다.
//
//둘째 줄에는 1번 자리부터 
//\(X\)번 자리까지 순서대로 각 자리를 사용한 사람의 수를 띄어쓰기 간격으로 출력한다.
//
//예제 입력 1 
//5
//20 50
//10 100
//30 120
//60 110
//80 90
//예제 출력 1 
//4
//1 2 1 1
import java.io.*;
import java.util.*;
public class Practice12764 {
	
	static int n;
	
	static class Computer{
		
		int cnt;
		int start;
		int end;
		
		public Computer(int cnt, int start, int end) {
			this.cnt = cnt;
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine()); //사람의 수
		PriorityQueue<Computer> queue = new PriorityQueue<Computer>((o1, o2) -> o1.end - o2.end); //컴퓨터 끝나는 시간 가장 빠른 것 부터 출력
		ArrayList<int[]> people = new ArrayList();
		ArrayList<Computer> computers = new ArrayList();
		
		for(int i = 0; i<n; i++) {
			String[] se = br.readLine().split(" ");
			
			int start = Integer.valueOf(se[0]);
			int end = Integer.valueOf(se[1]);
			
			people.add(new int[] {start, end});
		}
		
		//시작 시간이 빠른 사람들 부터 출력하도록
		Collections.sort(people, (o1, o2) -> o1[0] - o2[0]);
		
		for(int[] se : people) {
			int start = se[0];
			int end = se[1];
			
			if(!queue.isEmpty()) {
				Computer computer = queue.peek();
				
				//가장 빨리 끝나는 컴퓨터보다 늦게 시작시, 해당 컴퓨터 이용자 수와 끝나는 시간 update, Queue는 삽입, 삭제(poll, remove 등)이 일어날 때만 내부에서 다시 정렬 함
				//단순 객체 값을 업데이트 하면 정렬되지 않아 poll()과 add()를 해줘야 함 
				if(start >= computer.end) {
					Computer currentComputer = queue.poll();
					currentComputer.end = end;
					currentComputer.cnt += 1;
					queue.add(currentComputer); // new 해주면 computers가 참조하는 객체가 아니기 때문에 변경 됨
				}else {//더 일찍 시작 하는 경우, 새로운 컴퓨터 추가
					Computer newComputer = new Computer(1, start, end);
					queue.add(newComputer);
					computers.add(newComputer);
				}
			}else {
				Computer newComputer = new Computer(1, start, end);
				queue.add(newComputer);
				computers.add(newComputer);
			}
		}
		
		System.out.println(computers.size());
//		ArrayList<Computer> list = new ArrayList(queue);
//		
//		Collections.sort(list, (o1, o2) -> o1.index - o2.index);
		
		for(Computer com : computers) {
			System.out.print(com.cnt + " ");
		}
	}

}
