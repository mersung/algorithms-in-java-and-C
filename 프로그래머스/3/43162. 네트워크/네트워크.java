import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(visited[i] == true) continue;
            answer += 1;
            dfs(i, computers, n);
        }
        return answer;
    }
    
    static void dfs(int index, int[][] computers, int n){
        
        for(int i = 0; i<n; i++){
            if(computers[index][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(i, computers, n);
            }
        }
    }
}