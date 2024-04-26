package DataStructure;

import java.io.*;
import java.util.*;

//tony9402는 최근 깃헙에 코딩테스트 대비 문제를 직접 뽑아서 "문제 번호, 난이도"로 정리해놨다.
//
//깃헙을 이용하여 공부하시는 분들을 위해 새로운 기능을 추가해보려고 한다.
//
//만들려고 하는 명령어는 총 3가지가 있다. 아래 표는 각 명령어에 대한 설명이다.
//
//recommend 
//$x$ 	
// 
//$x$가 1인 경우 추천 문제 리스트에서 가장 어려운 문제의 번호를 출력한다.
//
//만약 가장 어려운 문제가 여러 개라면 문제 번호가 큰 것으로 출력한다.
//
// 
//$x$가 -1인 경우 추천 문제 리스트에서 가장 쉬운 문제의 번호를 출력한다.
//
//만약 가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것으로 출력한다.
//
//add 
//$P$ 
//$L$ 	추천 문제 리스트에 난이도가 
//$L$인 문제 번호 
//$P$를 추가한다. (추천 문제 리스트에 없는 문제 번호 
//$P$만 입력으로 주어진다. 이전에 추천 문제 리스트에 있던 문제 번호가 다른 난이도로 다시 들어 올 수 있다.)
//solved 
//$P$ 	추천 문제 리스트에서 문제 번호 
//$P$를 제거한다. (추천 문제 리스트에 있는 문제 번호 
//$P$만 입력으로 주어진다.)
//명령어 recommend는 추천 문제 리스트에 문제가 하나 이상 있을 때만 주어진다.
//
//명령어 solved는 추천 문제 리스트에 문제 번호가 하나 이상 있을 때만 주어진다.
//
//위 명령어들을 수행하는 추천 시스템을 만들어보자.
//
//입력
//첫 번째 줄에 추천 문제 리스트에 있는 문제의 개수 
//$N$ 가 주어진다.
//
//두 번째 줄부터 
//$N + 1$ 줄까지 문제 번호 
//$P$와 난이도 
//$L$가 공백으로 구분되어 주어진다.
//
// 
//$N + 2$줄은 입력될 명령문의 개수 
//$M$이 주어진다.
//
//그 다음줄부터 
//$M$개의 위에서 설명한 명령문이 입력된다.
//
//출력
//recommend 명령이 주어질 때마다 문제 번호를 한 줄씩 출력한다. 최소 한번의 recommend 명령어가 들어온다.
//
//제한
// 
//$1 \le N, P \le 100,000$ 
// 
//$1 \le M \le 10,000$ 
// 
//$1 \le L \le 100$, 
//$L$은 자연수
// 
//$x = \pm 1$ 
//예제 입력 1 
//5
//1000 1
//1001 2
//19998 78
//2667 37
//2042 55
//8
//add 1402 59
//recommend 1
//solved 1000
//solved 19998
//recommend 1
//recommend -1
//solved 1001
//recommend -1
//예제 출력 1 
//19998
//1402
//1001
//2667
public class Practice21939 {
	
	static HashMap<Integer, Integer> map = new HashMap();
	static int n;
	static int maxDiff = Integer.MIN_VALUE;
	static int minDiff = Integer.MAX_VALUE;
	static int m;
	static PriorityQueue<Problem> maxPq = new PriorityQueue<Problem>((o1, o2) -> o1.difficulty == o2.difficulty? o2.num - o1.num : o2.difficulty - o1.difficulty);
	static PriorityQueue<Problem> minPq = new PriorityQueue<Problem>((o1, o2) -> o1.difficulty == o2.difficulty? o1.num - o2.num : o1.difficulty - o2.difficulty);
	
	static class Problem{
		int num;
		int difficulty;
		
		public Problem(int num, int difficulty) {
			this.num = num;
			this.difficulty = difficulty;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<n; i++) {
			String[] nd = br.readLine().split(" ");
			int num = Integer.valueOf(nd[0]);
			int diff = Integer.valueOf(nd[1]);

			//문제 번호
			if(map.get(num) == null) {
				map.put(num, diff);
			}
			maxPq.add(new Problem(num, diff));
			minPq.add(new Problem(num, diff));
		}
		
		m = Integer.valueOf(br.readLine());
		for(int i = 0; i<m; i++) {
			String[] command = br.readLine().split(" ");
			String c = command[0];
			if(c.equals("add")) {
				int diff = Integer.valueOf(command[2]);
				int num = Integer.valueOf(command[1]);
				if(map.get(num) == null) {
					map.put(num, diff);
				}
				maxPq.add(new Problem(num, diff));
				minPq.add(new Problem(num, diff));
			}else if(c.equals("recommend")) {
				int idx = Integer.valueOf(command[1]);
				if(idx == 1) { //난이도 높으면서 가장 높은 문제번호, 아직 삭제가 안 되어 있어야함
					while(true) {
						if(maxPq.isEmpty()) break;
						Problem p = maxPq.peek();
						if(map.get(p.num) != null && map.get(p.num) == p.difficulty) {
							System.out.println(p.num);
							break;
						}else {
							maxPq.poll();
						}
					}
				}else if(idx == -1) {//난이도 낮으면서 가장 낮은 문제번호, 아직 삭제되지 않아야함
					while(true) {
						if(minPq.isEmpty()) break;
						Problem p = minPq.peek();
						if(map.get(p.num) != null && map.get(p.num) == p.difficulty) {
							System.out.println(p.num);
							break;
						}else {
							minPq.poll();
						}
					}
				}
			}else if(c.equals("solved")) {
				int num = Integer.valueOf(command[1]);
				map.remove(num);
			}
		}
	}

}
