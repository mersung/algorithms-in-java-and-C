package String;


import java.io.*;
import java.util.*;
public class Baekjoon3107 {

	static String[] receivedIP;
	static StringBuffer answer = new StringBuffer();
	static int maxLength = 39; // 32 + 7(콜론)
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String IP = br.readLine(); // 구분자가 존재하지 않고 문자가 없으면 공백으로라도 채워진 최소 길이 1이상의 문자열 배열 리턴
		IP = IP.replaceFirst("::", ":zero:"); // 불변 객체기 때문에 replaceFirst를 해주면 원래 값이 변경되는게 아니라, 새로운 객체를 생성해서 메모리 주소값을 IP에 할당해줘야 한다.

		receivedIP = IP.split(":");
		// 25:09:1985:aa:091:4846:: --> [25,09,1985,aa,091,4846, zero] 6 --> 연속된 0000 2개 필요
		// :25:09:1985:aa:091:: --> [ , 25, 09, 1985, aa, 091, zero] 6 --> 연속된 0000 2개 필요
		// 25:09::aa:091 --> [25, 09, zero , aa, 091] 5 --> 연속된 0000 3개 필요
		// :25:09:zero:aa: --> [ , 25, 09, zero , aa] 5 --> 연속된 0000 4개 필요
		// :zero:3 --> [, zero, 3]

		for(int i = 0; i<receivedIP.length; i++) {
			String s = receivedIP[i];
			//1. 앞에 0채우기, ::이 아닐 경우
			if(!s.equals("zero")) {
				if(i != 0) answer.append(":");
				int n = 4-s.length();
				for(int j = 0; j<n; j++) {
					answer.append("0");
				}
				answer.append(s);
			}else { // 2. ::면 부족한 인덱스만큼 0000추가
				int need = 9-receivedIP.length;
				for(int j = 0; j<need; j++) {
					answer.append(":0000");
				}
			}
			
		}
		System.out.println(answer);
	}

}
