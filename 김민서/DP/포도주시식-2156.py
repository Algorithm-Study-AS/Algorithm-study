# n개의 포도주 중 최대로 마실 수 있는 포도주의 양을 출력
# 연속으로 놓여 있는 3잔을 모두 마실 수 없다.

def solution(n, wine):
    d = [0] * 10001
    d[1] = wine[1]

    if n > 1:
        d[2] = d[1] + wine[2]
    
    if n > 2:
        d[3] = max(d[2], d[1]+wine[3], wine[2]+wine[3])

    for i in range(4, n+1):
        d[i] = max(d[i-1], d[i-2]+wine[i], d[i-3]+wine[i-1]+wine[i])
    
    return d[n]
    
def main():
    n = int(input())
    wine = [0] + [int(input()) for _ in range(n)]

    print(solution(n, wine))

if __name__ == "__main__":
    main()