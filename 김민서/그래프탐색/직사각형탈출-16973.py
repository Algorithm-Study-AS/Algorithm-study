# n*m 격자판에 h*w 직사각형이 놓여 있다.
# 벽이 있는 격자판(1)에는 직사각형이 있을 수 없다.
# 한 번에 상하좌우 한 칸씩만 이동 가능하다.
# 직사각형의 가장 왼쪽 위칸을 특정 좌표로 이동시키기 위한 최소 이동 횟수 

from collections import deque
import sys

def solution(n, m, board, h, w, sr, sc, fr, fc):
    visited = [[-1] * m for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q = deque([(sr-1, sc-1)])
    visited[sr-1][sc-1] = 0

    def can_move(x, y, direction):
        # 직사각형의 이동 경계 부분만 체크하여 최적화
        if direction == 0:
            for j in range(w):
                if x < 0 or board[x][y + j] == 1:
                    return False
        elif direction == 1:
            for j in range(w):
                if x + h > n or board[x + h - 1][y + j] == 1:
                    return False
        elif direction == 2:
            for i in range(h):
                if y < 0 or board[x + i][y] == 1:
                    return False
        elif direction == 3:
            for i in range(h):
                if y + w > m or board[x + i][y + w - 1] == 1:
                    return False
        return True

    while q:
        x, y = q.popleft()

        if (x, y) == (fr-1, fc-1):
            return visited[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == -1:
                if can_move(nx, ny, i):
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))
        
    return -1


def main():
    n, m = map(int, sys.stdin.readline().split())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    h, w, sr, sc, fr, fc = map(int, sys.stdin.readline().split())

    print(solution(n, m, board, h, w, sr, sc, fr, fc))


if __name__ == "__main__":
    main()