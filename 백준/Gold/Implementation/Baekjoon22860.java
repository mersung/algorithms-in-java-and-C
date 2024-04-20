package Implementation;

import java.io.*;
import java.util.*;
public class Practice22860 {
	
	static int fileCnt;
	static int polderCnt;
	static int query;
	static HashMap<String, Integer> fileMap = new HashMap(); //파일 종류 및 개수 파악
	static HashMap<String, ArrayList<Item>> polderMap = new HashMap(); // 각 폴더마다 파일 또는 폴더 리스트 담기

	static class Item{
		int isFile;
		String name;
		public Item(String name, int status) {
			this.name = name;
			this.isFile = status;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		polderCnt = Integer.valueOf(nm[0]);
		fileCnt = Integer.valueOf(nm[1]);
		
		for(int i = 0; i<fileCnt+polderCnt; i++) { //폴더 및 파일 구조 
			String[] pfc = br.readLine().split(" ");
			
			int isFile = Integer.valueOf(pfc[2]) == 1? 0 : 1;
			
			if(polderMap.containsKey(pfc[0])) { //폴더가 있는 경우
				polderMap.get(pfc[0]).add(new Item(pfc[1], isFile));
			}else {//폴더가 없는 경우
				polderMap.put(pfc[0], new ArrayList());
				polderMap.get(pfc[0]).add(new Item(pfc[1], isFile));
			}
			
		}
		
//		System.out.println(Arrays.toString(polderMap.get("main").toArray()));
		
		query = Integer.valueOf(br.readLine());
		
		for(int i = 0; i<query; i++) {
			String[] q = br.readLine().split("/");
			String checkFolder = q[q.length-1];
			fileMap.clear();
			dfs(checkFolder);
			
			int size = 0;
			int cnt = 0;
			if(fileMap.keySet().size() == 0) {
				System.out.println(size + " " + cnt);
				continue;
			}
			for(String name : fileMap.keySet()) {
				size++;
				cnt += fileMap.get(name);
			}
			System.out.println(size + " " + cnt);
//			System.out.println(fileMap.entrySet());
		}
		
	}
	
	static void dfs(String checkFolder) {
		ArrayList<Item> items = polderMap.get(checkFolder);
		if(items == null) return;
		for(Item item : items) {
			if(item.isFile == 0) {//폴더일 경우
				dfs(item.name);
			}else { //파일일 경우
				if(!fileMap.containsKey(item.name)) {//없는 파일이면
					fileMap.put(item.name, 1);
				}else {
					fileMap.put(item.name, fileMap.get(item.name)+1);
				}
			}
			
		}
		
	}

}
