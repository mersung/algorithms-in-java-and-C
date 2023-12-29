package first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//세계적인 호텔인 형택 호텔의 사장인 김형택은 이번에 수입을 조금 늘리기 위해서 홍보를 하려고 한다.
//
//형택이가 홍보를 할 수 있는 도시가 주어지고, 각 도시별로 홍보하는데 드는 비용과, 그 때 몇 명의 호텔 고객이 늘어나는지에 대한 정보가 있다.
//
//예를 들어, “어떤 도시에서 9원을 들여서 홍보하면 3명의 고객이 늘어난다.”와 같은 정보이다. 이때, 이러한 정보에 나타난 돈에 정수배 만큼을 투자할 수 있다. 
//즉, 9원을 들여서 3명의 고객, 18원을 들여서 6명의 고객, 27원을 들여서 9명의 고객을 늘어나게 할 수 있지만, 3원을 들여서 홍보해서 1명의 고객, 12원을 들여서 4명의 고객을 늘어나게 할 수는 없다.
//
//각 도시에는 무한 명의 잠재적인 고객이 있다. 이때, 호텔의 고객을 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 C와 형택이가 홍보할 수 있는 도시의 개수 N이 주어진다. C는 1,000보다 작거나 같은 자연수이고, N은 20보다 작거나 같은 자연수이다. 
//둘째 줄부터 N개의 줄에는 각 도시에서 홍보할 때 대는 비용과 그 비용으로 얻을 수 있는 고객의 수가 주어진다. 이 값은 100보다 작거나 같은 자연수이다.

public class Practice1106 {
	
	static int c; // C명 늘이기 위해 투자해야하는 최솟값 구하기
	
	static int n; // 도시 개수
	
	static ArrayList<Integer[]> promotion = new ArrayList<>(); //각 도시마다, 비용과 얻을 수 있는 고객의 수가 주어진다.
	
	static int[] minCustomer; // 각 명 수 마다 투자해야하는 최솟값 배열
	
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] cn = br.readLine().split(" ");
		
		c = Integer.valueOf(cn[0]);
		n = Integer.valueOf(cn[1]);
		
		minCustomer = new int[c+1];
		Arrays.fill(minCustomer, Integer.MAX_VALUE);
		minCustomer[0] = 0;
		
		for(int i = 0; i<n; i++) {
			String[] city = br.readLine().split(" ");
			promotion.add(new Integer[] {Integer.valueOf(city[0]), Integer.valueOf(city[1])});
		}
		
		for(int i = 0; i<c+1; i++) {
			//각 명 수 마다 투자해야하는 최솟값 
			for(Integer[] prom : promotion) {
				int expense = prom[0]; //더 드는 비용
				int customer = prom[1]; //더 얻는 고객
				
				if((i != 0 && minCustomer[i] == Integer.MAX_VALUE)) continue; // 0명이 아닌데도 비용이 안 들고 있다면, 불가능한 것, c를 넘기면 안 됨
				
				
				
				int canGetCustomer = i+customer; // 비용 쓰면 얻는 고객
				int needExpense = minCustomer[i]+expense; // 써야하는 비용
				
				if(i+customer >= c) {
					answer = Math.min(answer, needExpense);
					continue;
				}
				
				if(minCustomer[canGetCustomer] > needExpense) { //드는 비용이 더 작다면 교체
					minCustomer[canGetCustomer] = needExpense;
				}
			}
		}
		
		System.out.println(answer);
	}

}
