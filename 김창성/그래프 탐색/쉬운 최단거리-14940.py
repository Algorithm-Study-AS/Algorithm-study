#제한
# 시간:1초, 메모리: 512000 

#문제
#모든 지점에 대해서 목표지점까지의 거리 구하기

#입력
# n * m (2 <= n <= 1000, 2 <= m <= 1000) 
# 0은 이동 불가, 1은 이동 가능, 2는 목표지점

#출력
# 각 지점에서의 목표지점까지의 거리 출력
# 이동 가능한 구역 중 도달할 수 없는 위치는 -1, 
# 원래 갈 수 없는 위치는 0 출력

#풀이
# 2를 찾고 멀어지면서 1탐색
# 1인 구역은 거리로 초기화

from collections import deque

def findGoalPoint(array,N,M):
    for i in range(N):
        for j in range(M):
            if array[i][j] == 2:
                return (i,j)
    
def calculateDistance(a,b,array,N,M):
    result = [[0] * M for _ in range(N)]

    que = deque([(a,b)])
    visited = [[False]*M for _ in range(N)]
    visited[a][b] = True
    
    while que:
        x, y = que.popleft()

        for dx, dy in [(1,0),(0,1),(-1,0),(0,-1)]:
            nx, ny = x+dx, y+dy

            if N > nx >= 0 and M > ny >= 0 and array[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                result[nx][ny] = result[x][y] + 1
                que.append((nx,ny))

    for i in range(N):
        for j in range(M):
            if visited[i][j] == False and array[i][j] == 1:
                result[i][j] = -1

    return result

if __name__ == "__main__":
    N , M = map(int,input().split())
    array = []

    for _ in range(N):
        array.append(list(map(int,input().split())))

    a, b = findGoalPoint(array,N,M)

    result = calculateDistance(a,b,array,N,M)

    for i in range(N):
        print(" ".join(map(str, result[i])))