#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* s) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(strlen(s)); // 짝수번째 +1 은 NULL 문자 까지 
    
    strcpy(answer, s);  //strcpy () 함수를 이용해서 s의 값을 answer 의 복사해줌
    
    bool isodd = true; //bool type 을 선언하여 짝수인덱스인지를 판별
    
    for(int i = 0; i <strlen(s); i++)
    {
        if(answer[i] == ' ')  { //answer[i] 의 띄어쓰기 가 들어온다면 if 실행
            isodd = true;
            continue; // continue 를 사용하여 탈출
        }
        if(isodd) // bool type isodd 가 참 이라면 
            answer[i] = toupper(answer[i]);
        else
            answer[i] = tolower(answer[i]);
        
        isodd = !isodd;
        }
    return answer;
}