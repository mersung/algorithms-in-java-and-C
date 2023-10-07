from collections import deque
answer = float('inf')

def bfs(maps):
    n = len(maps)
    m = len(maps[0])
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    global answer
    q = deque()
    q.append([0,0,1])
    visited = [[False for _ in range(m)] for _ in range(n)]
    visited[0][0] = True
    while q:
        x,y,cnt = q.popleft()
        if x == n-1 and y == m-1 : 
            answer = min(answer,cnt)
            return
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if not (0<=nx<n and 0<=ny<m): continue
            if visited[nx][ny] == False and maps[nx][ny] == 1:
                visited[nx][ny] = True
                q.append([nx,ny,cnt+1])
                
def solution(maps):
    bfs(maps)
    if answer == float('inf'):
        return -1
    return answer