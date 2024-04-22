#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// keymap_len은 배열 keymap의 길이입니다.
// targets_len은 배열 targets의 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int* solution(const char* keymap[], size_t keymap_len, const char* targets[], size_t targets_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int alphabet[26];
    for(int i = 0; i<26; i++){
        alphabet[i] = 101;
    }
    int* answer = (int*)malloc(sizeof(int)*targets_len);
    
    for(int i = 0; i<keymap_len; i++){
        char* key = keymap[i];
        for(int j = 0; j<strlen(key); j++){
            char c = key[j];
            
            if(alphabet[c - 'A'] > j+1){
                // printf("%c : %d ", c, c-'A');
                alphabet[c - 'A'] = j+1;
            }
        }
    }
    
    for(int i = 0; i<targets_len; i++){
        char* target = targets[i];
        int ans = 0;
        bool flag = true;
        for(int j = 0; j<strlen(target); j++){
            char c = target[j];
            if(alphabet[c - 'A'] != 101){
                ans += alphabet[c - 'A'];
            }else{
                
                flag = false;
                break;
            }
        }
        if(flag == false){
            answer[i] = -1;
            continue;
        }
        answer[i] = ans;
    }
    
    return answer;
}