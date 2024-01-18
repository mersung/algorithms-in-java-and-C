package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Practice20191 {
	
	static TreeMap<String, Integer> map = new TreeMap<>(); // key값을 기준으로 정렬됨 
	static int n;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());

		for(int i = 0; i<n; i++) {
			String[] file = br.readLine().split("\\.");
			String fileName = file[0];
			String subName = file[1];
			
			if(map.containsKey(subName)) {
				map.put(subName, map.get(subName)+1);
			}else {
				map.put(subName, 1);
			}
		}
//		System.out.println(map.keySet());
//		System.out.println(map.values());
//		System.out.println(map.entrySet());
		for(String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}

}
