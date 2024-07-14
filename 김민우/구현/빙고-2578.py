def check_bingo(board):
    bingo_count=0
    # 가로 검사
    for i in range(5):
        if board[i].count(0)==5:
            bingo_count+=1
    # 세로 검사
    for i in range(5):
        if all(board[row][i]==0 for row in range(5)):
            bingo_count+=1
    
    # 대각선 검사
    if all(board[i][i]==0 for i in range(5)):
        bingo_count+=1
    if all(board[i][4-i]==0 for i in range(5)):
        bingo_count+=1
    
    if bingo_count>=3:
        return True
    return False
    
board=[]

for i in range(5):
    row=list(map(int,input().split()))
    board.append(row)

moderator=[]
result=0
for i in range(5):
    moderator+=list(map(int,input().split()))

for i in moderator:
    result+=1
    for row in range(5):
        for col in range(5):
            if board[row][col]==i:
                board[row][col]=0
    if check_bingo(board):
        print(result)
        break
