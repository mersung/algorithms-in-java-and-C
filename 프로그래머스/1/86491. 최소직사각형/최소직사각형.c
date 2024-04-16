#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// sizes_rows는 2차원 배열 sizes의 행 길이, sizes_cols는 2차원 배열 sizes의 열 길이입니다.
int solution(int** sizes, size_t sizes_rows, size_t sizes_cols) {
    int answer = 0;
    int a = 0;
    int b = 0;
    //일단 가장 긴것을 a에 놓고, 하나씩 돌면서 left, right확인하여 둘 중 낮은걸 b에 넣는다.(b랑비교해서, )
    for(int i = 0; i<sizes_rows; i++){
        int* row = sizes[i];
        int left = row[0];
        int right = row[1];
        //a에 가장 큰거 할당
        if(a < left) a = left;
        if(a < right) a = right;
        //b확인
        if(left > right){
            if(right > b) b = right;
        }else{
            if(left > b) b = left;
        }
    }
    answer = a*b;
    return answer;
}