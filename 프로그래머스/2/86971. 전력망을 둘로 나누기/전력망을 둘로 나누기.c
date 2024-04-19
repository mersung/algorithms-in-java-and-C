#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int m = 0;
int answer = 100;
// bool visited[];

int dfs(int current, int** wires, size_t wires_rows, size_t wires_cols, bool** graph, int cnt, bool* visited){
    printf("%d \n", m);
    visited[current] = true;
    if(cnt == m) return cnt;
    for(int i = 1; i<m+1; i++){
        if(graph[current][i] == true && visited[i] == false){
            visited[i] = true;
            // cnt = dfs(i, wires, wires_rows, wires_cols, graph, cnt+1);
        }
    }
    return cnt;
}

// wires_rows는 2차원 배열 wires의 행 길이, wires_cols는 2차원 배열 wires의 열 길이입니다.
int solution(int n, int** wires, size_t wires_rows, size_t wires_cols) {
    bool graph[n+1][n+1];

    m = n;
    for(int i = 0; i<wires_rows; i++){
        int* row = wires[i];
        int left = row[0];
        int right = row[1];
        graph[left][right] = true;
        graph[right][left] = true;
    }
    
    for(int i = 0; i<wires_rows; i++){
        int* row = wires[i];
        int left = row[0];
        int right = row[1];
        bool visited[n+1];
        //좌,우 하나씩 끊고 dfs해서 각 연결된 송전탑 수 출력
        graph[left][right] = false;
        graph[right][left] = false;
        int l = dfs(left, wires, wires_rows, wires_cols, graph, 0, visited);
        int r = dfs(right, wires, wires_rows, wires_cols, graph, 0, visted);
        graph[left][right] = true;
        graph[right][left] = true;
        free(visited);
        int ans;
        if(l>r){
            ans = l-r;
        }else{
            ans = r-l;
        }
        if(ans < answer) answer = ans;
    }
    return answer;
}