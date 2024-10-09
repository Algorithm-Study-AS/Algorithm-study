# n일 동안 상담, 상담 기간 t, 금액 p
# 최대 수익 구하기

import sys

def solution(n, counseling):
    d = [0] * (n+1)

    for i in range(n):
        t, p = counseling[i]

        if i+t <= n:
            d[i+t] = max(d[i+t], d[i]+p)
        
        d[i+1] = max(d[i+1], d[i])

    return d[n]

def main():
    n = int(sys.stdin.readline())
    counseling = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    print(solution(n, counseling))

if __name__ == "__main__":
    main()