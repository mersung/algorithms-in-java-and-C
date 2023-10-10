import sys
sys.setrecursionlimit(10000000)

def find_room(visited, num):
    if num not in visited: #방문한 적 없음
        visited[num] = num+1 #다음 방 안내
        return num
    else:
        empty = find_room(visited, visited[num])
        visited[num] = empty + 1
        return empty

def solution(k, room_number):
    answer = []
    visited = dict()
    for room in room_number:
        answer.append(find_room(visited, room))
    return answer