# 일부가 플레이 된 지뢰찾기 게임의 정보를 읽어 해당하는 격자 출력
# n*n 격자판: m개의 지뢰
# 지뢰가 없는 지점을 건드리면 인접한 8개 칸에 지뢰가 몇 개인지 알려준다(0~8).

def solution(n, mines, board):
    dx = [0, 0, -1, 1, -1, -1, 1, 1] # L, R, U, D, d1, d2, d3, d4
    dy = [-1, 1, 0, 0, -1, 1, -1, 1]
    flag = False

    for x in range(n):
        for y in range(n):
            if board[x][y] == 'x':
                if mines[x][y] == '*':
                    flag = True

                count = 0
                for i in range(8):
                    nx = x + dx[i]
                    ny = y + dy[i]

                    if 0 <= nx < n and 0 <= ny < n and mines[nx][ny] == '*':
                        count += 1
                
                board[x][y] = str(count)

    if flag: # 지뢰를 연 경우 모든 지뢰 표시
        for x in range(n):
            for y in range(n):
                if mines[x][y] == '*':
                    board[x][y] = '*'
    
    return board

def main():
    n = int(input())
    mines = [list(input()) for _ in range(n)] # 지뢰의 위치
    board = [list(input()) for _ in range(n)] # 열린 칸 x, 열리지 않은 칸 .

    answer = solution(n, mines, board)

    for i in answer:
        print(''.join(i))

if __name__ == "__main__":
    main()