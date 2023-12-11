package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Practice7662 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 데이터 수
		int t = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<t; i++) {
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			int k = Integer.valueOf(br.readLine());
			
			for(int j = 0; j<k; j++) {
				String[] read = br.readLine().split(" ");
				String input = read[0];
				int n = Integer.valueOf(read[1]);
				
				//삽입 연산
				if(input.equals("I")) {
					map.put(n, map.getOrDefault(n, 0)+1); // 있으면 기존 값 +1, 없으면 0
				}else if(input.equals("D")) {
					if(map.isEmpty()) {
						continue;
					}
					if(n == 1) { // 최댓값 삭제
						if(map.get(map.lastKey()) > 1) {
							map.put(map.lastKey(), map.get(map.lastKey()) -1);
						}else {
							map.remove(map.lastKey());
						}
					}else if(n == -1) { // 최솟값 삭제
						if(map.get(map.firstKey()) > 1) {
							map.put(map.firstKey(), map.get(map.firstKey())-1);
						}else {
							map.remove(map.firstKey());
						}
					}
				}
				
				
			}
			
			if(map.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(map.lastKey() + " " + map.firstKey());
			}
		}
		
		

	}

}
