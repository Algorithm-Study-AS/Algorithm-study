#제한
#1초 메모리1024

#문제
# N개 샘터, K채의 집에 서로 다른 위치
# 불행도(장 가까운 샘터까지의 거리)의 합 최소

#입력
# 1 <= N, K <= 100,000
# -100,000,000 <= 위치 <= 100,000,000

#출력
# 불행도의 합의 최솟값

#풀이
# 샘물 위치 -1,+1 위치 비어있으면 더하기

from collections import deque

def locate_house(N, K, well):
    visited = set()
    que = deque()
    total_score = 0
    house_count = 0

    for well_location in well:
        que.append((well_location,0))
        visited.add(well_location)

    while que:
        x, score = que.popleft()
        
        for dx in [-1,1]:
            nx = x + dx

            if nx not in visited:
                #print("집 위치",nx)
                total_score += score + 1
                house_count += 1

                visited.add(nx)
                que.append((nx,score+1))

                #print("총: ",total_score)

                if house_count >= K:
                    return total_score 
    

if __name__ == "__main__":
    N, K = map(int,input().split())
    well = list(map(int,input().split()))

    print(locate_house(N, K, well))