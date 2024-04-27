#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
int row;
int col;

int compare(int* a, int* b){
    return *a>*b?1:-1;
}

int dfs(int x, int y, char** maps, bool** visited, int cnt){
    visited[x][y] = true;
    for(int i = 0; i<4; i++){
        int nx = x+dx[i];
        int ny = y+dy[i];
        if(nx >= 0 && nx < row && ny >= 0 && ny < col && visited[nx][ny] == false && maps[nx][ny] != 'X'){
            cnt += (maps[nx][ny] - '0');
            cnt = dfs(nx, ny, maps, visited, cnt);
        }
    }
    return cnt;
}

// maps_len은 배열 maps의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* maps[], size_t maps_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc(sizeof(int)*10000);
    for(int i = 0; i<10000; i++){
        answer[i] = 0;
    }
    bool** visited = (bool**)malloc(sizeof(bool*)*maps_len);
    for(int i = 0; i<maps_len; i++){
        visited[i] = (bool*)malloc(sizeof(bool)*strlen(maps[0])); 
        for(int j = 0; j<strlen(maps[0]); j++){
            visited[i][j] = false;
        }
    }

    row = maps_len;
    col = strlen(maps[0]);
    
    int cnt = 0;
    
    for(int i = 0; i<row; i++){
        for(int j = 0; j<col; j++){
            if(visited[i][j] == false && maps[i][j] != 'X'){
                answer[cnt++] = dfs(i,j, maps, visited, maps[i][j] - '0');
            }
        }
    }
    int* answer2 = (int*)malloc(sizeof(int)*cnt);
    for(int i = 0; i< cnt; i++){
        answer2[i] = 0;
        answer2[i] = answer[i];
    }
    qsort(answer2, cnt, sizeof(int), compare);
    if(cnt == 0){
        answer2 = (int*)malloc(sizeof(int)*1);
        answer2[0] = -1;
    }
    return answer2;
}