n = int(input())
boom = [list(input()) for _ in range(n)]
board = [list(input()) for _ in range(n)]
result = [["."] * n for _ in range(n)]
flag=False
dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, -1, 1, 1]

for i in range(n):
    for j in range(n):
        if board[i][j] == 'x' and boom[i][j]=='.':
            cnt = 0
            for k in range(8):
                nx = i + dx[k]
                ny = j + dy[k]
                if 0 <= nx < n and 0 <= ny < n:
                    if boom[nx][ny] == "*":
                        cnt += 1
            result[i][j] = cnt
        if board[i][j] == 'x' and boom[i][j] == '*':
            flag = True

if flag:
    for i in range(n):
        for j in range(n):
            if boom[i][j] == '*':
                result[i][j] = '*'

for i in range(n):
    for j in range(n):
        print(result[i][j],end="")
    print()