# n가지 종류의 동전을 사용해서 가치의 합이 k가 되는 동전의 최소 개수

from sys import stdin

def solution(k, values):
    d = [10001] * (k+1)
    d[0] = 0
    
    for v in values:
        for i in range(v, k+1):
            d[i] = min(d[i], d[i-v] + 1)

    if d[k] == 10001:
        d[k] = -1

    return d[k]

def main():
    n, k = map(int, stdin.readline().split())
    values = [int(stdin.readline()) for _ in range(n)]

    print(solution(k, values))

if __name__ == "__main__":
    main()