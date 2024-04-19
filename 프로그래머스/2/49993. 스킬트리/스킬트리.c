#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

bool check(bool* visited, int k){
    bool ans = true;
    for(int i = 0; i<k; i++){
        if(visited[i] == false){
            return false;
        }
    }
    return ans;
}

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
// skill_trees_len은 배열 skill_trees의 길이입니다.
int solution(const char* skill, const char* skill_trees[], size_t skill_trees_len) {
    int answer = 0;
    
    for(int i = 0; i<skill_trees_len; i++){
        char* skillTree = skill_trees[i];
        
        int skillLen = strlen(skill);
        bool* visited = (bool*)malloc(sizeof(bool)*skillLen);
        for(int j = 0; j<skillLen; j++){
            visited[j] = false;
        }
        bool flag = true;
        
        for(int j = 0; j<strlen(skillTree); j++){
            
            for(int k = 0; k<skillLen; k++){ //스킬 순서랑 비교
                
                if(skillTree[j] == skill[k]){
                    printf("%c : %c, %d : %d \n", skillTree[j], skill[k], j, k);
                    bool c = check(visited, k); //이 전 스킬들 배웠는지 확인
                    if(c == false){
                        flag = false;
                        break;
                    }else{
                        visited[k] = true;
                    }
                }
            }
            if(flag == false) break;
        }
        if(flag == true){
           answer += 1; 
           printf("%s", skillTree);
        } 
        printf("\n");
    }
    return answer;
}