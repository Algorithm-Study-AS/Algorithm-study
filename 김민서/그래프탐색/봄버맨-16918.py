# r*c 직사각형 격자판 -> 각 칸은 비어있거나 폭탄이 있다.
# 폭탄이 있는 칸은 3초 후에 폭발하고, 해당 칸과 인접한 네 칸이 함께 빈 칸이 된다.
# 인접한 칸에 있는 폭탄은 폭발없이 파괴된다. (연쇄 반응 x)

def solution(board):
    global r, c

    updated_board = [['O' for _ in range(c)] for _ in range(r)]

    for i in range(r):
            for j in range(c):
                if board[i][j] == 'O':
                    for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1), (i, j)]:
                        if 0 <= x < r and 0 <= y < c:
                            updated_board[x][y] = '.'
    return updated_board

def main():
    global r, c
    
    r, c, n = map(int, input().split())
    board = []

    for _ in range(r):
        board.append(list(input()))

    if n <= 1:
        answer = board
    elif n % 2 == 0: # 짝수 초에는 전체가 폭탄이다.
        answer = [['O' for _ in range(c)] for _ in range(r)]
    elif n % 4 == 3:
        answer = solution(board)
    elif n % 4 == 1:
        answer = solution(solution(board))

    for i in answer:
        print(''.join(i))

if __name__ == "__main__":
    main()