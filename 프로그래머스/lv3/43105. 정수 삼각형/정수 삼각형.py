def bfs(triangle):
    global answer
    q = deque()
    q.append([0,0,triangle[0][0]])
    
    while q:
        x,y,cnt = q.popleft()
        if x == len(triangle)-1:
            answer = max(answer, cnt)
            continue
        if x < len(triangle)-1:
            q.append([x+1, y, cnt+triangle[x+1][y]])
            q.append([x+1, y+1, cnt+triangle[x+1][y+1]])
        
def solution(triangle):
    # bfs(triangle)
    answer = 0
    dp = []
    for i in range(len(triangle)):
        dp.append([0 for _ in range(len(triangle[i]))])
    dp[0][0] = triangle[0][0]
    
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if j == 0 : 
                dp[i][j] = triangle[i][j] + dp[i-1][j]
            elif j == len(triangle[i])-1 : 
                dp[i][j] = triangle[i][j] + dp[i-1][j-1]
            else :
                dp[i][j] = max(dp[i][j], dp[i-1][j] + triangle[i][j])
                dp[i][j] = max(dp[i][j], dp[i-1][j-1] + triangle[i][j])
    answer = max(dp[len(triangle)-1])
    return answer