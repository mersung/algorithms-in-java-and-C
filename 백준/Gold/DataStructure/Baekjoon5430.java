package DataStructure;

//선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
//
//함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
//
//함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
//
//배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
//
//각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
//
//다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
//
//다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
//
//전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.
//
//출력
//각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.
//
//예제 입력 1 
//4
//RDD
//4
//[1,2,3,4]
//DD
//1
//[42]
//RRD
//6
//[1,1,2,3,5,8]
//D
//0
//[]
//예제 출력 1 
//[2,1]
//error
//[1,2,3,5,8]
//error

import java.io.*;
import java.util.*;
public class Practice5430 {
	
	static int t;
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.valueOf(br.readLine());
		for(int i = 0; i<t; i++) { // 최대 100
			String p = br.readLine(); // 수행할 함수, 최대 100,000
			boolean currentReverse = false; // 현재 뒤집은 상태인지
			boolean error = false;
			ArrayDeque<String> reverse = new ArrayDeque();
			//배열 수의 개수
			int n = Integer.valueOf(br.readLine());
			
			String arr = br.readLine(); // 최대 100,000
			String[] str = arr.substring(1, arr.length()-1).split(","); // 괄호 제거, 스트링은 불변 객체기 때문에, 바뀌면 새로 객체 생성 후 계속 메모리 할당
			 //스트링 버퍼 객체 생성, 메모리 할당, 가변 객체이므로 계속 메모리 할당 X
			
			for(int j = 0; j<n; j++) { // 10만
				reverse.add(str[j]);
			}
			
			for(char c : p.toCharArray()) {
				if(c == 'R') {
					currentReverse = !currentReverse;
				}else if(c == 'D') {
					if(reverse.size() < 1) {
						error = true;
						break;
					}
					if(currentReverse == false) { //거꾸로가 아닌 경우
						reverse.pollFirst();
					}else if(currentReverse == true) { // 거꾸로인 경우
						reverse.pollLast();
					}
					
				}
			}
				
			// 결과 출력
            if (error) {
                System.out.println("error");
            } else {
                StringBuilder result = new StringBuilder("[");
                if (!reverse.isEmpty()) {
                    if (currentReverse) {
                        // 뒤집힌 상태라면 덱의 마지막 요소부터 출력
                        result.append(reverse.pollLast());
                        while (!reverse.isEmpty()) {
                            result.append(",").append(reverse.pollLast());
                        }
                    } else {
                        // 아닌 경우에는 덱의 첫 번째 요소부터 출력
                        result.append(reverse.pollFirst());
                        while (!reverse.isEmpty()) {
                            result.append(",").append(reverse.pollFirst());
                        }
                    }
                }
                result.append("]");
                System.out.println(result);
            }
        
		}
	}

}
