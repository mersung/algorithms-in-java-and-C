package Backtracking;

import java.io.*;
import java.util.*;
public class Practice1062 {
    static int n;
    static int k;
    static boolean[] learned;
    static String[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.valueOf(input[0]);
        k = Integer.valueOf(input[1]);

        learned = new boolean[26];
        arr = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }
        k-=5;
        /* 무조건 배워야하는 단어 */
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        for (int i = 0; i < n; i++) {
            String str = br.readLine().replace("anta|tica", "");

            arr[i] = str;
        }

        backtracking(1, 0);
        System.out.println(answer);
    }

    static void backtracking(int index, int depth) {
    	if (depth == k) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;

                for (int j = 0; j < arr[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!learned[arr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(temp, answer);
            return;
        }
		
    	for (int i = index; i < 26; i++) {
            if (!learned[i]) {
            	learned[i] = true;
                backtracking(i+1, depth + 1);
                learned[i] = false;
            }
        }
	}
	
}
