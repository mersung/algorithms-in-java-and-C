#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void reverseSort(int B[], int length);
void sort(int A[], int length);
// A_len은 배열 A의 길이입니다.
// B_len은 배열 B의 길이입니다.
int compare(int *a, int *b){
    return *a > *b ? 1:-1;
}

int solution(int A[], size_t A_len, int B[], size_t B_len) {
    int answer = 0;
    
    // sort(A, A_len);
    // reverseSort(B, B_len);
    qsort(A, A_len, sizeof(int), compare);
    qsort(B, B_len, sizeof(int), compare);
    
    for(int i = 0; i<A_len; i++){
        answer += (A[i] * B[A_len - i -1]);
    }
    
    return answer;
}

void sort(int A[], int length){
    int min = A[0];
    for(int i = 0; i<length-1; i++){
        for(int j = i+1; j<length; j++){
            if(A[i] > A[j]){
                min = A[j];
                A[j] = A[i];
                A[i] = min;
            }
        }
    }
}

void reverseSort(int B[], int length){
    int max = B[0];
    for(int i = 0; i<length-1; i++){
        for(int j = i+1; j<length; j++){
            if(B[i] < B[j]){
                max = B[j];
                B[j] = B[i];
                B[i] = max;
            }
        }
    }
}