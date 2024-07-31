# 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수
# n*n 게임판: 각 칸에 현재 칸에서 갈 수 있는 거리를 의미하는 수가 있다.
# 반드시 오른쪽이나 아래쪽으로 이동, 한 번 점프 시 방향 바꾸기 불가

def solution(n, board):
    d = [[0 for _ in range(n)] for _ in range(n)]
    d[0][0] = 1

    for i in range(n):
        for j in range(n):
            moves = board[i][j]

            if d[i][j] > 0 and moves > 0:
                if j + moves < n:
                    d[i][j+moves] += d[i][j]
                
                if i + moves < n:
                    d[i+moves][j] += d[i][j]

    return d[n-1][n-1]

def main():
    n = int(input())
    board = []

    for _ in range(n):
        board.append(list(map(int, input().split())))

    print(solution(n, board))

if __name__ == "__main__":
    main()