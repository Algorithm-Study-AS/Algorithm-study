#제한
# 2초, 메모리 512000

#문제
# 쩰리가 왼쪽상단 -> 오른쪽하단 도달 가능한지 확인
# 판에 숫자만큼 움직일 수 있고, 오른쪽 혹은 아래쪽으로 움직일 수 있음

#입력
# 2 <= N(게임구역의 크기) <= 64

#출력
# 도달할 수 있으면 HaruHaru, 못하면 Hing

#풀이
# 오른쪽 or 아래쪽 bfs탐색
from collections import deque

def bfs(N,board):
    que = deque([(0,0)])
    visited = [[False] * N for _ in range(N)] 
    
    while que:
        x,y = que.popleft()
        move = board[x][y]
        
        for dx,dy in [(0,1),(1,0)]:
            nx, ny = dx*move + x, dy*move + y

            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny]==False:
                que.append((nx,ny))
                visited[nx][ny]=True             

    if visited[N-1][N-1] == False:
        return "Hing"
    else:
        return "HaruHaru"


if __name__ == "__main__":
    N = int(input())
    board = []

    for _ in range(N):
        board.append(list(map(int,input().split())))

    print(bfs(N,board))