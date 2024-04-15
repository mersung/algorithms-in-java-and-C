#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
int compare(const int *a, const int *b){
    return *a>*b?1:-1;
}
// food_len은 배열 food의 길이입니다.
char* solution(int food[], size_t food_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(sizeof(char)*9001);
    // qsort(food, food_len, sizeof(int), compare);
    //왼쪽 채우기
    int cnt = 0;
    for(int i = 1; i<food_len; i++){
        int c = food[i]/2;
        for(int j = 0; j<c; j++){
            answer[cnt++] = i + '0';
        }
    }
    answer[cnt++] = '0';
    
    for(int i = food_len-1; i>0; i--){
        int c = food[i]/2;
        for(int j =0; j<c; j++){
            answer[cnt++] = i+'0';
        }
    }
    return answer;
}