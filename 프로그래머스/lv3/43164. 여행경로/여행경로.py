from copy import deepcopy
def backtracking(start, end, visited, ans, tickets, answer):   
    if False not in visited:
        # print(answer," : ", ans)
        answer.append(deepcopy(ans))
        return
    for i in range(len(tickets)):
        if visited[i] == False and end == tickets[i][0]:
            visited[i] = True
            ans.append(tickets[i][1])
            backtracking(end, tickets[i][1], visited, ans, tickets, answer)
            ans.pop()
            visited[i] = False
            

def solution(tickets):
    visited = [False for _ in range(len(tickets))]
    answer = []
    for i in range(len(tickets)):
        if tickets[i][0] == "ICN":
            visited[i] = True
            backtracking("ICN", tickets[i][1], visited, ["ICN", tickets[i][1]], tickets, answer)
            visited[i] = False
    answer.sort()
    return answer[0]
            