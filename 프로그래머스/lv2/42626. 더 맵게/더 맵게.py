import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        min_1 = heapq.heappop(scoville)
        min_2 = heapq.heappop(scoville)
        push = min_1 + (min_2*2)
        heapq.heappush(scoville, push)
        answer += 1
    

    return answer