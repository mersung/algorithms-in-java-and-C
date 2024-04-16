#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// cards1_len은 배열 cards1의 길이입니다.
// cards2_len은 배열 cards2의 길이입니다.
// goal_len은 배열 goal의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* cards1[], size_t cards1_len, const char* cards2[], size_t cards2_len, const char* goal[], size_t goal_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(sizeof(char)*3);
    // int* visitedCards1 = (int*)malloc(sizeof(int)*cards1_len);
    // int* visitedCards2 = (int*)malloc(sizeof(int)*cards2_len);

    // int* visitedGoal = (int*)malloc(sizeof(int)*goal_len);
    
    int index1 = 0;
    int index2 = 0;
    int perfect = 1;
    for(int i = 0; i<goal_len; i++){
        char* word = goal[i];

        if(index1 < cards1_len && strcmp(word, cards1[index1]) == 0){//참
            index1++;
            continue;
        }
        if(index2 < cards2_len && strcmp(word, cards2[index2]) == 0){
            index2++;
        }else{
            perfect = 0;
            break;
        }
    }
    if(perfect == 0) answer = "No";
    else{
        answer = "Yes";
    }
    return answer;
}