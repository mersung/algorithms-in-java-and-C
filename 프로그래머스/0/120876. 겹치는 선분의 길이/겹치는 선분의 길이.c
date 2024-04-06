#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// lines_rows는 2차원 배열 lines의 행 길이, lines_cols는 2차원 배열 lines의 열 길이입니다.
int solution(int** lines, size_t lines_rows, size_t lines_cols) {
    int answer = 0;
    
    int count[201] = {0};
    
    
    int row = sizeof(lines) / sizeof(lines[0]);
    int col = sizeof(lines[0]) / sizeof(lines[0][0]);

    for(int i = 0; i<lines_rows; i++){
        int *r = lines[i];
        int left = r[0]+100;
        int right = r[1]+100;
        for(int j = left; j < right; j++){
            count[j] += 1;
        }
    }
    
    int countLength = sizeof(count) / sizeof(count[0]);
    for(int i = 0; i<countLength; i++){
        if(count[i] >= 2){
            answer += 1;
        }
    }
    
    return answer;
}