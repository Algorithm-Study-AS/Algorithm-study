#시간 1초, 메모리 128,000,000

#문제
# 미로 위쪽에서 아래쪽으로 침투할 수 있는지 판단

#입력
# 2 <= M,N <= 1000
# 0(전류O),1(전류X)로 이루어진 미로

#출력
# 전류가 아래로 전달되면 YES, 안되면 NO

#풀이
# DSF로 탐색하여 마지막 행에 도달하면 YES 출력

from collections import deque

def dsf(array, M, N):
    que = deque()

    for i in range(N):
        if array[0][i] == 0:
            que.append((0,i))
    
    while que:
        x, y = que.popleft()

        for dx, dy in [(0,-1),(0,1),(1,0)]:
            nx, ny = x + dx, y + dy

            if 0 <= nx < M and 0 <= ny < N and array[nx][ny] == 0:
                array[nx][ny] = 2
                que.appendleft((nx,ny))

            if nx == M-1:
                return "YES"
    
    return "NO"


if __name__ == "__main__":
    M, N = map(int,input().split())
    
    array = []
    for _ in range(M):
        array.append(list(map(int,list(input()))))

    print(dsf(array, M, N))