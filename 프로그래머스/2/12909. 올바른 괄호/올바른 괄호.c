#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
bool solution(const char* s) {
    bool answer = true;
    int count = 0; // (괄호 개수
    for(int i = 0; s[i] != '\0'; i++){
        if(s[i] == '('){
            count += 1;
        }else{
            count -= 1;
            if(count < 0){
                return false;
            }
        }
    }
    if(count > 0) return false;
    return answer;
}