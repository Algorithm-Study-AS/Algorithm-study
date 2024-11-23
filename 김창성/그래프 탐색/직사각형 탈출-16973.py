#제한
# 시간 2초, 메모리 2048

#문제
# NxM격자판에 HxW인 직사각형이 놓여져 있다.
# 직사각형 위쪽 칸을 이동시키기 위한 최소 이동 횟수를 구해라
# 격차판의 각 칸은 빈칸 또는 벽이 있다
# 한 번에 왼, 오, 위, 아래 중 한 방향으로 한 칸 이동시킬 수 있다.

#입력
# 격자판의 크기 N, M 
# 격자판 정보 빈칸:0, 벽:1
# 직사각형 크기 H, W 시작 Sr, Sc 도착 Fr, Fc

#출력
# 최소 이동횟수, 이동할 수 없는 경우에는 -1

#풀이
# dfs로 최소값 갱신하며 탐색 
# 도착에 도달하면 끝
from collections import deque

def find_wall_location(array,N,M):
    location = []
    for i in range(N):
        for j in range(M):
            if array[i][j] == 1:
                location.append((i,j))
    return location

def check_wall(wall, nx, ny):
    global square_hight, square_width
    
    for (i,j) in wall:
        if nx <= i < nx+square_hight and ny <= j < ny+square_width:
            return False
    return True

def bfs(array, x, y , N, M):
    global square_hight, square_width, square_end_x, square_end_y
    que = deque([(x,y)])
    visited = [[False] * M for _ in range(N)]
    count_map = [[0] * M for _ in range(N)]

    visited[x][y] = True
    wall = find_wall_location(array,N,M)

    while que:
        x, y = que.popleft()

        if (x == square_end_x and y == square_end_y):
            return count_map[x][y]

        for dx, dy in [(1,0),(-1,0),(0,1),(0,-1)]:
            nx, ny = x + dx, y + dy

            if(0 <= nx < N - square_hight + 1 and 0 <= ny < M - square_width + 1 and check_wall(wall, nx, ny) and visited[nx][ny] == False):
                visited[nx][ny] = True
                count_map[nx][ny] = count_map[x][y] + 1
                que.append((nx,ny))

    return -1
                

if __name__ == "__main__":
    global square_hight, square_width, square_end_x, square_end_y
    N, M = map(int,input().split())
    array = []

    for _ in range(N):
        array.append(list(map(int,input().split())))
    
    square_hight, square_width, square_start_x, square_start_y, square_end_x, square_end_y = map(int, input().split()) 
    square_start_x -= 1 
    square_start_y -= 1 
    square_end_x -= 1 
    square_end_y -= 1

    print(bfs(array, square_start_x, square_start_y, N, M))
