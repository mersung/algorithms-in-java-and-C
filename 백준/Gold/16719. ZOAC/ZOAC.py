import sys
input = sys.stdin.readline

str = list(input().rstrip())
result = ['']*len(str)

def pop(arr, start):
    if not arr:
        return
    min_arr = min(arr)
    idx = arr.index(min_arr)
    result[start+idx] = min_arr
    print(''.join(result))
    pop(arr[idx+1:], start+idx+1)
    pop(arr[:idx], start)

pop(str, 0)