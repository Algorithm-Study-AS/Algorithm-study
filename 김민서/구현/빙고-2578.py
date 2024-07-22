# 사회자가 몇 번째 수를 부른 후 빙고가 되는지 출력

def solution(board_dict, numbers):
    bingo = 0
    rows = [0] * 5
    cols = [0] * 5
    diag1 = 0
    diag2 = 0

    for n in range(len(numbers)):
        i, j = board_dict[numbers[n]]
        
        rows[i] += 1
        cols[j] += 1

        if i == j:
            diag1 += 1
        if i + j == 4:
            diag2 += 1

        # 각 칸이 처음으로 빙고를 이루는지 확인
        if rows[i] == 5:
            bingo += 1
            rows[i] = -1 # 이미 확인한 줄이 다시 카운트되지 않도록 임의로 값을 수정한다.
        if cols[j] == 5:
            bingo += 1
            cols[j] = -1
        if diag1 == 5 and i == j:
            bingo += 1
            diag1 = -1
        if diag2 == 5 and i + j == 4:
            bingo += 1
            diag2 = -1 

        if bingo >= 3:
            return n + 1

board = [list(map(int, input().split())) for _ in range(5)]
numbers = []
board_dict = {} # key: 숫자, value: 위치

for _ in range(5):
    numbers += list(map(int, input().split()))

for i in range(5):
    for j in range(5):
        board_dict[board[i][j]] = (i, j)

print(solution(board_dict, numbers))