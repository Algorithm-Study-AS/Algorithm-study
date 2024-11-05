#제한
#시간: 1초, 메모리: 1024000

#문제
#용사는 (1,1)에서부터 공주(N,M)를 찾아야하며, T시간 안에 도달해야 한다.
#상하좌우로 한칸씩 움직일 수 있다.
#전설의 검을 찾으면 벽을 부수고 공간으로 이동할 수 있다.

#입력
#성 크기 N,M, 제한시간 T (3 <= N,M <= 100, 1 <= T <= 10000)
#0은 빈 공간, 1은 마법의 벽, 2는 전설의 검

#출력
#T 시간 내에 도달할 수 있다면 최단 시간을, 못하면 Fail 출력

#풀이
# (0,0)에서 탐색 시작, 이동할 수 있는 구간을 최소값으로 업로드, 
# 2를 만나면 그 점에서 목적지까지 최소거리

from collections import deque

def calculateDistance(array, N, M):
    result = [[100001]*M for _ in range(N)]
    
    que = deque([(0,0)])
    result[0][0] = 0
    sword_distance = 100001


    while que:
        x,y = que.popleft()

        if (x,y) == (N-1,M-1):
            return min(sword_distance,result[N-1][M-1])

        for dx, dy in [(1,0),(-1,0),(0,1),(0,-1)]:
            nx, ny = x+dx, y+dy
            
            if N > nx >= 0 and M > ny >=0 and array[nx][ny] != 1 and result[nx][ny]==100001:
                result[nx][ny] = result[x][y] + 1
                que.append((nx,ny))

                if array[nx][ny] == 2:
                    sword_distance = result[nx][ny] + (N-1-nx) + (M-1-ny)
    
    return min(sword_distance,result[N-1][M-1])

if __name__ == "__main__":
    N, M, T = map(int,input().split())
    array = []

    for _ in range(N):
        array.append(list(map(int,input().split())))
    
    result = calculateDistance(array, N, M)
    
    if result > T:
        print("Fail")
    else:
        print(result)
    