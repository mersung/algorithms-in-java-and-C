class Solution {
    
    boolean[][] graph;
    
    public int solution(int n, int[][] wires) {
        
        int answer = 999999;
        graph = new boolean[n+1][n+1];
        for(int[] wire : wires){
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        // 1부터 9까지 돌기
        for(int i = 1; i<=n; i++){
            //끊을 상대
            for(int j = 1; j<=n; j++){
                if(graph[i][j] == true){
                    boolean[] visited = new boolean[n+1];
                   //전력망 서로 끊기
                    graph[i][j] = false;
                    graph[j][i] = false;
                    int sum = 1;
                    int a = dfs(visited, i, sum);
                    System.out.println("차이"+a+"a");
                    int b = dfs(visited, j, sum);
                    System.out.println("차이"+b+"b");
                    int ab = Math.abs(a-b);
                    answer = Math.min(answer, ab); 
                    graph[i][j] = true;
                    graph[j][i] = true;
                }                  
            }
        }
        return answer;
    }
    public int dfs(boolean[] visited, int x, int sum){
        visited[x] = true;
        // 연결 확인
        for(int i = 1; i<visited.length; i++){
            if(visited[i] == false && graph[x][i] == true){
                sum += 1;
                System.out.println("x, sum" + x + "," + sum);
                sum = dfs(visited, i, sum);
            }
        }
        return sum;
    }
}