# 2행 n열의 스티커가 있을 때, 뗄 수 있는 스티커 점수의 최댓값
# 뗀 스티커의 상하좌우에 있는 스티커는 쓸 수 없다.

def solution(n, sticker):

    if n > 1: # 대각선끼리 더해준다.
        d[0][1] += d[1][0]
        d[1][1] += d[0][0]

    for i in range(2, n): # 마지막 열의 스티커는 항상 선택된다.
        d[0][i] += max(d[1][i-1], d[1][i-2])
        d[1][i] += max(d[0][i-1], d[0][i-2])
    
    return max(d[0][-1], d[1][-1])

T = int(input())

for _ in range(T):
    n = int(input())
    d = [list(map(int, input().split())) for _ in range(2)]
    
    print(solution(n, d))