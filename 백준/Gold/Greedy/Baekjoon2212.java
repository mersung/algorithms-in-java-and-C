package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

//한국도로공사는 고속도로의 유비쿼터스화를 위해 고속도로 위에 N개의 센서를 설치하였다. 문제는 이 센서들이 수집한 자료들을 모으고 분석할 몇 개의 집중국을 세우는 일인데, 
//예산상의 문제로, 고속도로 위에 최대 K개의 집중국을 세울 수 있다고 한다.
//
//각 집중국은 센서의 수신 가능 영역을 조절할 수 있다. 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 된다. 
//N개의 센서가 적어도 하나의 집중국과는 통신이 가능해야 하며, 집중국의 유지비 문제로 인해 각 집중국의 수신 가능 영역의 길이의 합을 최소화해야 한다.
//
//편의를 위해 고속도로는 평면상의 직선이라고 가정하고, 센서들은 이 직선 위의 한 기점인 원점으로부터의 정수 거리의 위치에 놓여 있다고 하자. 따라서, 각 센서의 좌표는 정수 하나로 표현된다. 
//이 상황에서 각 집중국의 수신 가능영역의 거리의 합의 최솟값을 구하는 프로그램을 작성하시오. 단, 집중국의 수신 가능영역의 길이는 0 이상이며 모든 센서의 좌표가 다를 필요는 없다.
//
//입력
//첫째 줄에 센서의 개수 N(1 ≤ N ≤ 10,000), 둘째 줄에 집중국의 개수 K(1 ≤ K ≤ 1000)가 주어진다. 셋째 줄에는 N개의 센서의 좌표가 한 개의 정수로 N개 주어진다. 
//각 좌표 사이에는 빈 칸이 하나 있으며, 좌표의 절댓값은 1,000,000 이하이다.
//
//출력
//첫째 줄에 문제에서 설명한 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력한다.
//
//예제 입력 1 
//6
//2
//1 6 9 3 6 7

 
//예제 출력 1 
//5
//예제 입력 2 
//10
//5
//20 3 14 6 7 8 18 10 12 15
//예제 출력 2 
//7

public class Practice2212 {
	
	static int n; //센서 개수
	static int k; //집중국 개수
	static HashSet<Integer> set = new HashSet<>();
	static Integer[] sensor; //센서 위치
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		k = Integer.valueOf(br.readLine());
//		sensor = new Integer[n];
		
		String[] s = br.readLine().split(" ");
		for(int i = 0; i<n; i++) {
			set.add(Integer.valueOf(s[i]));
		}
		
		int index = 0;
		sensor = new Integer[set.size()];
		for(int h : set) {
			sensor[index++] = h;
		}
		
		Arrays.sort(sensor);
		
		if(n<=k) { // 집중국이 다 커버할 수 있으면 
			System.out.println(0);
			System.exit(0);
		}
		
		Integer[] sensorDiff = new Integer[sensor.length-1];
		
		for(int i = 0; i<sensor.length-1; i++) { //차이를 담을 배열
			sensorDiff[i] = sensor[i+1] - sensor[i];
		}
		Arrays.sort(sensorDiff, Collections.reverseOrder());
//		System.out.println(Arrays.toString(sensorDiff));
		for(int i = 0; i<k-1; i++) {
			sensorDiff[i] = 0;
		}
		
		for(int i = 0; i<sensorDiff.length; i++) {
			answer += sensorDiff[i];
		}
		
		System.out.println(answer);
	}

}
