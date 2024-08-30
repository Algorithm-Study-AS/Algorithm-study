# 보관 후 하루가 지나면 익은 토마토에 인접한 익지 않은 토마토는 익는다.
# 인접한 곳: 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
# 토마토가 다 익는데 걸리는 최소 일수

from collections import deque

def bfs(m, n, h, tomatoes):

    dz = [-1, 1, 0, 0, 0, 0]
    dx = [0, 0, -1, 1, 0, 0]
    dy = [0, 0, 0, 0, -1, 1]

    queue = deque()
    
    for z in range(h):
        for x in range(n):
            for y in range(m):
                if tomatoes[z][x][y] == 1: # 익은 토마토
                    queue.append((z, x, y))

    while queue:
        z, x, y = queue.popleft()

        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nz < h and 0 <= nx < n and 0 <= ny < m:
                if tomatoes[nz][nx][ny] == 0: # 익지 않은 토마토일 경우
                    tomatoes[nz][nx][ny] = tomatoes[z][x][y] + 1 # 날짜를 증가시켜 기록
                    queue.append((nz, nx, ny))

    # 토마토가 모두 익었는지 확인
    max_days = 0
    for z in range(h):
        for x in range(n):
            for y in range(m):
                if tomatoes[z][x][y] == 0: # 익지 않은 토마토가 남아있다면
                    return -1
                max_days = max(max_days, tomatoes[z][x][y])

    # 초기 익은 상태를 1로 했기 때문에 결과에서 1을 빼줌
    return max_days - 1
        
def main():
    m, n, h = map(int, input().split())
    tomatoes = []
    
    for _ in range(h):
        temp = []
        for _ in range(n):
            temp.append(list(map(int, input().split())))
        tomatoes.append(temp)
    
    print(bfs(m, n, h, tomatoes))

if __name__ == "__main__":
    main()